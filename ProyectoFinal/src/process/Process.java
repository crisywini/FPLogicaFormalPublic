package process;

import exceptions.ParenthesisIncorrectException;
import model.Molecule;

public class Process {
	/**
	 * Metodo que permite convertir una formula String en una Molecule
	 * 
	 * @param formula en String
	 * @return la formula pero en formato Molecula
	 * @throws ParenthesisIncorrectException si la formula no tiene la misma
	 *                                       cantidad de parentesis de apertura que
	 *                                       de cerrar
	 */
	public static Molecule parseString(String formula) throws ParenthesisIncorrectException {
		Molecule mol = new Molecule();
		for (int i = 0; i < formula.length(); i++) {
			if (formula.charAt(i) == 'v' || formula.charAt(i) == '^' || formula.charAt(i) == 'C'
					|| formula.charAt(i) == 'E')
				mol.addOperator(formula.charAt(i));
			else if (formula.charAt(i) >= 97 && formula.charAt(i) <= 122)
				mol.addAtom(formula.charAt(i));
		}
		if (!isParenthesisOK(formula))
			throw new ParenthesisIncorrectException("The formula has: " + countLeftParenthesis(formula)
					+ " left parenthesis and: " + countRightParenthesis(formula) + " right parenthesis");
		return mol;
	}

	/**
	 * Metodo que permite contar la cantidad de parentesis izquierdos que posee una
	 * formula
	 * 
	 * @param formula un String
	 * @return un entero con la cantidad de parentesis izquierdos
	 */
	public static int countLeftParenthesis(String formula) {
		int counter = 0;
		for (int i = 0; i < formula.length(); i++) {
			if (formula.charAt(i) == '(')
				counter++;
		}
		return counter;
	}

	/**
	 * Metodo que permite contar la cantidad de parentesis derechos que posee una
	 * formula
	 * 
	 * @param formula un String
	 * @return un entero con la cantiad de parentesis derechos
	 */
	public static int countRightParenthesis(String formula) {
		int counter = 0;
		for (int i = 0; i < formula.length(); i++) {
			if (formula.charAt(i) == ')')
				counter++;
		}
		return counter;
	}

	/**
	 * Metodo que permite verificar si una formula tiene la misma cantidad de
	 * parentesis izquierdos y derechos
	 * 
	 * @param formula
	 * @return
	 */
	public static boolean isParenthesisOK(String formula) {
		return countLeftParenthesis(formula) == countRightParenthesis(formula);
	}

	public String getNormalDisjunctiveForm(String formula) {
		String disjunctiveForm = formula.substring(0, formula.length());
		if (disjunctiveForm.contains("E")) {
			// Metodo para elminar equivalencia
		}

		return "";
	}

	/**
	 * Metodo que permite eliminar el simbolo de equivalencia de una formula
	 * proposicional
	 * 
	 * @param formula la formula proposicional
	 * @return la nueva formula aplicando el axioma 9
	 */
	public static String removeEquivalence(String formula) {
		boolean stopper = false;
		String alpha = "";
		String theta = "(";
		int counter = 0;
		int auxiliar = 0;
		int changer = 0;

		for (int i = formula.indexOf("E") - 1; i >= 0 && !stopper; i--) {
			if (formula.charAt(i) == ')') {
				counter++;
			}
			if (formula.charAt(i) == '(') {
				counter--;
				changer++;

			}
			if (counter == 0 && changer != 0) {
				for (int j = i; j < formula.indexOf("E"); j++) {
					alpha += formula.charAt(j);
				}
				stopper = true;
			}
		}
		changer = 0;
		auxiliar = formula.indexOf("E") + 3;
		counter = 1;
		stopper = false;
		for (int i = auxiliar; i < formula.length() && !stopper; i++) {
			if (formula.charAt(i) == '(') {
				counter++;
				changer++;
			}
			if (formula.charAt(i) == ')')
				counter--;
			if (counter == 0 && changer != 0) {
				stopper = true;
			}
			theta += formula.charAt(i);
		}
		String newFormula = "";
		auxiliar = getMainOperatorIndex(formula);
		if (getMainOperator(formula).equals("E")) {
			newFormula = "(" + alpha + "C" + theta + ")^(" + theta + "C" + alpha + ")";
		} else {
			newFormula += "(" + alpha + "C" + theta + ")^(" + theta + "C" + alpha + ")";
			for (int i = auxiliar; i < formula.length(); i++) {
				newFormula += formula.charAt(i);
			}
		}
		return newFormula;
	}

	public static String removeCondicional(String formula) {
		boolean stopper = false;
		String alpha = "";
		String theta = "(";
		int counter = 0;
		int auxiliar = 0;
		int changer = 0;

		for (int i = formula.indexOf("C") - 1; i >= 0 && !stopper; i--) {
			if (formula.charAt(i) == ')') {
				counter++;
			}
			if (formula.charAt(i) == '(') {
				counter--;
				changer++;

			}
			if (counter == 0 && changer != 0) {
				for (int j = i; j < formula.indexOf("C"); j++) {
					alpha += formula.charAt(j);
				}
				stopper = true;
			}
		}
		changer = 0;
		auxiliar = formula.indexOf("C") + 3;
		counter = 1;
		stopper = false;
		for (int i = auxiliar; i < formula.length() && !stopper; i++) {
			if (formula.charAt(i) == '(') {
				counter++;
				changer++;
			}
			if (formula.charAt(i) == ')')
				counter--;
			if (counter == 0 && changer != 0) {
				stopper = true;
			}
			theta += formula.charAt(i);
		}
		String newFormula = "";
		auxiliar = getMainOperatorIndex(formula);
		if (getMainOperator(formula).equals("C")) {
			newFormula = "(~" + alpha + ")V(" + theta + ")";
		} else {
			newFormula += "((~" + alpha + ")V(" + theta + "))";
			for (int i = auxiliar; i < formula.length(); i++) {
				newFormula += formula.charAt(i);
			}
		}
		return newFormula;
	}

	public String applyMorgan1(String formula) {
		boolean stopper = false;
		String alpha = "";
		String theta = "(";
		int counter = 0;
		int auxiliar = 0;
		int changer = 0;

		for (int i = formula.indexOf("^") - 1; i >= 0 && !stopper; i--) {
			if (formula.charAt(i) == ')') {
				counter++;
			}
			if (formula.charAt(i) == '(') {
				counter--;
				changer++;

			}
			if (counter == 0 && changer != 0) {
				for (int j = i; j < formula.indexOf("^"); j++) {
					alpha += formula.charAt(j);
				}
				stopper = true;
			}
		}
		changer = 0;
		auxiliar = formula.indexOf("^") + 3;
		counter = 1;
		stopper = false;
		for (int i = auxiliar; i < formula.length() && !stopper; i++) {
			if (formula.charAt(i) == '(') {
				counter++;
				changer++;
			}
			if (formula.charAt(i) == ')')
				counter--;
			if (counter == 0 && changer != 0) {
				stopper = true;
			}
			theta += formula.charAt(i);
		}
		String newFormula = "";
		auxiliar = getMainOperatorIndex(formula);
		if (getMainOperator(formula).equals("^")) {
			newFormula = "(~" + alpha + ")V(" + theta + ")";
		} else {
			newFormula += "((~" + alpha + ")V(" + theta + "))";
			for (int i = auxiliar; i < formula.length(); i++) {
				newFormula += formula.charAt(i);
			}
		}
		return newFormula;
	}

	public static int getMainOperatorIndex(String formula) {
		int index = -1;
		int counter = 0;
		boolean isChanging = false;
		boolean stop = false;
		for (int i = 0; i < formula.length() && !stop; i++) {
			if (formula.charAt(i) == '(')
				counter++;
			if (formula.charAt(i) == ')') {
				counter--;
				isChanging = true;
			}
			if (counter == 0 && isChanging) {
				index = i;
				stop = true;
			}
		}
		return index + 1;
	}

	public static String getMainOperator(String formula) {
		String mainOperator = formula.substring(getMainOperatorIndex(formula), getMainOperatorIndex(formula) + 1);
		return mainOperator;
	}

	public static char getMainOperatorChar(String formula) {
		return formula.charAt(getMainOperatorIndex(formula));
	}

}

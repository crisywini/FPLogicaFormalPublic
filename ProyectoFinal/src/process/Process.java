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
	 * @param formula
	 * @return
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
	 * @param formula
	 * @return
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

}

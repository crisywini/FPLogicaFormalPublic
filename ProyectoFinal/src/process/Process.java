package process;

import java.util.ArrayList;

public class Process {

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
		auxiliar = formula.indexOf("C") + 2;
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
		theta = theta.substring(0, theta.length() - 1);
		String newFormula = "";
		auxiliar = getMainOperatorIndex(formula);
		if (getMainOperator(formula).equals("C")) {
			newFormula = "(~" + alpha + ")V(" + theta + ")";
		} else if (getMainOperatorIndex(formula) > formula.indexOf("C")) {
			newFormula += "((~" + alpha + ")V(" + theta + "))";
			for (int i = auxiliar; i < formula.length(); i++) {
				newFormula += formula.charAt(i);
			}
		} else {
			for (int i = 0; i < getMainOperatorIndex(formula) + 1; i++) {
				newFormula += formula.charAt(i);
			}
			newFormula += "(~" + alpha + ")V(" + theta + ")";
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

	/**
	 * Metodo que permite verificar si una formula en FNC es satisfacible o
	 * insaticfacible mediante el metodo de Resolucion
	 * 
	 * @param clausulas  en FNC de la formula
	 * @param utilizados clausulas utilizadas en la formula
	 * @return true si es insatisfacible y false si es satisfacible.
	 */
	public static boolean isInsatisfacible(ArrayList<ArrayList<String>> clausulas,
			ArrayList<ArrayList<String>> utilizados) {

		System.out.println("clausulas " + clausulas.toString());
		for (int i = 0; i < clausulas.size(); i++) {
			for (int j = 1 + i; j < clausulas.size(); j++) {
				System.out.println("clausulas  en el segundo for" + clausulas.toString());
				Object[] res = hacerResolucion(clausulas.get(i), clausulas.get(j));
				System.out.println("res " + res[0]);
				if (res[0].equals(true) && !utilizados.contains(clausulas.get(i))
						&& !utilizados.contains(clausulas.get(j))) {

					System.err.println("hizo resolucion entre " + clausulas.get(i) + " y " + clausulas.get(j));
					utilizados.add(clausulas.get(i));
					utilizados.add(clausulas.get(j));
					clausulas.add((ArrayList<String>) res[1]);

					boolean nose = isInsatisfacible(clausulas, utilizados);
					if (nose == true) {
						return nose;
					}
					utilizados.remove(clausulas.get(j));
					utilizados.remove(clausulas.get(i));
					clausulas.remove((ArrayList<String>) res[1]);
					System.out.println("clausulas despues del if " + clausulas.toString());
				}
			}
		}
		System.out.println("clausulas al final " + clausulas.toString());
		if (isVacio(clausulas)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Metodo que permite verificar si el conjunto de clausulas contiene una
	 * clausula vacia
	 * 
	 * @param f conjunto de clausulas
	 * @return true si contiene una clausula vacia false en caso contrario
	 */
	public static boolean isVacio(ArrayList<ArrayList<String>> f) {
		for (int i = 0; i < f.size(); i++) {
			for (int j = 0; j < f.get(i).size(); j++) {
				if (f.get(i).get(j).equals(" ")) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Metodo que permite realizar resolucion entre dos formulas
	 * 
	 * @param formulaX
	 * @param formulaY
	 * @return un array de Object el cual tiene 3 elementos, el primero es si pudo
	 *         hacer resolucion y en caso de que llegue a dar true, genera las dos
	 *         formulas en sus dos siguientes campos disponibles
	 */
	public static Object[] hacerResolucion(ArrayList<String> formulaX, ArrayList<String> formulaY) {
		ArrayList<String> formula1 = (ArrayList<String>) formulaX.clone();
		ArrayList<String> formula2 = (ArrayList<String>) formulaY.clone();
		Object arreglo[] = { false, "", "" };
		System.out.println("formula 1 " + formula1.toString());
		System.out.println("formula 2 " + formula2.toString());
		for (int i = 0; i < formula1.size(); i++) {
			String clausula1 = formula1.get(i);
			for (int j = 0; j < formula2.size(); j++) {
				String clausula2 = formula2.get(j);
				Object[] data = esParComplementario(clausula1, clausula2);
				// System.out.println("es par complementario "+data[0]);
				if (data[0] != null) {
					if (data[0].equals(true)) {
						formula1.remove(i);
						formula2.remove(j);
						ArrayList<String> con = concat(formula1, formula2);
						if (con.isEmpty()) {
							con.add(" ");
						}
						arreglo[0] = true;
						arreglo[1] = con;
						arreglo[2] = data[1];

						return arreglo;
					}
				}
			}
		}
		return arreglo;
	}

	/**
	 * Metodo que permite concatenar dos arraylist
	 * 
	 * @param arraylist1
	 * @param arraylist2
	 * @return un arraylist sin elementos repetidos
	 */
	public static ArrayList<String> concat(ArrayList<String> arraylist1, ArrayList<String> arraylist2) {
		ArrayList<String> newArrayList = new ArrayList<String>();
		for (int i = 0; i < arraylist1.size(); i++) {
			newArrayList.add(arraylist1.get(i));
		}
		for (int i = 0; i < arraylist2.size(); i++) {
			if (!newArrayList.contains(arraylist2.get(i))) {
				newArrayList.add(arraylist2.get(i));
			}
		}
		return newArrayList;
	}

	/**
	 * Metodo que permite verificar si una formula tiene par complementario
	 * 
	 * @param clausula1
	 * @param clausula2
	 * @return un array de Object con la verificacion en 0 y en 1 la formula atomica
	 */
	public static Object[] esParComplementario(String clausula1, String clausula2) {
		System.out.println("");
		Object[] data = new Object[2];
		if (clausula1.length() == 2) {
			String clausulaAux = clausula1.substring(1, 2);
			if (clausulaAux.equals(clausula2)) {
				data[0] = true;
				data[1] = clausula2;
				return data;
			}
		} else {
			if (clausula2.length() == 2) {
				String clausulaAux = clausula2.substring(1, 2);
				if (clausulaAux.equals(clausula1)) {
					data[0] = true;
					data[1] = clausulaAux;
					return data;
				}
			}
		}
		return data;
	}

	public static String getMainOperator(String formula) {
		String mainOperator = formula.substring(getMainOperatorIndex(formula), getMainOperatorIndex(formula) + 1);
		return mainOperator;
	}

	public static char getMainOperatorChar(String formula) {
		return formula.charAt(getMainOperatorIndex(formula));
	}

}

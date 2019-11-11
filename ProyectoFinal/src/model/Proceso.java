package model;

public class Proceso 
{
	/**
	 * Metodo que permite contar la cantidad de parentesis izquierdos que posee una formula
	 * @param formula
	 * @return
	 */
	public int countLeftParenthesis(String formula)
	{
		int counter = 0;
		for (int i = 0; i < formula.length(); i++) {
			if(formula.charAt(i)=='(')
				counter++;
		}
		return counter;
	}
	/**
	 * Metodo que permite contar la cantidad de parentesis derechos que posee una formula
	 * @param formula
	 * @return
	 */
	public int countRightParenthesis(String formula)
	{
		int counter = 0;
		for (int i = 0; i < formula.length(); i++) {
			if(formula.charAt(i)==')')
				counter++;
		}
		return counter;
	}
	/**
	 * Metodo que permite verificar si una formula tiene la misma cantidad de parentesis izquierdos y derechos
	 * @param formula
	 * @return
	 */
	public boolean isParenthesisOK(String formula)
	{
		return countLeftParenthesis(formula)==countRightParenthesis(formula);
	}
	/**
	 * Metodo que permite verificar si la formula es un atomo(Sin tener en cuenta el exceso de parentesis)
	 * @param formula
	 * @return
	 */
	public boolean isAtom(String formula)
	{
		boolean isAtom = true;
		if(formula.contains("V")||formula.contains("^")||formula.contains("")|formula.contains("↔")||formula.contains("¬"))
			isAtom = false;;
		return isAtom;
	}
	/**
	 * Metodo que permite verificar si un atomo esta escrito correctamente sin parentesis
	 * @param formula
	 * @return
	 */
	public boolean isAtomOk(String formula)
	{
		return countLeftParenthesis(formula)==0&&countRightParenthesis(formula)==0;
	}
	/**
	 * Metodo que permite verificar si una molecula esta bien escrita 
	 * Corregir la parte de los digitos y demas cosas entre parentesis
	 * @param formula 
	 * @return
	 */
	public boolean isMolOk(String formula)
	{
		boolean isMol = !isAtom(formula);
		if(isMol)
		{
			isMol = isParenthesisOK(formula);
			if(isMol)
			{
				if(Character.isLetterOrDigit(formula.charAt(0))||Character.isLetterOrDigit(formula.charAt(formula.length()-1)))
					isMol = false;
				for (int i = 0; i < formula.length()-1; i++) 
				{
					if(formula.charAt(i)==')')
						if(Character.isLetterOrDigit(formula.charAt(i+1)))
							isMol = false;
				}
				for (int i = formula.length()-1; i>1; i--) 
				{
					if(formula.charAt(i)=='(')
						if(Character.isLetterOrDigit(formula.charAt(i-1)))
							isMol = false;
				}
			}
		}
		else
			isMol = false;
		return isMol;
	}
	/**
	 * Metodo que verifica si una formula tiene espacios 
	 * @param formula
	 * @return
	 */
	public boolean areSpaces(String formula)
	{
		boolean isSpaces = false;
		for (int i = 0; i < formula.length()&&!isSpaces; i++) {
			if(formula.charAt(i)==' ')
				isSpaces = true;
		}
		return isSpaces;
	}
	/**
	 * Metodo que verifica si hay letras seguidas en una formula
	 * @param formula
	 * @return
	 */
	public boolean areLettersInARow(String formula)
	{
		boolean areLettersInARow = false;
		for (int i = 0; i < formula.length()-1&&!areLettersInARow; i++) {
			if(Character.isLetter(formula.charAt(i))&&Character.isLetter(formula.charAt(i+1)))
				areLettersInARow = true;
		}
		return areLettersInARow;
	}
	
}
package application;

public interface IProcessControl 
{
	public int countLeftParenthesis(String formula);
	public int countRightParenthesis(String formula);
	public boolean isParenthesisOK(String formula);
	public boolean isAtom(String formula);
	public boolean isAtomOk(String formula);
	public boolean isMolOk(String formula);
	public boolean areSpaces(String formula);
	public boolean areLettersInARow(String formula);

}

package exceptions;

public class ParenthesisIncorrectException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ParenthesisIncorrectException(String errorMessage) {
		super(errorMessage);
	}

}

package application;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class MenuController {

	private PrincipalController bigView;
	@FXML
	private TextField addFormulasField;

	@FXML
	private TextArea formulasArea;

	private String formula = "";

	@FXML
	void handleAddButton() {
		formulasArea.getCaretPosition();// para la posicion, para insertarla se inserta con insertText()
		addFormulasField.getCaretPosition();
		if (isInputValid()) {
			String auxiliar = formulasArea.getText();
			if (auxiliar.length() != 0) {
				formulasArea.setText(auxiliar + "\n" + addFormulasField.getText());
			} else {
				formulasArea.setText(addFormulasField.getText());
			}
			addFormulasField.setText("");
		}
	}

	@FXML
	void handleBiconditionalButton() {
		formula += "( )↔( )";
		String auxiliar = addFormulasField.getText();
		if (auxiliar.length() != 0) {
			boolean isSpace = false;
			for (int i = 0; i < auxiliar.length() && !isSpace; i++) {
				if (auxiliar.charAt(i) == ' ') {
					isSpace = true;
					addFormulasField
							.setText(auxiliar.substring(0, i) + formula + auxiliar.substring(i + 1, auxiliar.length()));
				}
			}
		} else
			addFormulasField.setText(getFormula());
		setFormula("");
	}

	@FXML
	void handleConditionalButton() {
		formula += "( )→( )";
		String auxiliar = addFormulasField.getText();
		if (auxiliar.length() != 0) {
			boolean isSpace = false;
			for (int i = 0; i < auxiliar.length() && !isSpace; i++) {
				if (auxiliar.charAt(i) == ' ') {
					isSpace = true;
					addFormulasField
							.setText(auxiliar.substring(0, i) + formula + auxiliar.substring(i + 1, auxiliar.length()));
				}
			}
		} else
			addFormulasField.setText(getFormula());
		setFormula("");
	}

	@FXML
	void handleConjuctionButton() {
		formula += "( )^( )";
		String auxiliar = addFormulasField.getText();
		if (auxiliar.length() != 0) {
			boolean isSpace = false;
			for (int i = 0; i < auxiliar.length() && !isSpace; i++) {
				if (auxiliar.charAt(i) == ' ') {
					isSpace = true;
					addFormulasField
							.setText(auxiliar.substring(0, i) + formula + auxiliar.substring(i + 1, auxiliar.length()));
				}
			}
		} else
			addFormulasField.setText(getFormula());
		setFormula("");

	}

	@FXML
	void handleDisjunctionButton() {
		formula += "( )V( )";
		String auxiliar = addFormulasField.getText();
		if (auxiliar.length() != 0) {
			boolean isSpace = false;
			for (int i = 0; i < auxiliar.length() && !isSpace; i++) {
				if (auxiliar.charAt(i) == ' ') {
					isSpace = true;
					addFormulasField
							.setText(auxiliar.substring(0, i) + formula + auxiliar.substring(i + 1, auxiliar.length()));
				}
			}
		} else
			addFormulasField.setText(getFormula());
		setFormula("");

	}

	@FXML
	void handleNotButton() {
		formula += "¬( )";
		String auxiliar = addFormulasField.getText();
		if (auxiliar.length() != 0) {
			boolean isSpace = false;
			for (int i = 0; i < auxiliar.length() && !isSpace; i++) {
				if (auxiliar.charAt(i) == ' ') {
					isSpace = true;
					addFormulasField
							.setText(auxiliar.substring(0, i) + formula + auxiliar.substring(i + 1, auxiliar.length()));
				}
			}
		} else
			addFormulasField.setText(getFormula());
		setFormula("");

	}

	@FXML
	void handlePButton() {
		formula += "p";
		String auxiliar = addFormulasField.getText();
		if (auxiliar.length() != 0) {
			boolean isSpace = false;
			for (int i = 0; i < auxiliar.length() && !isSpace; i++) {
				if (auxiliar.charAt(i) == ' ') {
					isSpace = true;
					addFormulasField
							.setText(auxiliar.substring(0, i) + formula + auxiliar.substring(i + 1, auxiliar.length()));
				}
			}
		} else
			addFormulasField.setText(getFormula());
		setFormula("");

	}

	@FXML
	void handleQButton() {
		formula += "q";
		String auxiliar = addFormulasField.getText();
		if (auxiliar.length() != 0) {
			boolean isSpace = false;
			for (int i = 0; i < auxiliar.length() && !isSpace; i++) {
				if (auxiliar.charAt(i) == ' ') {
					isSpace = true;
					addFormulasField
							.setText(auxiliar.substring(0, i) + formula + auxiliar.substring(i + 1, auxiliar.length()));
				}
			}
		} else
			addFormulasField.setText(getFormula());
		setFormula("");

	}

	@FXML
	void handleRButton() {
		formula += "r";
		String auxiliar = addFormulasField.getText();
		if (auxiliar.length() != 0) {
			boolean isSpace = false;
			for (int i = 0; i < auxiliar.length() && !isSpace; i++) {
				if (auxiliar.charAt(i) == ' ') {
					isSpace = true;
					addFormulasField
							.setText(auxiliar.substring(0, i) + formula + auxiliar.substring(i + 1, auxiliar.length()));
				}
			}
		} else
			addFormulasField.setText(getFormula());
		setFormula("");

	}

	@FXML
	void handleSButton() {
		formula += "s";
		String auxiliar = addFormulasField.getText();
		if (auxiliar.length() != 0) {
			boolean isSpace = false;
			for (int i = 0; i < auxiliar.length() && !isSpace; i++) {
				if (auxiliar.charAt(i) == ' ') {
					isSpace = true;
					addFormulasField
							.setText(auxiliar.substring(0, i) + formula + auxiliar.substring(i + 1, auxiliar.length()));
				}
			}
		} else
			addFormulasField.setText(getFormula());
		setFormula("");

	}

	@FXML
	void handleTButton() {
		formula += "t";
		String auxiliar = addFormulasField.getText();
		if (auxiliar.length() != 0) {
			boolean isSpace = false;
			for (int i = 0; i < auxiliar.length() && !isSpace; i++) {
				if (auxiliar.charAt(i) == ' ') {
					isSpace = true;
					addFormulasField
							.setText(auxiliar.substring(0, i) + formula + auxiliar.substring(i + 1, auxiliar.length()));
				}
			}
		} else
			addFormulasField.setText(getFormula());
		setFormula("");

	}

	@FXML
	void handleUButton() {
		formula += "u";
		String auxiliar = addFormulasField.getText();
		if (auxiliar.length() != 0) {
			boolean isSpace = false;
			for (int i = 0; i < auxiliar.length() && !isSpace; i++) {
				if (auxiliar.charAt(i) == ' ') {
					isSpace = true;
					addFormulasField
							.setText(auxiliar.substring(0, i) + formula + auxiliar.substring(i + 1, auxiliar.length()));
				}
			}
		} else
			addFormulasField.setText(getFormula());
		setFormula("");

	}

	@FXML
	void initialize() {

	}

	public PrincipalController getBigView() {
		return bigView;
	}

	public void setBigView(PrincipalController bigView) {
		this.bigView = bigView;
	}

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	public boolean isInputValid() {
		boolean isValid = false;
		String errorMessage = "";
		if (addFormulasField.getText() == null || addFormulasField.getText().length() == 0)
			errorMessage += "The entry of formulas is empty\n";
		else {
			
			if(getBigView().getMain().areSpaces(addFormulasField.getText()))
				errorMessage += "There are spaces in the formula\n";
			if(!getBigView().getMain().isAtom(addFormulasField.getText()))
			{
				if(!getBigView().getMain().isMolOk(addFormulasField.getText()))
					errorMessage += "The molecular formula is not ok\n";
			}
			if(getBigView().getMain().areLettersInARow(addFormulasField.getText()))
				errorMessage += "There are things that I do not understand in the formula\n";
			
			if (getBigView().getMain().isAtom(addFormulasField.getText())) {
				if (!getBigView().getMain().isAtomOk(addFormulasField.getText()))
					errorMessage += "The Atom is not correct\n";
			}
		}
		if (errorMessage.length() != 0) {
			bigView.showAlert(errorMessage, "Warning!", AlertType.WARNING);
		} else
			isValid = true;
		return isValid;
	}
}

package application;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import process.FormulaBienFormada;
import process.Process;

public class MenuController {
	private PrincipalController principal;

	@FXML
	private TextArea addFormulasArea;

	@FXML
	private Label menuUserLabel;

	@FXML
	private TextArea formulasArea;

	@FXML
	private Button verifyButton;
	private ArrayList<String> formula = new ArrayList<String>();
	private ArrayList<ArrayList<String>> clausulas;
	private ArrayList<String> formulas = new ArrayList<String>();
	private String conclusion;
	private FormulaBienFormada fbf;

	@FXML
	void handleAddButton() {
		if (isInputValid()) {
			String formula = addFormulasArea.getText();
			String choose = principal.chooseType();
			if (choose.equals("premisa")) {
				formulasArea.setText(formula);
				formulas.add(formula);
			} else {
				formulasArea.setText("-----------------------\n" + formula);
				setConclusion("¬(" + formula + ")");
				addFormulasArea.setEditable(false);
				formulas.add(getConclusion());
			}
		}
	}

	@FXML
	void handleVerifyButton() {
		if (formulas.size() > 0) {
			String formula = addFormulasArea.getText();
			if (Process.isParenthesisExces(formula)) {
				fbf = new FormulaBienFormada(formula);
				clausulas = Process.concatClausules(formulas);
				if (Process.isInsatisfacible(clausulas, new ArrayList<ArrayList<String>>())) {
					principal.showAlert(
							"El argumento es valido porque:\n\nClausulas resultantes al realizar resolucion:\n\n "
									+ clausulas,
							"Resultado", AlertType.INFORMATION);
				}
				addFormulasArea.setText("");
				addFormulasArea.setEditable(true);
				formulasArea.setText("");
			}
		}
	}

	private boolean esPosicionValida(int pos) {
		boolean flag = false;

		String formula = addFormulasArea.getText();
		if (!formula.isEmpty()) {
			if (pos > 0 && pos < formula.length()) {
				if (formula.charAt(pos - 1) == '(' && formula.charAt(pos) == ')') {
					flag = true;
				}
			}
		} else {
			flag = true;
		}

		return flag;
	}

	@FXML
	void handleBiconditionalButton() {
		int pos = addFormulasArea.getCaretPosition();
		if (esPosicionValida(pos)) {
			stringaArray();
			formula.add(pos, "()↔()");
			arrayaString();
			addFormulasArea.requestFocus();
			addFormulasArea.positionCaret(pos + 1);
		}
	}

	@FXML
	void handleConditionalButton() {
		int pos = addFormulasArea.getCaretPosition();
		if (esPosicionValida(pos)) {
			stringaArray();
			formula.add(pos, "()→()");
			arrayaString();
			addFormulasArea.requestFocus();
			addFormulasArea.positionCaret(pos + 1);
		}
	}

	@FXML
	void handleConjuctionButton() {
		int pos = addFormulasArea.getCaretPosition();
		if (esPosicionValida(pos)) {
			stringaArray();
			formula.add(pos, "()ʌ()");
			arrayaString();
			addFormulasArea.requestFocus();
			addFormulasArea.positionCaret(pos + 1);
		}
	}

	@FXML
	void handleDisjunctionButton() {
		int pos = addFormulasArea.getCaretPosition();
		if (esPosicionValida(pos)) {
			stringaArray();
			formula.add(pos, "()v()");
			arrayaString();
			addFormulasArea.requestFocus();
			addFormulasArea.positionCaret(pos + 1);
		}
	}

	@FXML
	void handleNotButton() {
		int pos = addFormulasArea.getCaretPosition();
		if (esPosicionValida(pos)) {
			stringaArray();
			formula.add(pos, "¬()");
			arrayaString();
			addFormulasArea.requestFocus();
			addFormulasArea.positionCaret(pos + 2);
		}

	}

	private void stringaArray() {
		formula = new ArrayList<>();
		for (char aux : addFormulasArea.getText().toCharArray()) {
			formula.add(String.valueOf(aux));
		}
	}

	private void arrayaString() {
		addFormulasArea.setText("");
		String cadena = "";
		for (String aux2 : formula) {
			cadena += aux2;
		}
		addFormulasArea.setText(cadena);
	}

	public PrincipalController getPrincipal() {
		return principal;
	}

	public void setPrincipal(PrincipalController principal) {
		this.principal = principal;
	}

	public void updateLanguage() {
		menuUserLabel.setText(getPrincipal().getMain().getTextMessage("Text_MenuUserLabel"));
		verifyButton.setText(getPrincipal().getMain().getTextMessage("Text_VerifyButton"));
	}

	public boolean isInputValid() {
		boolean isValid = false;
		String errorMessage = "";
		if (addFormulasArea.getText() == null || addFormulasArea.getText().length() == 0)
			errorMessage += "Debes ingresar la formula!\n(Must input the formula!)\n";
		else if (!Process.isParenthesisExces(addFormulasArea.getText()))
			errorMessage += "La formula no tiene exceso de parentesis!\n(The formula does not have parenthesis excess)";
		if (errorMessage.length() == 0)
			isValid = true;
		else
			principal.showAlert(errorMessage, "ERROR", AlertType.ERROR);
		return isValid;
	}

	public String getConclusion() {
		return conclusion;
	}

	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
	}
}

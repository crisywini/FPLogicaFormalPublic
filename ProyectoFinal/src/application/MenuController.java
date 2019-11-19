package application;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import process.FormulaBienFormada;

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
	private FormulaBienFormada fbf;

	@FXML
	void handleAddButton() {
		if(isInputValid())
		{
			
		}

	}

	@FXML
	void handleVerifyButton() {
		if (isInputValid()) {
			String formula = addFormulasArea.getText();
			fbf = new FormulaBienFormada(formula);
			principal.showAlert(fbf.getClausules(formula).toString() + "", "", AlertType.INFORMATION);

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
			errorMessage += "Debes ingresar la formula!";
		if (errorMessage.length() == 0)
			isValid = true;
		else
			principal.showAlert(errorMessage, "ERROR", AlertType.ERROR);
		return isValid;
	}
}

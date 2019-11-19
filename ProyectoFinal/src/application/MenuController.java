package application;

import java.util.ArrayList;

import exceptions.NotFbfException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
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
	@FXML
	private Button disjunctionButton;

	@FXML
	private Button conditionalButton;

	@FXML
	private Button conjuctionButton;

	@FXML
	private Button biconditionalButton;

	@FXML
	private Button notButton;
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
				String auxiliar = formulasArea.getText();
				formulasArea.setText(auxiliar + "\n" + formula);
				formulas.add(formula);
			} else {
				String auxiliar = formulasArea.getText() + "\n---------\n" + formula + "\n";
				formulasArea.setText(auxiliar);
				setConclusion(formula);
				addFormulasArea.setEditable(false);
				biconditionalButton.setDisable(true);
				conditionalButton.setDisable(true);
				conjuctionButton.setDisable(true);
				disjunctionButton.setDisable(true);
				notButton.setDisable(true);
				formulas.add(getConclusion());
			}
			addFormulasArea.setText("");
		}
	}

	@FXML
	void handleVerifyButton() {
		if (formulas.size() > 0) {
			String formula = addFormulasArea.getText();
			setFbf(new FormulaBienFormada(formula));
			clausulas = Process.concatClausules(formulas);
			if (Process.isInsatisfacible(clausulas, new ArrayList<ArrayList<String>>())) {
				principal.showAlert(
						"El conjunto de premisas es insatisfacible:\n(The premises set is satisfacible)\nClausulas resultantes al realizar resolucion:\n(Resulting clauses making resolution)\n "
								+ clausulas,
						"Resultado", AlertType.INFORMATION);
			} else {
				principal.showAlert(
						"EL conjunto de premisas es satisfacible:\n(The premises set is satisfacible)\nClausulas resultantes al realizar resolucion:\n(Resulting clauses making resolution)\n "
								+ clausulas,
						"Resultado", AlertType.INFORMATION);
			}

			addFormulasArea.setText("");
			addFormulasArea.setEditable(true);
			formulasArea.setText("");
			clausulas.clear();
			formulas.clear();
			this.formula.clear();
			biconditionalButton.setDisable(false);
			conditionalButton.setDisable(false);
			conjuctionButton.setDisable(false);
			disjunctionButton.setDisable(false);
			notButton.setDisable(false);

		} else {
			principal.showAlert("Debes ingresar alguna formula\n(You must input some formula)", "ADVERTENCIA(WARNING)",
					AlertType.WARNING);
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
		else
			try {
				if (!Process.isFbf(addFormulasArea.getText()))
					errorMessage += "La formula no esta bien formada\nThe formula is not GFF";
			} catch (NotFbfException e) {
				errorMessage += e.getMessage() + "\n";

			}
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

	public FormulaBienFormada getFbf() {
		return fbf;
	}

	public void setFbf(FormulaBienFormada fbf) {
		this.fbf = fbf;
	}
}

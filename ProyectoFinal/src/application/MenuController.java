package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MenuController {
	private PrincipalController principal;

	@FXML
	private TextField addFormulasField;

	@FXML
	private Label menuUserLabel;

	@FXML
	private TextArea formulasArea;

	@FXML
	private Button verifyButton;

	@FXML
	void handleFormulasField(ActionEvent event) {

	}

	@FXML
	void handleAddButton() {

	}

	@FXML
	void handleBiconditionalButton() {

	}

	@FXML
	void handleConditionalButton() {

	}

	@FXML
	void handleConjuctionButton() {

	}

	@FXML
	void handleDisjunctionButton() {

	}

	@FXML
	void handleNotButton() {

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
}

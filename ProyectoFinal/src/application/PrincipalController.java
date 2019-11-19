package application;

import java.util.Optional;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import main.MainApp;

public class PrincipalController {

	private MainApp main;
	@FXML
	private BorderPane principalPane;
	private Stage primaryStage;
	AnchorPane menuPane;
	MenuController menuController;

	public BorderPane getPrincipalPane() {
		return principalPane;
	}

	public void setPrincipalPane(BorderPane principalPane) {
		this.principalPane = principalPane;
	}

	@FXML
	void initialize() {
	}

	public void loadMenu() {
		if (menuPane == null) {
			try {
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(MainApp.class.getResource("../view/MenuView.fxml"));
				menuPane = (AnchorPane) loader.load();
				menuController = loader.getController();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		menuController.setPrincipal(this);
		menuController.updateLanguage();

		principalPane.setCenter(menuPane);
	}

	public MainApp getMain() {
		return main;
	}

	public void setMain(MainApp main) {
		this.main = main;
	}

	public void showAlert(String message, String title, AlertType type) {
		Alert alert = new Alert(type);
		alert.initOwner(primaryStage);
		alert.setContentText(message);
		alert.setHeaderText("");
		alert.setTitle(title);
		alert.showAndWait();
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	public String chooseType() {
		String idioma;
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("�Conclusi�n?�Premisa?(Conclusion?Premise?)");
		alert.setContentText("Elige como act�a la forma en el argumento\nChoose the way the formula acts");
		alert.setHeaderText("");
		ButtonType buttonTypeOne = new ButtonType("Premisa\nPremise");
		ButtonType buttonTypeTwo = new ButtonType("Conclusi�n\nConclusion");
		alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == buttonTypeOne)
			idioma = "premisa";
		else
			idioma = "conclusion";
		return idioma;
	}

	@FXML
	void handleEnglishMenu() {
		main.setLanguage("Ingles");
		loadMenu();
	}

	@FXML
	void handleSpanishMenu() {
		main.setLanguage("Espa�ol");
		loadMenu();
	}
}
package application;

import java.util.Optional;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class PrincipalController {

	private Main main;
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
				loader.setLocation(Main.class.getResource("../view/MenuView.fxml"));
				menuPane = (AnchorPane) loader.load();
				menuController = loader.getController();
				menuController.setPrincipal(this);
				menuController.updateLanguage();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		principalPane.setCenter(menuPane);
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
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
		alert.setTitle("Elige el idioma(Choose the language)");
		alert.setContentText("Elige el idioma para la applicaci�n\nChoose the language of the app");
		alert.setHeaderText("");
		ButtonType buttonTypeOne = new ButtonType("Premisa");
		ButtonType buttonTypeTwo = new ButtonType("Conclusi�n");
		alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == buttonTypeOne)
			idioma = "premisa";
		else
			idioma = "conclusion";
		return idioma;
	}
}
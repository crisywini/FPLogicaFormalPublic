package main;

import java.util.Locale;

import java.util.Optional;
import java.util.ResourceBundle;

import application.PrincipalController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;

/**
 * 
 * @author Lissette Quebrada Lancheros
 * @author Mario Ernesto Cuesta Colorado
 * @author Cristian Giovanny Sanchez Pineda
 *
 */
public class MainApp extends Application {
	private ResourceBundle messages;

	@Override
	public void start(Stage primaryStage) {
		setLanguage("Español");
		loadPrincipal(primaryStage);
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void loadPrincipal(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("../view/PrincipalView.fxml"));
			BorderPane principalPane = (BorderPane) loader.load();
			Scene scene = new Scene(principalPane);
			PrincipalController principal = loader.getController();
			principal.setMain(this);
			principal.setPrincipalPane(principalPane);
			principal.setPrimaryStage(primaryStage);
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
			principal.loadMenu();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String chooseLanguage() {
		String idioma;
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Elige el idioma(Choose the language)");
		alert.setContentText("Elige el idioma para la applicación\nChoose the language of the app");
		alert.setHeaderText("");
		ButtonType buttonTypeOne = new ButtonType("Español\nSpanish");
		ButtonType buttonTypeTwo = new ButtonType("Inglés\nEnglish");
		alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == buttonTypeOne)
			idioma = "Español";
		else
			idioma = "Inglés";
		return idioma;

	}

	public void setLanguage(String idiom) {
		Locale locale;
		String language, country;
		if (idiom.equals("Español")) {
			language = new String("es");
			country = new String("ES");
		} else {
			language = new String("en");
			country = new String("US");
		}
		locale = new Locale(language, country);
		messages = ResourceBundle.getBundle("resources/Etiquetas", locale);
	}

	public String getTextMessage(String text) {
		return messages.getString(text);
	}
}
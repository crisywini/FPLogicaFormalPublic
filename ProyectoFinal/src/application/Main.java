package application;

import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import model.Proceso;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;

/**
 * 
 * @author Crisi
 *
 */
public class Main extends Application implements IProcessControl {
	private Proceso myProcess;
	private ResourceBundle messages;

	@Override
	public void start(Stage primaryStage) {
		myProcess = new Proceso();
		String idiom = chooseLanguage();
		setLanguage(idiom);
		loadPrincipal(primaryStage);
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void loadPrincipal(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../view/PrincipalView.fxml"));
			BorderPane principalPane = (BorderPane) loader.load();
			Scene scene = new Scene(principalPane);
			PrincipalController principal = loader.getController();
			principal.setMain(this);
			principal.setPrincipalPane(principalPane);
			principal.setPrimaryStage(primaryStage);
			primaryStage.setScene(scene);
			primaryStage.getIcons().add(new Image(
					"file:///C:/Users/Crisi/Desktop/Proyectos_Java/Proyectos_Analisis/FormalLogicRepository/LogicProject/src/images/puzzle.png"));

			primaryStage.show();
			principal.loadMenu();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Proceso getMyProcess() {
		return myProcess;
	}

	public void setMyProcess(Proceso myProcess) {
		this.myProcess = myProcess;
	}

	public String chooseLanguage() {
		String idioma;
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Elige el idioma(Choose the language)");
		alert.setContentText("Elige el idioma para la applicaci�n\nChoose the language of the app");
		alert.setHeaderText("");
		ButtonType buttonTypeOne = new ButtonType("Espa�ol\nSpanish");
		ButtonType buttonTypeTwo = new ButtonType("Ingl�s\nEnglish");
		alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == buttonTypeOne) {
			idioma = "Espa�ol";
		} else
			idioma = "Ingl�s";
		return idioma;

	}

	public void setLanguage(String idiom) {
		Locale locale;
		String language, country;
		if (idiom.equals("Espa�ol")) {
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

	@Override
	public int countLeftParenthesis(String formula) {
		return getMyProcess().countLeftParenthesis(formula);
	}

	@Override
	public int countRightParenthesis(String formula) {
		return getMyProcess().countRightParenthesis(formula);
	}

	@Override
	public boolean isParenthesisOK(String formula) {
		return getMyProcess().isParenthesisOK(formula);
	}

	@Override
	public boolean isAtom(String formula) {
		return getMyProcess().isAtom(formula);
	}

	@Override
	public boolean isAtomOk(String formula) {
		return getMyProcess().isAtomOk(formula);
	}

	@Override
	public boolean isMolOk(String formula) {
		return getMyProcess().isMolOk(formula);
	}

	@Override
	public boolean areSpaces(String formula) {
		return getMyProcess().areSpaces(formula);
	}

	@Override
	public boolean areLettersInARow(String formula) {
		return getMyProcess().areLettersInARow(formula);
	}
}
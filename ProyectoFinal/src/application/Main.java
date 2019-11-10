package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import model.Proceso;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;

/**
 * 
 * @author Crisi
 *
 */
public class Main extends Application implements IProcessControl
{
	private Proceso myProcess;
	@Override
	public void start(Stage primaryStage) 
	{
		myProcess = new Proceso();
		loadPrincipal(primaryStage);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	public void loadPrincipal(Stage primaryStage)
	{
		try 
		{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../view/PrincipalView.fxml"));
			BorderPane principalPane = (BorderPane)loader.load();
			Scene scene = new Scene(principalPane);
			PrincipalController principal = loader.getController();
			principal.setMain(this);
			principal.setPrincipalPane(principalPane);
			principal.setPrimaryStage(primaryStage);
			primaryStage.setScene(scene);
			primaryStage.getIcons().add(new Image("file:///C:/Users/Crisi/Desktop/Proyectos_Java/Proyectos_Analisis/FormalLogicRepository/LogicProject/src/images/puzzle.png"));
			
			primaryStage.show();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public Proceso getMyProcess() {
		return myProcess;
	}

	public void setMyProcess(Proceso myProcess) {
		this.myProcess = myProcess;
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
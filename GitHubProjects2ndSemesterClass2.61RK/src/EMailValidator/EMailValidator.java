package EMailValidator;

import javafx.application.Application;
import javafx.stage.Stage;

public class EMailValidator extends Application{
	
	private EMailValidator_Model model;
	private EMailValidator_View view;
	private EMailValidator_Controller controller;
	
	public void start(Stage primaryStage) {
		model = new EMailValidator_Model();
		view = new EMailValidator_View(primaryStage, model);
		controller = new EMailValidator_Controller(model, view);
		
		//Display the GUI after initialization
		view.start();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

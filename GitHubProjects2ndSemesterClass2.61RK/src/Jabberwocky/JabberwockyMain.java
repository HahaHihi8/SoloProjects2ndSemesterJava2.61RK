package Jabberwocky;

import javafx.application.Application;
import javafx.stage.Stage;

public class JabberwockyMain extends Application{
	
	public void start(Stage primaryStage) {
		
	// Initialize the model, view, and controller
	JabberwockyModel model = new JabberwockyModel();
	JabberwockyView view = new JabberwockyView(primaryStage);
	JabberwockyController controller = new JabberwockyController(model, view);
	
	view.show();
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}

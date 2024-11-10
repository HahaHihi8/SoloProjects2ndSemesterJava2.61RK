package PetCRUDApplication;

import javafx.application.Application;
import javafx.stage.Stage;

public class PetApplication extends Application {
	
	
	public void start(Stage primaryStage) {
		PetApplicationModel model = new PetApplicationModel();
		PetApplicationView view = new PetApplicationView(primaryStage, model);
		PetApplicationController controller = new PetApplicationController(model, view);
	}
	
	

	public static void main(String[] args) {
		launch(args);

	}

}

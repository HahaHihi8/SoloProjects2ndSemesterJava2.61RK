package IPv6Validator;

import javafx.application.Application;
import javafx.stage.Stage;

public class IPv6 extends Application{
	
	public void start(Stage primaryStage) {
		
        // Initialize the MVC components
        IPv6_Model model = new IPv6_Model();
        IPv6_View view = new IPv6_View(primaryStage);
        IPv6_Controller controller = new IPv6_Controller(model, view);

        // Show the View
        view.start();
    }
	
	public static void main(String[] args) {
		launch(args);
	}

}

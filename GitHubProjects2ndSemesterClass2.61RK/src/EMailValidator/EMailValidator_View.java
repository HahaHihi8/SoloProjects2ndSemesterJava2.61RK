package EMailValidator;

import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class EMailValidator_View {
	
	private EMailValidator_Model model;
	private Stage primaryStage;
	
	protected TextField txtEmail;
	
	protected EMailValidator_View(Stage primaryStage, EMailValidator_Model model) {
		 this.primaryStage = primaryStage;
		 this.model = model;
        
        primaryStage.setTitle("Email Validator");

        GridPane root = new GridPane();
        txtEmail = new TextField();
        root.add(txtEmail, 0, 0);
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("EMailValidator.css").toExternalForm());
        primaryStage.setScene(scene);
        
    }
	public void start() {
		primaryStage.show();
	}
}

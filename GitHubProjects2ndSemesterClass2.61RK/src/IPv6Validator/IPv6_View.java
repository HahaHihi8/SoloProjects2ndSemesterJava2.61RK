package IPv6Validator;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class IPv6_View {
	
	 final private Stage stage;
	    // GUI components
	    protected TextField txtAddress;
	    protected TextField txtPort;
	    protected Button btnValidate;
	    protected Label lblResult;

	    public IPv6_View(Stage stage) {
	        this.stage = stage;
	        // Set up the layout
	        GridPane root = new GridPane();
	        root.setVgap(10);
	        root.setHgap(10);
	        
	        // IPv6 address input
	        Label lblAddress = new Label("Web Address:");
	        txtAddress = new TextField();
	        txtAddress.setPromptText("Enter IPv6 Address");

	        // Port input
	        Label lblPort = new Label("Port:");
	        txtPort = new TextField();
	        txtPort.setPromptText("Enter Port (1-65535)");

	        // Validation button
	        btnValidate = new Button("Validate");
	        btnValidate.setDisable(true); // Initially disabled
	        
	        // Result label
	        lblResult = new Label();

	        // Add components to the grid
	        root.add(lblAddress, 0, 0);
	        root.add(txtAddress, 1, 0);
	        root.add(lblPort, 0, 1);
	        root.add(txtPort, 1, 1);
	        root.add(btnValidate, 0, 2, 2, 1);
	        root.add(lblResult, 0, 3, 2, 1);
	        
	        // Create the scene and set it on the stage
	        Scene scene = new Scene(root, 400, 200);
	        stage.setScene(scene);
	        stage.setTitle("IPv6 Address Validator");
	    }
	    public void start() {
	        stage.show();
	    }
}

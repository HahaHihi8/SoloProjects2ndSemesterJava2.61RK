package Calculator;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class CalculatorView {
	
	final private CalculatorModel model;
	final private Stage stage;
	
	// Define the fields in the GUI
	protected TextField txtCalc;
	protected Button digits[] = new Button[10];
	protected Button btnPlus;
	protected Button btnMinus;
	protected Button btnClear;
	protected Button btnEquals;
	
	protected CalculatorView(Stage stage, CalculatorModel model) {
		this.stage = stage;
		this.model = model;
		
		BorderPane root = new BorderPane();
		txtCalc = new TextField();
		txtCalc.setDisable(true);
		root.setTop(txtCalc);
		
		// Create a grid for the buttons
		GridPane buttons = new GridPane();
		root.setCenter(buttons);
		
		// Create the digit buttons
		for (int i = 0; i < digits.length; i++) {
			digits[i] = new Button(Integer.toString(i));
		}
		
		// special add for button 0
		buttons.add(digits[0], 0, 3, 3, 1);
		
		// add all other digits
		for (int i = 1; i < digits.length; i++) {
			buttons.add(digits[i], (i-1) % 3, 2 - (i-1) / 3);
		}		
		
		btnMinus = new Button("-");
		buttons.add(btnMinus, 3, 0);
		
		btnPlus = new Button("+");
		buttons.add(btnPlus, 3, 1);
		
		btnClear = new Button("C");
		buttons.add(btnClear, 3, 2);
		
		btnEquals = new Button("=");
		buttons.add(btnEquals, 3, 3, 1, 2);
		
		// Configure grid columns and rows to resize to available space
		// See "GridPane" in the JavaFX API, section "Percentage Sizing"
		ColumnConstraints cc = new ColumnConstraints();
		cc.setPercentWidth(20);
		buttons.getColumnConstraints().addAll(cc, cc, cc, cc);
		RowConstraints rc = new RowConstraints();
		rc.setPercentHeight(20);
		buttons.getRowConstraints().addAll(rc, rc, rc, rc);
		
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("Calculator.css").toExternalForm());
		stage.setScene(scene);
		stage.setTitle("CalculatorRK2.61");
		
		// Set the window size
		stage.setWidth(300);
		stage.setHeight(400);
	}

	public void start() {
		stage.show();
	}

}

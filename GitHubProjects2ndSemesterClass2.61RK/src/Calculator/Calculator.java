package Calculator;

import javafx.application.Application;
import javafx.stage.Stage;

public class Calculator extends Application{
	
	private CalculatorModel model;
	private CalculatorView view;
	private CalculatorController controller;

	public static void main(String[] args) {
		launch();
	}
	
	/**
	 * Note the dependencies between model, view and controller. Additionally,
	 * the view needs the primaryStage created by JavaFX.
	 */
	@Override
	public void start(Stage primaryStage) {
		model = new CalculatorModel();
		view = new CalculatorView(primaryStage, model);
		controller = new CalculatorController(model, view);
		
		// Display the GUI after all initialization is complete
		view.start();
	}

}

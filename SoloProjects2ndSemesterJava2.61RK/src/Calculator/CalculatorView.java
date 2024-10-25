package Calculator;

import javafx.scene.Scene;

public class Calculator_View {
	
	private Stage stage;
	private Dice_Model model;
	
	Button[] dice = new Button[2]; // Array for buttons
	
	public Dice_View(Stage stage, Dice_Model model) {
		this.stage = stage;
		this.model = model;
		
		// Create and display the buttons
		GridPane root = new GridPane();
		for (int i = 0; i < 2; i++) {
			dice[i] = new Button("1");
			root.add(dice[i], i, 0);
		}
		
		// Create the scene using our layout; then display it
		Scene scene = new Scene(root);
		scene.getStylesheets().add(
				getClass().getResource("Dice.css").toExternalForm());
		stage.setScene(scene);
		stage.setTitle("Dice");
	}
	
	protected void start() {
		stage.show();
	}
	
	
}

package Calculator;

	import javafx.event.ActionEvent;
	import javafx.scene.control.Button;
	
public class Calculator_Controller {

	
		private Dice_Model model;
		private Dice_View view;

		public Dice_Controller(Dice_Model model, Dice_View view) {
			this.model = model;
			this.view = view;
			
			for (Button btn : view.dice) {
				btn.setOnAction(this::roll);
			}
		}
		
		private void roll(ActionEvent e) {
			// Get the button that was clicked
			Button btn = (Button) e.getSource();
			
			// Roll a new value, and place the value into the button
			int value = model.getRandomValue();
			String s = Integer.toString(value);
			btn.setText(s);
		}
	}


}

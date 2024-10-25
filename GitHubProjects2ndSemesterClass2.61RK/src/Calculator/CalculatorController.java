package Calculator;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class CalculatorController implements EventHandler<ActionEvent>{
	
	final private CalculatorModel model;
	final private CalculatorView view;
	
	protected CalculatorController(CalculatorModel model, CalculatorView view) {
		this.model = model;
		this.view = view;
		
		// register for events
		for (Button b : view.digits) {
			b.setOnAction(this);
		}
		view.btnMinus.setOnAction(this);
		view.btnPlus.setOnAction(this);
		view.btnClear.setOnAction(this);
		view.btnEquals.setOnAction(this);
	}

	@Override
	public void handle(ActionEvent event) {
        Button btn = (Button) event.getSource();

        if (btn == view.btnClear) {
            view.txtCalc.setText("");
        } else if (btn == view.btnEquals) {
            String result = model.calculate(view.txtCalc.getText());
            view.txtCalc.setText(result);
        } else if (btn == view.btnMinus) {
            view.txtCalc.setText(view.txtCalc.getText() + "-");
        } else { // All other buttons: append button.text to text-field
            view.txtCalc.setText(view.txtCalc.getText() + btn.getText());
        }
    }
}

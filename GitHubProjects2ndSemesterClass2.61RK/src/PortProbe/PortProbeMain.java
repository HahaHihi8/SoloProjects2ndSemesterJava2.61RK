package PortProbe;

import javafx.application.Application;
import javafx.stage.Stage;

public class PortProbeMain extends Application {

	public void start(Stage stage) {
		PortProbeModel model = new PortProbeModel();
		PortProbeView view = new PortProbeView();
		new PortProbeController(model, view);

		view.start(stage);
	}

	public static void main(String[] args) {
		launch(args);
	}
}

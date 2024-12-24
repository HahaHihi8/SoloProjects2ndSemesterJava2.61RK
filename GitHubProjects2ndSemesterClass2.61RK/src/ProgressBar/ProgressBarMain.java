package ProgressBar;

import javafx.application.Application;
import javafx.stage.Stage;

public class ProgressBarMain extends Application {
	
	public void start(Stage primaryStage) {
		ProgressBarView view = new ProgressBarView(primaryStage);
	}

	public static void main(String[] args) {
		launch();

	}

}

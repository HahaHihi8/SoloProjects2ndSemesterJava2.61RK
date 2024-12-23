package MineSweeper;

import javafx.application.Application;
import javafx.stage.Stage;

//In Eclipse kann die Klasses mit der Superclass Application erstellt werden
public class MineSweeperMain extends Application {
	
	//1. Werden die Objekt-Attribute erstellt
	private MineSweeperView view;
	private MineSweeperModel model;
	private MineSweeperController controller;

	//2. Objekte erstellen -> Reihenfolge wichtig!!
	public void start(Stage primaryStage) throws Exception {
		model = new MineSweeperModel();
		view = new MineSweeperView(primaryStage, model);
		controller = new MineSweeperController(model, view); //Fehler, da noch kein Konstruktor in der Klasse 
		view.start(); //Start-Methode wird im View geschrieben
	}

	public static void main(String[] args) {
		launch();

	}

}

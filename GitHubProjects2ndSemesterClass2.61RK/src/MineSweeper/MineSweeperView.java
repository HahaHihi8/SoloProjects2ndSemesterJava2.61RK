package MineSweeper;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MineSweeperView {
	
	// protected = kann nur von Klassen vom selben Package aufgerufen werden
	// 1. Objekte erstellen
	protected Stage stage;
	protected MineSweeperModel model;
	
	
    // 3. Control Elemente anlegen
	protected MenuBar menus = new MenuBar();
	protected Menu menuFile = new Menu("Game");
	protected MenuItem miAbout = new MenuItem("About");
	
	protected VBox rightPane = new VBox();
	protected Label lblGameOver = new Label("Playing");
	
	protected GridPane gameGrid = new GridPane();
	protected Button[][] buttons;
	
	
	

	public MineSweeperView(Stage primaryStage, MineSweeperModel model) {
		// 2. Objekte initialisieren
		this.stage = primaryStage;
		this.model = model;
		
		//5. BorderPane initialisieren und Control Element hinzufügen
		BorderPane root = new BorderPane();
		
		root.setTop(menus);
		menus.getMenus().add(menuFile);
		menuFile.getItems().add(miAbout);
		
		rightPane.getChildren().add(lblGameOver);
		root.setRight(rightPane);
		
		root.setCenter(gameGrid);
		
		
		// 4. Control Elemente initialisieren
		Scene scene = new Scene(root);
		stage.setTitle("MineSweeper");
		scene.getStylesheets().add(getClass().getResource("MineSweeper.css").toExternalForm());
		stage.setScene(scene);
	}

	public void start() {
		stage.show(); //wird in der Main-Klasse aufgerufen
		
	}

}

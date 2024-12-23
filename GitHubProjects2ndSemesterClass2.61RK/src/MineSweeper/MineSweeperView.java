package MineSweeper;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
		//VBOX hat keine aotmatische Verknüpfung zum CSS
		rightPane.getStyleClass().add("vbox"); 
		
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
	
	// 6. Erstellt  das Spielfeld
	protected void newGame(int width, int height) {
		gameGrid.getChildren().clear(); //löscht alte Elemente
		buttons = new Button[height][width]; //height = Höhe / width = Spalte
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
                Button btn = new Button();
                buttons[row][col] = btn;
                gameGrid.add(btn, col, row); // add-Funktion fordert zuerst Spalte und dann Zeile
			}
		}	
	}

	public void showBoom() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Boom!!!");
		alert.setHeaderText("You hit a mine!");
		alert.setContentText("Game Over, you have been blown up!");
		alert.showAndWait();
	}
}

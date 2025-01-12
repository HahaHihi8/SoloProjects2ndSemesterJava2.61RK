package Jabberwocky;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JabberwockyView {
    protected Stage stage;

    private Label label;
    private TextArea inputField;
    private Button actionButton;

    private MenuBar menuBar = new MenuBar();
    protected Menu fileMenu = new Menu("File");
    private MenuItem loadFileItem = new MenuItem("Load File");

    public JabberwockyView(Stage stage) {
        this.stage = stage;

        // Menüleiste initialisieren
        fileMenu.getItems().add(loadFileItem);
        menuBar.getMenus().add(fileMenu);

        // Hauptlayout
        this.label = new Label("Jabberwocky App");
        this.inputField = new TextArea();
        inputField.setWrapText(true); // Zeilenumbruch aktivieren
        inputField.setPrefWidth(400);
        inputField.setPrefHeight(600);
        this.actionButton = new Button("Execute Algorithm");

        BorderPane root = new BorderPane();
        root.setTop(menuBar); // Menüleiste oben setzen
        VBox layout = new VBox(10, label, inputField, actionButton);
        root.setCenter(layout);

        Scene scene = new Scene(root, 600, 800);
        stage.setScene(scene);
        stage.setTitle("Jabberwocky");
    }

    public void show() {
        stage.show();
    }

    public TextArea getInputField() {
        return inputField;
    }

    public Button getActionButton() {
        return actionButton;
    }

    public Label getLabel() {
        return label;
    }
}
package Jabberwocky;

import javafx.stage.FileChooser;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class JabberwockyController {

    private JabberwockyModel model;
    private JabberwockyView view;

    public JabberwockyController(JabberwockyModel model, JabberwockyView view) {
        this.model = model;
        this.view = view;

        // Event-Handling für den Action-Button
        view.getActionButton().setOnAction(e -> handleButtonClick());

        // Event-Handling für den Menüpunkt "Load File"
        view.fileMenu.getItems().get(0).setOnAction(e -> loadFile());
    }

    private void handleButtonClick() {
        // Hole Eingabe aus der View
        String input = view.getInputField().getText();

        // Verwende den Algorithmus aus dem Model
        String result = model.executeAlgorithm(input);

        // Zeige das Ergebnis in der View
        view.getLabel().setText("Result: " + result);
    }

    private void loadFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose a File");
        fileChooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("Text Files", "*.txt"),
            new FileChooser.ExtensionFilter("All Files", "*.*")
        );

        File file = fileChooser.showOpenDialog(view.stage);
        if (file != null) {
            try {
                String content = Files.readString(file.toPath()); // Dateiinhalt lesen
                model.setData(content); // Daten ins Model setzen
                view.getInputField().setText(content); // Daten in die View einfügen
            } catch (IOException ex) {
                view.getLabel().setText("Error loading file: " + ex.getMessage());
            }
        }
    }
}
package ProgressBarTask;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ProgressBarTaskMain extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Fortschrittsbalken
        ProgressBar progressBar = new ProgressBar(0);
        // Start-Button
        Button startButton = new Button("Start Task");
        // Task erstellen
        Task<Void> longTask = new Task<>() {
            @Override
            protected Void call() throws Exception {
                // Simulierte lange Aufgabe mit 10 Schritten
                for (int i = 0; i <= 10; i++) {
                    if (isCancelled()) {
                        break;
                    }
                    updateProgress(i, 10); // Fortschritt aktualisieren
                    Thread.sleep(500); // Simulierte Verzögerung von 500ms
                }
                return null;
            }
        };
        // Binde die progressProperty des Tasks an die ProgressBar
        progressBar.progressProperty().bind(longTask.progressProperty());
        // Start-Button Aktion
        startButton.setOnAction(e -> {
            Thread thread = new Thread(longTask); // Task in separatem Thread starten
            thread.setDaemon(true); // Beenden, wenn die Anwendung geschlossen wird
            thread.start();
        });
        // Layout
        VBox root = new VBox(10, progressBar, startButton);
        root.setStyle("-fx-padding: 20; -fx-alignment: center;");
        // Szene
        Scene scene = new Scene(root, 300, 150);
        primaryStage.setScene(scene);
        primaryStage.setTitle("ProgressBar mit Task");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
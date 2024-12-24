package ProgressBar;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ProgressBarView {
	
    // Property für Fortschritt
    private final SimpleDoubleProperty progress = new SimpleDoubleProperty(0.0);
	private Stage stage;

    public ProgressBarView(Stage stage) {
        this.stage = stage;

        // Fortschrittsbalken
        ProgressBar prgsBar = new ProgressBar();
        prgsBar.progressProperty().bind(progress); // Fortschritt wird gebunden

        // Schieberegler (Slider), um den Fortschritt zu steuern
        Slider slider = new Slider(0, 1, 0); // Wertebereich: 0 bis 1
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.valueProperty().addListener((obs, oldVal, newVal) -> {
            progress.set(newVal.doubleValue()); // Aktualisierung der Property
        });

        // Layout
        VBox root = new VBox(10, prgsBar, slider); // Abstand von 10px
        root.setStyle("-fx-padding: 20; -fx-alignment: center;");

        // Szene erstellen
        Scene scene = new Scene(root, 300, 150);
        stage.setScene(scene);
        stage.setTitle("Ladebalken mit Bindings");
        stage.show();
    }
}
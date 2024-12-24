package PetCRUDApplication;

import PetCRUDApplication.Pet.Gender;
import PetCRUDApplication.Pet.Species;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PetApplicationView {

    private Stage stage;
    private PetApplicationModel model;

    // Controls erstellen
    TextField txtName = new TextField();
    ComboBox<Species> cmbSpecies = new ComboBox<>();
    ComboBox<Gender> cmbGender = new ComboBox<>();
    Label lblDataName = new Label();
    Label lblDataSpecies = new Label();
    Label lblDataGender = new Label();

    // Buttons erstellen
    Button btnSave = new Button("Save");
    Button btnDelete = new Button("Delete");

    // **Navigationsbuttons und ListView hinzufügen**
    Button btnNext = new Button("Next");
    Button btnPrevious = new Button("Previous");
    ListView<Pet> lstPets = new ListView<>();

    public PetApplicationView(Stage stage, PetApplicationModel model) {
        this.stage = stage;
        this.model = model;

        VBox root = new VBox();
        root.getChildren().add(createDataEntryPane());
        root.getChildren().add(createControlPane());
        root.getChildren().add(createNavigationPane()); // NavigationPane hinzufügen
        
        root.getChildren().add(lstPets); // ListView hinzufügen

        // Bind ObservableList to ListView
        lstPets.setItems(model.getPets());
        
        // **ChangeListener hinzufügen, um auf Änderungen in der ListView zu reagieren**
        lstPets.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                int index = model.getPets().indexOf(newSelection); // Index des ausgewählten Pets finden
                model.setCurrentIndex(index); // Synchronisiere den Index im Model
            }
        });

        // Standard Scene und Stage
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("Pet.css").toExternalForm());
        stage.setTitle("Enter and display a pet");
        stage.setScene(scene);
        stage.show();
    }

    private Pane createDataEntryPane() {
        GridPane pane = new GridPane();
        pane.setId("dataEntry");

        // Labels hinzufügen
        Label lblName = new Label("Name");
        Label lblSpecies = new Label("Species");
        Label lblGender = new Label("Gender");

        // ComboBoxen hinzufügen und mit möglichen Enumerationen füllen
        cmbSpecies.getItems().addAll(Pet.Species.values());
        cmbGender.getItems().addAll(Pet.Gender.values());

        pane.add(lblName, 0, 0);
        pane.add(txtName, 1, 0);
        pane.add(lblSpecies, 0, 1);
        pane.add(cmbSpecies, 1, 1);
        pane.add(lblGender, 0, 2);
        pane.add(cmbGender, 1, 2);

        return pane;
    }

    private Pane createControlPane() {
        GridPane pane = new GridPane();
        pane.setId("controlArea");
        pane.add(btnSave, 0, 0);
        pane.add(btnDelete, 1, 0);
        return pane;
    }

    // **Neues Pane für Navigation hinzufügen**
    private Pane createNavigationPane() {
        HBox pane = new HBox(10, btnPrevious, btnNext);
        pane.setId("navigationArea");
        return pane;
    }

    private Pane createDataDisplayPane() {
        GridPane pane = new GridPane();
        pane.setId("dataDisplay");
        pane.add(new Label("Name:"), 0, 0);
        pane.add(lblDataName, 1, 0);
        pane.add(new Label("Species:"), 0, 1);
        pane.add(lblDataSpecies, 1, 1);
        pane.add(new Label("Gender:"), 0, 2);
        pane.add(lblDataGender, 1, 2);
        return pane;
    }
}
package PetCRUDApplication;

import PetCRUDApplication.Pet.Gender;
import PetCRUDApplication.Pet.Species;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PetApplicationView {

    private Stage stage;
    private PetApplicationModel model;
    
    //Controls erstellen
    TextField txtName = new TextField();
    ComboBox<Species> cmbSpecies = new ComboBox<>();
    ComboBox<Gender> cmbGender = new ComboBox<>();
    Label lblDataID = new Label();
    Label lblDataName = new Label();
    Label lblDataSpecies = new Label();
    Label lblDataGender = new Label();

    //Buttons erstellen
    Button btnSave = new Button("Save");
    Button btnDelete = new Button("Delete");
    
      

    public PetApplicationView(Stage stage, PetApplicationModel model) {
        this.stage = stage;
        this.model = model;

        VBox root = new VBox();
        root.getChildren().add(createDataEntryPane());
        root.getChildren().add(createControlPane());
        root.getChildren().add(createDataDisplayPane());

        // Standard stuff for Scene and Stage
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("Pet.css").toExternalForm());
        stage.setTitle("Enter and display a pet");
        stage.setScene(scene);
        stage.show();
    }

    private Pane createDataEntryPane() {
        GridPane pane = new GridPane();
        pane.setId("dataEntry");
        
        //Label hinzufügen
        Label lblName = new Label("Name");
        Label lblSpecies = new Label("Species");
        Label lblGender = new Label("Gender");

        //ComboBoxen hinzufügen und mit möglichen Enumerationen füllen
        cmbSpecies.getItems().addAll(Pet.Species.values());
        cmbGender.getItems().addAll(Pet.Gender.values());
        
        pane.add(lblName, 0, 0); pane.add(txtName, 1, 0);
        pane.add(lblSpecies, 0, 1); pane.add(cmbSpecies, 1, 1);
        pane.add(lblGender, 0, 2); pane.add(cmbGender, 1, 2);
            
        return pane;
    }

    private Pane createControlPane() {
        GridPane pane = new GridPane();
        pane.setId("controlArea");
        pane.add(new Label("Control area"), 0, 0);
        return pane;
    }

    private Pane createDataDisplayPane() {
        GridPane pane = new GridPane();
        pane.setId("dataDisplay");
        pane.add(new Label("Data display area"), 0, 0);
        return pane;
    }
}
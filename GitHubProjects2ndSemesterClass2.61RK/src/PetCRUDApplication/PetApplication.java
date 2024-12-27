package PetCRUDApplication;

import javafx.application.Application;
import javafx.stage.Stage;
import java.io.*;

public class PetApplication extends Application {

    private PetApplicationModel model;
    // Pfad zur Datei, in der die Daten gespeichert werden
    private static final String FILE_PATH = "pets.txt";

    // init-Methode wird vor der start-Methode aufgerufen, um Daten zu laden / VOR START
    public void init() throws Exception {
        model = new PetApplicationModel();
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            file.createNewFile();
            System.out.println("Die Datei 'pets.txt' wurde erstellt.");
        }
        if (file.exists() && file.length() > 0) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    String name = parts[0];
                    Pet.Species species = Pet.Species.valueOf(parts[1]);
                    Pet.Gender gender = Pet.Gender.valueOf(parts[2]);
                    model.addPet(species, gender, name);
                }
            } catch (IOException e) { //IOException checkt alle Subklassen nach Fehlern aus der IOException Klasse
                e.printStackTrace();
            }
        }
    }

    public void start(Stage primaryStage) {
        PetApplicationView view = new PetApplicationView(primaryStage, model);
        new PetApplicationController(model, view);
    }
    // stop-Methode wird aufgerufen, wenn das Programm beendet wird / NACH START
    public void stop() throws Exception {
        File file = new File(FILE_PATH);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Pet pet : model.getPets()) {
                writer.write(pet.getName() + "," + pet.getSpecies() + "," + pet.getGender());
                writer.newLine();
            }
            System.out.println("Daten wurden in 'pets.txt' gespeichert.");
        } catch (IOException e) { //IOException checkt alle Subklassen nach Fehlern aus der IOException Klasse
            e.printStackTrace(); //e.getClass().toString(); würde den Namen der Fehler-Klasse zurück
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
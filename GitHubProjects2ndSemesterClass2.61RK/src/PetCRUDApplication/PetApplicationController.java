package PetCRUDApplication;

public class PetApplicationController {

    private final PetApplicationModel model;
    private final PetApplicationView view;

    public PetApplicationController(PetApplicationModel model, PetApplicationView view) {
        this.model = model;
        this.view = view;

        // Button-Logik
        view.btnSave.setOnAction(e -> savePet());
        view.btnDelete.setOnAction(e -> deletePet());
        view.btnNext.setOnAction(e -> showNextPet());
        view.btnPrevious.setOnAction(e -> showPreviousPet());

        // Initial Pet anzeigen
        updatePetDisplay();
    }

    private void savePet() {
        String name = view.txtName.getText();
        Pet.Species species = view.cmbSpecies.getValue();
        Pet.Gender gender = view.cmbGender.getValue();
        if (name != null && species != null && gender != null) {
            model.addPet(species, gender, name);
            updatePetDisplay();
        }
    }

    private void deletePet() {
        model.deleteCurrentPet();
        updatePetDisplay();
    }

    private void showNextPet() {
        model.nextPet();
        updatePetDisplay();
    }

    private void showPreviousPet() {
        model.previousPet();
        updatePetDisplay();
    }

    private void updatePetDisplay() {
        Pet pet = model.getCurrentPet();
        if (pet != null) {
            view.lblDataName.setText("Name: " + pet.getName());
            view.lblDataSpecies.setText("Species: " + pet.getSpecies().toString());
            view.lblDataGender.setText("Gender: " + pet.getGender().toString());
            view.lstPets.getSelectionModel().select(pet); // Synchronisation mit der ListView
        } else {
            view.lblDataName.setText("Name: -");
            view.lblDataSpecies.setText("Species: -");
            view.lblDataGender.setText("Gender: -");
        }
    }
}
package PetCRUDApplication;

import javafx.event.ActionEvent;

public class PetApplicationController {
	
		final private PetApplicationModel model;
	    final private PetApplicationView view;

	    public PetApplicationController(PetApplicationModel model, PetApplicationView view) {
	        this.model = model;
	        this.view = view;

	        view.btnSave.setOnAction(this::save);
	        view.btnDelete.setOnAction(this::delete);
	    }

	    private void save(ActionEvent e) {
	        Pet.Species species = view.cmbSpecies.getValue();
	        Pet.Gender gender = view.cmbGender.getValue();
	        String name = view.txtName.getText();

	        if (species != null && gender != null && name != null && !name.isEmpty()) {
	            model.savePet(species, gender, name);
	            updateView(model.getPet()); // Update display area
	        }
	    }

	    private void delete(ActionEvent e) {
	        model.deletePet();
	        updateView(null); // Clear display area
	    }

	    private void updateView(Pet pet) {
	        if (pet != null) {
	            view.lblDataID.setText(Integer.toString(pet.getID()));
	            view.lblDataName.setText(pet.getName());
	            view.lblDataSpecies.setText(pet.getSpecies().toString());
	            view.lblDataGender.setText(pet.getGender().toString());
	        } else {
	            view.lblDataID.setText("");
	            view.lblDataName.setText("");
	            view.lblDataSpecies.setText("");
	            view.lblDataGender.setText("");
	        }
	    }
}

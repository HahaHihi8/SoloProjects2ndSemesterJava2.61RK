package PetCRUDApplication;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PetApplicationModel {

    private ObservableList<Pet> pets = FXCollections.observableArrayList();
    private int currentIndex = -1;

    public void addPet(Pet.Species species, Pet.Gender gender, String name) {
        pets.add(new Pet(species, gender, name));
        currentIndex = pets.size() - 1; // Setze aktuellen Index auf das neueste Pet
    }

    public void deleteCurrentPet() {
        if (currentIndex >= 0 && currentIndex < pets.size()) {
            pets.remove(currentIndex);
            currentIndex = pets.isEmpty() ? -1 : Math.min(currentIndex, pets.size() - 1);
        }
    }

    public Pet getCurrentPet() {
        return currentIndex >= 0 ? pets.get(currentIndex) : null;
    }

    public void nextPet() {
        if (currentIndex < pets.size() - 1) {
            currentIndex++;
            System.out.println("Next Pet: Index = " + currentIndex); // Debugging
        }
    }

    public void previousPet() {
        if (currentIndex > 0) {
            currentIndex--;
            System.out.println("Previous Pet: Index = " + currentIndex); // Debugging
        }
    }

    public void setCurrentIndex(int index) {
        if (index >= 0 && index < pets.size()) {
            currentIndex = index;
        }
    }
    
    public ObservableList<Pet> getPets() {
        return pets;
    }
}
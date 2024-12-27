package PetCRUDApplication;

public class Pet {
	
	public enum Species {DOG, CAT, HORSE};
	public enum  Gender {MALE, FEMALE};
	
	private static int highestID = -1;
	
	private final int ID;
	private Species species;
	private Gender gender;
	private String name;
	
	//Klassen-Methode um nächste ID zu generieren
	private static int getNextID() {
		return ++highestID;
	}
	
	public Pet(Species species, Gender gender, String name) {
		this.ID = getNextID();
		this.species = species;
		this.gender = gender;
		this.name = name;
	}

	public Species getSpecies() {
		return species;
	}

	public void setSpecies(Species species) {
		this.species = species;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getID() {
		return ID;
	}
	
	public String toString() {
	    return name + " (" + species + ", " + gender + ")";
	}
}
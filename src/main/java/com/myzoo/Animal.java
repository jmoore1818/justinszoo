package com.myzoo;

public class Animal {

	private int animalID = 0;
	private String animalSpecies = null;
	private String animalHabitat = null;
	private String animalDiet = null;
	private int animalAge = 0;

	public Animal() {
		super();
	}

	public int getAnimalID() {
		return animalID;
	}

	public void setAnimalID(int animalID) {
		this.animalID = animalID;
	}

	public String getAnimalSpecies() {
		return animalSpecies;
	}

	public void setAnimalSpecies(String animalSpecies) {
		this.animalSpecies = animalSpecies;
	}

	public String getAnimalHabitat() {
		return animalHabitat;
	}

	public void setAnimalHabitat(String animalHabitat) {
		this.animalHabitat = animalHabitat;
	}

	public String getAnimalDiet() {
		return animalDiet;
	}

	public void setAnimalDiet(String animalDiet) {
		this.animalDiet = animalDiet;
	}

	public int getAnimalAge() {
		return animalAge;
	}

	public void setAnimalAge(int animalAge) {
		this.animalAge = animalAge;
	}

	@Override
	public String toString() {
		return "Animal [animalID=" + animalID + ", animalSpecies=" + animalSpecies + ", animalHabitat=" + animalHabitat
				+ ", animalDiet=" + animalDiet + ", animalAge=" + animalAge + "]";
	}

}

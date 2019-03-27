package engine;

import java.util.ArrayList;


import ressources.Ressources;

//This class want to calculate and initiate all resources of a country.
public class RessourcesAlgorithm {
	private boolean custom;
	private int[][] sizeValues;
	
	public RessourcesAlgorithm(int[][] sizeValues, boolean custom) {
		this.custom = custom;
		this.sizeValues = sizeValues;
	}

	public Ressources ressourcesInitialisation(ArrayList<Integer> alIsItCustom) {
		Ressources ressources;
		if (custom == false) {
			RessourcesAutomatedAlgorithm rAA = new RessourcesAutomatedAlgorithm(sizeValues);
			ressources = rAA.automatedRessourcesCreation();
		}
		else {
			RessourcesCustomAlgorithm rCA = new RessourcesCustomAlgorithm(alIsItCustom, sizeValues);
			ressources = rCA.customCountryCreation();
		}
		return ressources;
	}

	public boolean isCustom() {
		return custom;
	}

	public int[][] getSizeValues() {
		return sizeValues;
	}
	
	
}

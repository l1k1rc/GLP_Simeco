package engine;

import java.util.ArrayList;

import industries.IndustrialFactors;
import political.PoliticalStatus;
import ressources.Ressources;

public class IndustriesAlgorithm {
	private boolean custom;
	private int[][] ressourcesLimits;
	private Ressources ressourcesAvailable;
	private PoliticalStatus currentPS;
	
	
	public IndustriesAlgorithm(Ressources ressourcesAvailable, PoliticalStatus ps, boolean custom, int[][] ressourcesLimits) {
		this.ressourcesAvailable = ressourcesAvailable;
		this.ressourcesLimits = ressourcesLimits;
		currentPS = ps;
		this.custom = custom;
	}
	
	public IndustrialFactors industriesInitialisation(ArrayList<Integer> alIsItCustom) {
		IndustrialFactors industries;
		if (custom == false) {
			IndustriesAutomatedAlgorithm iAA = new IndustriesAutomatedAlgorithm(ressourcesAvailable, currentPS, ressourcesLimits);
			industries = iAA.automatedIndustriesCreation();
		}
		else {
			IndustriesCustomAlgorithm iCA = new IndustriesCustomAlgorithm(ressourcesAvailable, currentPS, ressourcesLimits, alIsItCustom);
			industries = iCA.customIndustriesCreation();
		}
		return industries;
	}

	public boolean isCustom() {
		return custom;
	}

	public int[][] getRessourcesLimits() {
		return ressourcesLimits;
	}

	public Ressources getRessourcesAvailable() {
		return ressourcesAvailable;
	}

	public PoliticalStatus getCurrentPS() {
		return currentPS;
	}
}

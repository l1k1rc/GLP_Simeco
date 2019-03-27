package engine;

import java.util.ArrayList;

import economy.EconomicalFactors;
import industries.IndustrialFactors;

public class EconomicalFactorsAlgorithm {
	private boolean custom;
	private int[][] sizeValues;
	private IndustrialFactors industrialFactors;

	public EconomicalFactorsAlgorithm(int[][] sizeValues, IndustrialFactors industrialFactors, boolean custom) {
		this.custom = custom;
		this.sizeValues = sizeValues;
		this.industrialFactors = industrialFactors;
	}
	
	public EconomicalFactors economicalFactorsInitialisation(ArrayList<Integer> alIsItCustom) {
		EconomicalFactors economicalFactors;
		if (custom == false) {
			EconomicalFactorsAutomatedAlgorithm efaA = new EconomicalFactorsAutomatedAlgorithm(sizeValues, industrialFactors);
			economicalFactors = efaA.automatedEconomicalFactorsCreation();
		}
		else {
			EconomicalFactorsCustomAlgorithm efcA = new EconomicalFactorsCustomAlgorithm(sizeValues, industrialFactors, alIsItCustom);
			economicalFactors = efcA.customEconomicalFactorsCreation();
		}
		return economicalFactors;
	}

	public boolean isCustom() {
		return custom;
	}

	public int[][] getSizeValues() {
		return sizeValues;
	}

	public IndustrialFactors getIndustrialFactors() {
		return industrialFactors;
	}
	
	
	
}

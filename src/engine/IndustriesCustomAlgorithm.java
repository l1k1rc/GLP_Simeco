package engine;

import java.util.ArrayList;

import industries.IndustrialFactors;
import political.PoliticalStatus;
import ressources.Ressources;

public class IndustriesCustomAlgorithm {
	private ArrayList<Integer> alIsItCustom;
	private Ressources ressourcesAvailable;
	private int[][] ressourcesLimits;
	private PoliticalStatus currentPS;
	
	public IndustriesCustomAlgorithm(Ressources ressourcesAvailable, PoliticalStatus currentPS, int[][] ressourcesLimits,
			ArrayList<Integer> alIsItCustom) {
		this.ressourcesAvailable = ressourcesAvailable;
		this.currentPS = currentPS;
		this.ressourcesLimits = ressourcesLimits;
		this.alIsItCustom = alIsItCustom;
	}
	
	public IndustrialFactors customIndustriesCreation() throws IndexOutOfBoundsException{
		IndustrialFactors industries = null;
		IndustriesAutomatedAlgorithm autoGen = new IndustriesAutomatedAlgorithm(ressourcesAvailable, currentPS, ressourcesLimits);
		switch (alIsItCustom.get(0)) {
			case 0: industries = autoGen.automatedIndustriesCreation(); //Automated generation (in case of custom choice but automated choice 
					break;												//in industries selection)
			case 1: industries = autoGen.logicIndustry();
					break;
			case 2: industries = autoGen.illogicalIndustry();
					break;
			case 3: industries = autoGen.profitIndustry();
					break;
			default : throw new IndexOutOfBoundsException("En dehors de l'ArrayList de génération custom des facteurs industriels");
		}
		
		return industries;
	}

	public ArrayList<Integer> getAlIsItCustom() {
		return alIsItCustom;
	}

	public Ressources getRessourcesAvailable() {
		return ressourcesAvailable;
	}

	public int[][] getRessourcesLimits() {
		return ressourcesLimits;
	}

	public PoliticalStatus getCurrentPS() {
		return currentPS;
	}
	
}

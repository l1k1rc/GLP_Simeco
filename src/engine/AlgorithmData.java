package engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;


import economy.EconomicalFactors;
import industries.IndustrialFactors;
import military.Militarisation;
import political.PoliticalStatus;
import region.*;
import ressources.Ressources;

public class AlgorithmData {
	private boolean custom;
	private int[][] ressourcesSizeValues;
	private int[][] economicalFactorsSizeValues;
	private HashMap<String,ArrayList<Integer>> regionData;
	
	
	public AlgorithmData(HashMap<String,ArrayList<Integer>> regionData, boolean custom) {
		ressourcesSizeValues = new int[8][3];
		economicalFactorsSizeValues = new int[7][2];
		this.regionData = regionData;
		this.custom = custom;
		
		this.initRessourcesSizeValues();
		this.initEconomicalFactorsSizeValues();
	}
	
	private void initRessourcesSizeValues() {
		//Lakes 
		int[] tab = new int[]{50,2,117};  //{numberOf, valMin, valMax}
		ressourcesSizeValues[0] = tab;
		//Suitable Lands
		tab = new int[]{100,1,1000};
		ressourcesSizeValues[1] = tab;
		//Fields
		tab = new int[]{100,3,250};
		ressourcesSizeValues[2] = tab;
		//Forests
		tab = new int[]{150,1,80};
		ressourcesSizeValues[3] = tab;
		//Oil wells
		tab = new int[]{20,10,5000};
		ressourcesSizeValues[4] = tab;
		//Gold Mines
		tab = new int[]{20,50,500};
		ressourcesSizeValues[5] = tab;
		//Iron Mines
		tab = new int[]{25,50,500};
		ressourcesSizeValues[6] = tab;
		//Coal Mines
		tab = new int[]{30,50,500};
		ressourcesSizeValues[7] = tab;
	}
	
	private void initEconomicalFactorsSizeValues() {
		//GDP 
		int[] tab = new int[]{150000,15000000};  //{valMin, valMax}
		economicalFactorsSizeValues[0] = tab;
		//HID
		tab = new int[]{250, 950};
		economicalFactorsSizeValues[1] = tab;
		//Population growth
		tab = new int[]{-1,5};
		economicalFactorsSizeValues[2] = tab;
		//Gini
		tab = new int[]{20,80};
		economicalFactorsSizeValues[3] = tab;
		//Resherche spending
		tab = new int[]{0,5};
		economicalFactorsSizeValues[4] = tab;
		//Middle age
		tab = new int[]{15,47};
		economicalFactorsSizeValues[5] = tab;
		//Unemployment rate
		tab = new int[]{0,15};
		economicalFactorsSizeValues[6] = tab;
	}
	
	public RegionMap regionCreator() throws Exception, IndexOutOfBoundsException {
		RegionMap region = new RegionMap();
		Set<String> keySetMap = regionData.keySet();
		for (String countryName : keySetMap) {
			ArrayList<Integer> countrySet = regionData.get(countryName);
			region.addState(this.countryCreator(countryName, countrySet));	
		}
		return region;
	}
	
	public Country countryCreator(String countryName, ArrayList<Integer> countrySet) throws IndexOutOfBoundsException {
		Ressources ressources = null;
		PoliticalStatus politicalStatus = null;
		Militarisation militarisation = null;
		IndustrialFactors industrialFactors = null;
		EconomicalFactors economicalFactors = null;
		
		ArrayList<Integer> ressourcesAL = new ArrayList<Integer>();
		for (int i=0; i<8; i++) {
			ressourcesAL.add(countrySet.get(i));
		}
		
		int politicalRegime = countrySet.get(8);
		
		ArrayList<Integer> industriesAL = new ArrayList<Integer>();
		industriesAL.add(countrySet.get(9));
		
		ArrayList<Integer> economyAL = new ArrayList<Integer>();
		for (int i=10; i<17; i++) {
			economyAL.add(countrySet.get(i));
		}
		
		
		ressources = this.ressourcesCreator(ressourcesAL);
		politicalStatus = this.politicalStatusCreator(politicalRegime);
		militarisation = this.militarisationCreator(politicalStatus);
		industrialFactors = this.industrialFactorsCreator(ressources, politicalStatus, industriesAL);
		economicalFactors = this.economicalFactorsCreator(industrialFactors, economyAL);
		
		Country countryGenerated = new Country(countryName, industrialFactors, economicalFactors,
			ressources, politicalStatus,militarisation);
		return countryGenerated;
	}
	
	public Ressources ressourcesCreator(ArrayList<Integer> ressourcesValues) {
		Ressources ressources;
		
		RessourcesAlgorithm rA = new RessourcesAlgorithm(ressourcesSizeValues, custom);
		ressources = rA.ressourcesInitialisation(ressourcesValues);
		
		return ressources;
	}
	
	public PoliticalStatus politicalStatusCreator(int isItDemocracy) {
		PoliticalStatus politicalStatus;
		PoliticalStatusAlgorithm psA = new PoliticalStatusAlgorithm(custom);
		politicalStatus = psA.politicalInitialisation(isItDemocracy);
		
		return politicalStatus;
	}
	
	public Militarisation militarisationCreator(PoliticalStatus ps) {
		Militarisation militarisation;
		MilitarisationAlgorithm mA = new MilitarisationAlgorithm(ps);
		militarisation = mA.militarisationInitialisation();
		
		return militarisation;
	}
	
	public IndustrialFactors industrialFactorsCreator(Ressources ressourcesAvailable, PoliticalStatus ps, ArrayList<Integer> industriesValues) {
		IndustrialFactors industrialFactors;
		IndustriesAlgorithm iA = new IndustriesAlgorithm(ressourcesAvailable, ps, custom, ressourcesSizeValues);
		industrialFactors = iA.industriesInitialisation(industriesValues);
		
		return industrialFactors;
		
	}
	
	public EconomicalFactors economicalFactorsCreator(IndustrialFactors industries, ArrayList<Integer> enconomicalValues) {
		EconomicalFactors economicalFactors;
		EconomicalFactorsAlgorithm eA = new EconomicalFactorsAlgorithm(economicalFactorsSizeValues, industries, custom);
		economicalFactors = eA.economicalFactorsInitialisation(enconomicalValues);
		
		return economicalFactors;
	}

	public boolean isCustom() {
		return custom;
	}

	public int[][] getRessourcesSizeValues() {
		return ressourcesSizeValues;
	}

	public int[][] getEconomicalFactorsSizeValues() {
		return economicalFactorsSizeValues;
	}

	public HashMap<String, ArrayList<Integer>> getRegionData() {
		return regionData;
	}

}

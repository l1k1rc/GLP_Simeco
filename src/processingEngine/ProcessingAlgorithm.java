package processingEngine;

import java.util.Set;

import economy.EconomicalFactors;
import military.Militarisation;
import region.Country;
import region.RegionMap;
import ressources.Ressources;

public class ProcessingAlgorithm {
	private double[] lastUnemploymentRate;
	
	public ProcessingAlgorithm() {
		this.lastUnemploymentRate = new double[] {0,0,0,0,0,0,0,0,0,0};
	}

	public RegionMap engineProcess(RegionMap region) {
		int count = -1;
		Set<String> keySet = region.getMapRegion().keySet();
		for (String key : keySet) {
			count++;
			//Resources
			RessourceProcess ressourceProcess = new RessourceProcess(region.getState(key).getIndustrialFactors(),
					region.getState(key).getRessources());
			Ressources newRessources = ressourceProcess.ressourcesReducer();
			region.getState(key).setRessources(newRessources);
			
			//Industries
			IndustryProcess industryProcess = new IndustryProcess(region.getState(key));
			Country newCountry = industryProcess.industrialProcess();
			region.setCountry(newCountry);
			
			//Economical Factors
			EconomicalFactorsProcess efProcess = new EconomicalFactorsProcess(lastUnemploymentRate[count], 
					region.getState(key).getPoliticalStatus(), region.getState(key).getEconomicalFactors());
			EconomicalFactors newEconomicalFactors = efProcess.economicalProcess();
			lastUnemploymentRate[count] = region.getState(key).getEconomicalFactors().getPopulationValues().getUnemploymentRate();
			region.getState(key).setEconomicalFactors(newEconomicalFactors);
			
			//Militarisation
			MilitaryProcess militaryProcess = new MilitaryProcess(region.getState(key).getPoliticalStatus(), 
					region.getState(key).getEconomicalFactors());
			Militarisation newMilitarisation = militaryProcess.militaryProcess(region.getState(key).getMilitarisation());
			region.getState(key).setMilitarisation(newMilitarisation);
			
			//Trade Agreements
			TradeAgreementsProcess taP = new TradeAgreementsProcess(region.getState(key).getName(), region);
			RegionMap newRegion = taP.agreementsProcess();
			Set<String> keySetNewRegion = newRegion.getMapRegion().keySet();
			for (String keyNewRegion : keySetNewRegion) {
				region.setCountry(newRegion.getState(keyNewRegion));
			}
			
		}
		
		return region;
	}
	
	
	
	
	
	
}

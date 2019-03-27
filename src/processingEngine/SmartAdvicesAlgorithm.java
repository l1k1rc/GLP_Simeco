package processingEngine;

import java.util.HashMap;
import java.util.Set;

import region.Country;
import region.RegionMap;
import ressources.Ressources;

public class SmartAdvicesAlgorithm {
	private RegionMap region;

	public SmartAdvicesAlgorithm(RegionMap region) {
		this.region = region;
	}
	
	public RegionMap crisisDetector(){
		@SuppressWarnings("unchecked")
		HashMap<String,Country> testRegion = (HashMap<String, Country>) region.getMapRegion().clone();
		Set<String> keySet = testRegion.keySet();
		int i;
		//Lets see if in 3 years, some countries will be in critical situation with their resources
		for (String key : keySet) {
			//We will treat resources 3 times for each country to see what append
			for(i=0; i<3 ; i++) {
				RessourceProcess ressourceProcess = new RessourceProcess(testRegion.get(key).getIndustrialFactors(),
						testRegion.get(key).getRessources());
				Ressources newRessources = ressourceProcess.ressourcesReducer();
				testRegion.get(key).setRessources(newRessources);
			}
			
			
			//Now check if some resources are empty to prepare industrial revolution
			if ((testRegion.get(key).getRessources().getLakes().getGlobalSize() == 0) 
					&& (testRegion.get(key).getIndustrialFactors().getFoodIndustries().getFishingIndustries() > 12)) {
				region.getState(key).getRessources().replaceCriticalRessource(0, true);
			}
			if ((testRegion.get(key).getRessources().getSuitablesLands().getGlobalSize() == 0) 
				&& (testRegion.get(key).getIndustrialFactors().getFoodIndustries().getAnimalIndustries() > 12)) {
				region.getState(key).getRessources().replaceCriticalRessource(1, true);
			}
			if ((testRegion.get(key).getRessources().getFields().getGlobalSize() == 0)  
				&& (testRegion.get(key).getIndustrialFactors().getFoodIndustries().getFarmingIndustries() > 12)) {
				region.getState(key).getRessources().replaceCriticalRessource(2, true);
			}
			if ((testRegion.get(key).getRessources().getForests().getGlobalSize() == 0)  
				&& (testRegion.get(key).getIndustrialFactors().getWoodIndustry().getPercentageOf() > 12)) {
				region.getState(key).getRessources().replaceCriticalRessource(3, true);
			}
			if ((testRegion.get(key).getRessources().getOilWell().getGlobalSize() == 0)  
				&& (testRegion.get(key).getIndustrialFactors().getFuelIndustry().getPercentageOf() > 12)) {
				region.getState(key).getRessources().replaceCriticalRessource(4, true);
			}
			if ((testRegion.get(key).getRessources().getGoldMines().getGlobalSize() == 0)  
				&& (testRegion.get(key).getIndustrialFactors().getMiningProcessingIndustries().getGoldIndustries() > 12)) {
				region.getState(key).getRessources().replaceCriticalRessource(5, true);
			}
			if ((testRegion.get(key).getRessources().getIronMines().getGlobalSize() == 0)  
				&& (testRegion.get(key).getIndustrialFactors().getMiningProcessingIndustries().getSteelIndustries() > 12)) {
				region.getState(key).getRessources().replaceCriticalRessource(6, true);
			}
			if ((testRegion.get(key).getRessources().getCoalMines().getGlobalSize() == 0)  
				&& (testRegion.get(key).getIndustrialFactors().getMiningProcessingIndustries().getCoalIndustries() > 12)) {
				region.getState(key).getRessources().replaceCriticalRessource(7, true);
			}
		}
		
		return region;
	}
	
	public boolean[] helpNeededDetector() {
		int i,j=-1;
		//Check if industry of this resource is eligible to be reworked.
		boolean[] needHelp = new boolean[] {false,false,false,false,false,false,false,false,false,false};
		Set<String> keySet = region.getMapRegion().keySet();
		for (String key : keySet) {
			j++;
			for (i=0; i<8; i++) {
				if ((region.getState(key).getRessources().getCriticalRessources()[i] == true) &&
						(region.getState(key).getRessources().getHelpAvailable()[i] == true)) {
					needHelp[j] = true;
				}
			}
		}
		
		return needHelp;
	}
	
	public RegionMap helpProcess(int indexCountry, boolean help) {
		int i = -1;
		boolean[] falseTab = {false,false,false,false,false,false,false,false};
		Set<String> keySet = region.getMapRegion().keySet();
		for (String key : keySet) {
			i++;
			if (i == indexCountry) {
				if (help == false) {
					for(int j=0; j<8; j++) {
						if (region.getState(key).getRessources().getByIndexCriticalRessource(j) == true)
							region.getState(key).getRessources().setHelpAvailable(falseTab);
					}	
				}
				else if (help == true) {
					int percentageToDispatch = 0;
					for(int j=0; j<8; j++) {
						if ((region.getState(key).getRessources().getCriticalRessources()[j] == true) &&
								(region.getState(key).getRessources().getHelpAvailable()[j] == true)) {
							region.getState(key).getRessources().setHelpAvailable(falseTab);
							switch (j) {
							case 0 :percentageToDispatch += region.getState(key).getIndustrialFactors().getFoodIndustries().getFishingIndustries();
									region.getState(key).getIndustrialFactors().getFoodIndustries().setFishingIndustries(0);
								break;
							case 1 :percentageToDispatch += region.getState(key).getIndustrialFactors().getFoodIndustries().getAnimalIndustries();
									region.getState(key).getIndustrialFactors().getFoodIndustries().setAnimalIndustries(0);
								break;
							case 2 :percentageToDispatch += region.getState(key).getIndustrialFactors().getFoodIndustries().getFarmingIndustries();
									region.getState(key).getIndustrialFactors().getFoodIndustries().setFarmingIndustries(0);
								break;
							case 3 :percentageToDispatch += region.getState(key).getIndustrialFactors().getWoodIndustry().getPercentageOf();
									region.getState(key).getIndustrialFactors().getWoodIndustry().setPercentageOf(0);
								break;
							case 4 :percentageToDispatch += region.getState(key).getIndustrialFactors().getFuelIndustry().getPercentageOf();
									region.getState(key).getIndustrialFactors().getFuelIndustry().setPercentageOf(0);
								break;
							case 5 :percentageToDispatch += region.getState(key).getIndustrialFactors().getMiningProcessingIndustries().getGoldIndustries();
									region.getState(key).getIndustrialFactors().getMiningProcessingIndustries().setGoldIndustries(0);
								break;
							case 6 :percentageToDispatch += region.getState(key).getIndustrialFactors().getMiningProcessingIndustries().getSteelIndustries();
									region.getState(key).getIndustrialFactors().getMiningProcessingIndustries().setSteelIndustries(0);
								break;
							case 7 :percentageToDispatch += region.getState(key).getIndustrialFactors().getMiningProcessingIndustries().getCoalIndustries();
									region.getState(key).getIndustrialFactors().getMiningProcessingIndustries().setCoalIndustries(0);
								break;
							}
						}
						
						int count = -1;
						int round = 0;
						//Dispatch on others industries the percentage of the critical resource
						while (percentageToDispatch != 0) {
							round++;
							if (round%8 != 0) count++;
							else count = 0;
							
							if (region.getState(key).getRessources().getCriticalRessources()[count] == false) {
								switch (count) {
								case 0: region.getState(key).getIndustrialFactors().getFoodIndustries().setFishingIndustries(
										region.getState(key).getIndustrialFactors().getFoodIndustries().getFishingIndustries()+1);
										percentageToDispatch--;
									break;
								case 1:	region.getState(key).getIndustrialFactors().getFoodIndustries().setAnimalIndustries(
										region.getState(key).getIndustrialFactors().getFoodIndustries().getAnimalIndustries()+1);
										percentageToDispatch--;
									break;
								case 2: region.getState(key).getIndustrialFactors().getFoodIndustries().setFarmingIndustries(
										region.getState(key).getIndustrialFactors().getFoodIndustries().getFarmingIndustries()+1);
										percentageToDispatch--;
									break;
								case 3: region.getState(key).getIndustrialFactors().getWoodIndustry().setPercentageOf(
										region.getState(key).getIndustrialFactors().getWoodIndustry().getPercentageOf()+1);
										percentageToDispatch--;
									break;
								case 4:	region.getState(key).getIndustrialFactors().getFuelIndustry().setPercentageOf(
										region.getState(key).getIndustrialFactors().getFuelIndustry().getPercentageOf()+1);
										percentageToDispatch--;
									break;
								case 5: region.getState(key).getIndustrialFactors().getMiningProcessingIndustries().setGoldIndustries(
										region.getState(key).getIndustrialFactors().getMiningProcessingIndustries().getGoldIndustries()+1);
										percentageToDispatch--;
									break;
								case 6: region.getState(key).getIndustrialFactors().getMiningProcessingIndustries().setSteelIndustries(
										region.getState(key).getIndustrialFactors().getMiningProcessingIndustries().getSteelIndustries()+1);
										percentageToDispatch--;
									break;
								case 7: region.getState(key).getIndustrialFactors().getMiningProcessingIndustries().setCoalIndustries(
										region.getState(key).getIndustrialFactors().getMiningProcessingIndustries().getCoalIndustries()+1);
										percentageToDispatch--;
									break;
								}
							}
						}
					}
				}
			}
		}
		
		return region;
	}
	
}

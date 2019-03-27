package processingEngine;

import java.util.Set;

import region.RegionMap;


public class RegionProcess {
	private RegionMap region;
	
	
	public RegionProcess(RegionMap region) {
		this.region = region;
		
	}
	
	public double [] moyenneRegion() {
		double[] tabMoy = new double[27];
		double nbmoyLake = 0;
		double nbmoySuitableLand = 0;
		double nbmoyFields = 0;
		double nbmoyForest = 0;
		double nbmoyOil = 0;
		double nbmoyGoldMines = 0;
		double nbmoyIronMines = 0;
		double nbmoyCoalMines = 0;
		double nbmoyAnimalIndu = 0;
		double nbmoyFishIndu = 0;
		double nbmoyFarmIndu = 0;
		double nbmoySteelIndu = 0;
		double nbmoyGoldIndu = 0;
		double nbmoyCoalIndu = 0;
		double nbmoyWoodIndu = 0;
		double nbmoyFuelIndu = 0;
		double nbmoySoldiers = 0;
		double nbmoyMilitaryBudget = 0;
		double nbmoyPopGrowth = 0;
		double nbmoyGini = 0;
		double nbmoyRechercheSpending = 0;
		double nbmoyMiddleAge = 0;
		double nbmoyUnemRate = 0;
		double nbmoyGdp = 0;
		double nbmoyHid = 0;
		double nbmoyCapIncome = 0;
		double nbmoyPop = 0;
		Set<String> keySet = region.getMapRegion().keySet();
		for (String key : keySet) {
			nbmoyLake += region.getState(key).getRessources().getLakes().getNumberOf();
			nbmoySuitableLand += region.getState(key).getRessources().getSuitablesLands().getNumberOf();
			nbmoyFields += region.getState(key).getRessources().getFields().getNumberOf();
			nbmoyForest += region.getState(key).getRessources().getForests().getNumberOf();
			nbmoyOil += region.getState(key).getRessources().getOilWell().getNumberOf();
			nbmoyGoldMines += region.getState(key).getRessources().getGoldMines().getNumberOf();
			nbmoyIronMines += region.getState(key).getRessources().getIronMines().getNumberOf();
			nbmoyCoalMines += region.getState(key).getRessources().getCoalMines().getNumberOf();
			
			nbmoyAnimalIndu += region.getState(key).getIndustrialFactors().getFoodIndustries().getAnimalIndustries();
			nbmoyFishIndu += region.getState(key).getIndustrialFactors().getFoodIndustries().getFishingIndustries();
			nbmoyFarmIndu += region.getState(key).getIndustrialFactors().getFoodIndustries().getFarmingIndustries();
			nbmoySteelIndu += region.getState(key).getIndustrialFactors().getMiningProcessingIndustries().getSteelIndustries();
			nbmoyGoldIndu += region.getState(key).getIndustrialFactors().getMiningProcessingIndustries().getGoldIndustries();
			nbmoyCoalIndu += region.getState(key).getIndustrialFactors().getMiningProcessingIndustries().getCoalIndustries();
			nbmoyWoodIndu += region.getState(key).getIndustrialFactors().getWoodIndustry().getPercentageOf();
			nbmoyFuelIndu += region.getState(key).getIndustrialFactors().getFuelIndustry().getPercentageOf();
			
			nbmoySoldiers += region.getState(key).getMilitarisation().getNbSoldiers();
			nbmoyMilitaryBudget += region.getState(key).getMilitarisation().getMilitaryBudget();
			
			nbmoyPopGrowth += region.getState(key).getEconomicalFactors().getPopulationValues().getPopulationGrowth();
			nbmoyGini += region.getState(key).getEconomicalFactors().getPopulationValues().getGini();
			nbmoyRechercheSpending += region.getState(key).getEconomicalFactors().getPopulationValues().getReschercheSpending();
			nbmoyMiddleAge += region.getState(key).getEconomicalFactors().getPopulationValues().getMiddleAge();
			nbmoyUnemRate += region.getState(key).getEconomicalFactors().getPopulationValues().getUnemploymentRate();
			
			nbmoyGdp += region.getState(key).getEconomicalFactors().getGdpValues().getGdp();
			nbmoyHid += region.getState(key).getEconomicalFactors().getHidValues().getHid();
			nbmoyCapIncome += region.getState(key).getEconomicalFactors().getHidValues().getPerCapitaIncome().getPerCapitaIncome();
			nbmoyPop += region.getState(key).getEconomicalFactors().getHidValues().getPerCapitaIncome().getPopulation();
		}
		
		nbmoyLake /= 10;
		nbmoySuitableLand /= 10;
		nbmoyFields /= 10;
		nbmoyForest /=10;
		nbmoyOil /= 10;
		nbmoyGoldMines /= 10;
		nbmoyIronMines /= 10;
		nbmoyCoalMines /= 10;
		nbmoyAnimalIndu /= 10;
		nbmoyFishIndu /= 10;
		nbmoyFarmIndu /= 10;
		nbmoySteelIndu /= 10;
		nbmoyGoldIndu /= 10;
		nbmoyCoalIndu /= 10;
		nbmoyWoodIndu /= 10;
		nbmoyFuelIndu /= 10;
		nbmoySoldiers /= 10;
		nbmoyMilitaryBudget /= 10;
		nbmoyPopGrowth /= 10;
		nbmoyGini /= 10;
		nbmoyRechercheSpending /= 10;
		nbmoyMiddleAge /= 10;
		nbmoyUnemRate /= 10;
		nbmoyGdp /= 10;
		nbmoyHid /= 10;
		nbmoyCapIncome /= 10;
		nbmoyPop /= 10;
		
		
		tabMoy[0]=nbmoyLake;
		tabMoy[1]=nbmoySuitableLand;
		tabMoy[2]=nbmoyFields;
		tabMoy[3]=nbmoyForest;
		tabMoy[4]=nbmoyOil;
		tabMoy[5]=nbmoyGoldMines;
		tabMoy[6]=nbmoyIronMines;
		tabMoy[7]=nbmoyCoalMines;
		tabMoy[8]=nbmoyAnimalIndu;
		tabMoy[9]=nbmoyFishIndu;
		tabMoy[10]=nbmoyFarmIndu;
		tabMoy[11]=nbmoySteelIndu;
		tabMoy[12]=nbmoyGoldIndu;
		tabMoy[13]=nbmoyCoalIndu;
		tabMoy[14]=nbmoyWoodIndu;
		tabMoy[15]=nbmoyFuelIndu;
		tabMoy[16]=nbmoySoldiers;
		tabMoy[17]=nbmoyMilitaryBudget;
		tabMoy[18]=nbmoyPopGrowth;
		tabMoy[19]=nbmoyGini;
		tabMoy[20]=nbmoyRechercheSpending;
		tabMoy[21]=nbmoyMiddleAge;
		tabMoy[22]=nbmoyUnemRate;
		tabMoy[23]=nbmoyGdp;
		tabMoy[24]=nbmoyHid;
		tabMoy[25]=nbmoyCapIncome;
		tabMoy[26]=nbmoyPop;
		
		return tabMoy;
		
	}

	public RegionMap getRegion() {
		return region;
	}

	public void setRegion(RegionMap region) {
		this.region = region;
	}

}

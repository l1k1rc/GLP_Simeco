package processingEngine;

import industries.IndustrialFactors;
import ressources.Ressources;

public class RessourceProcess {
	private IndustrialFactors industriesData;
	private Ressources ressourcesData;
	
	public RessourceProcess(IndustrialFactors industriesData, Ressources ressourcesData) {
		this.industriesData = industriesData;
		this.ressourcesData = ressourcesData;
	}
	
	public Ressources ressourcesReducer() {
		int i, reducerValue;
		//Lakes reducer
		reducerValue = reducerCalculator(industriesData.getFoodIndustries().getFishingIndustries(), 5850, 
				ressourcesData.getLakes().getNumberOf(), true);
		
		for (i=0; i<ressourcesData.getLakes().getNumberOf(); i++) {
			ressourcesData.getLakes().lakeByIndex(i).setContentSize(ressourcesData.getLakes().lakeByIndex(i).getContentSize()+reducerValue);
		}
		
		//Suitable lands reducer
		reducerValue = reducerCalculator(industriesData.getFoodIndustries().getAnimalIndustries(), 100000, ressourcesData.getSuitablesLands().getNumberOf(), true);
		
		for (i=0; i<ressourcesData.getSuitablesLands().getNumberOf(); i++) {
			ressourcesData.getSuitablesLands().suitableLandByIndex(i).setContentSize(ressourcesData.getSuitablesLands().suitableLandByIndex(i)
					.getContentSize()+reducerValue);
		}
		
		//Fields reducer
		reducerValue = reducerCalculator(industriesData.getFoodIndustries().getFarmingIndustries(), 25000, 
				ressourcesData.getFields().getNumberOf(), false);
		
		for (i=0; i<ressourcesData.getFields().getNumberOf(); i++) {
			ressourcesData.getFields().fieldByIndex(i).setContentSize(ressourcesData.getFields().fieldByIndex(i).getContentSize()+reducerValue);
		}
		
		//Forests reducer
		reducerValue = reducerCalculator(industriesData.getWoodIndustry().getPercentageOf(), 12000, 
				ressourcesData.getForests().getNumberOf(), true);
		
		for (i=0; i<ressourcesData.getForests().getNumberOf(); i++) {
			ressourcesData.getForests().forestByIndex(i).setContentSize(ressourcesData.getForests().forestByIndex(i)
					.getContentSize()+reducerValue);
		}
		
		//OilWell reducer
		reducerValue = reducerCalculator(industriesData.getFuelIndustry().getPercentageOf(), 100000, 
				ressourcesData.getOilWell().getNumberOf(), false);
		
		for (i=0; i<ressourcesData.getOilWell().getNumberOf(); i++) {
			ressourcesData.getOilWell().oilWellByIndex(i).setContentSize(ressourcesData.getOilWell().oilWellByIndex(i)
					.getContentSize()+reducerValue);
		}
		
		//GoldMines reducer
		reducerValue = reducerCalculator(industriesData.getMiningProcessingIndustries().getGoldIndustries(), 10000, 
				ressourcesData.getGoldMines().getNumberOf(), false);
		
		for (i=0; i<ressourcesData.getGoldMines().getNumberOf(); i++) {
			ressourcesData.getGoldMines().goldMineByIndex(i).setContentSize(ressourcesData.getGoldMines().goldMineByIndex(i)
					.getContentSize()+reducerValue);
		}
		
		//IronMines reducer
		reducerValue = reducerCalculator(industriesData.getMiningProcessingIndustries().getSteelIndustries(), 12500, 
				ressourcesData.getIronMines().getNumberOf(), false);
		
		for (i=0; i<ressourcesData.getIronMines().getNumberOf(); i++) {
			ressourcesData.getIronMines().ironMineByIndex(i).setContentSize(ressourcesData.getIronMines().ironMineByIndex(i)
					.getContentSize()+reducerValue);
		}
		
		//CoalMines reducer
		reducerValue = reducerCalculator(industriesData.getMiningProcessingIndustries().getCoalIndustries(), 15000, 
				ressourcesData.getCoalMines().getNumberOf(), false);
		
		for (i=0; i<ressourcesData.getCoalMines().getNumberOf(); i++) {
			ressourcesData.getCoalMines().coalMineByIndex(i).setContentSize(ressourcesData.getCoalMines().coalMineByIndex(i)
					.getContentSize()+reducerValue);
		}
		
		ressourcesData = this.removeEmptyRessources(ressourcesData);
		
		return ressourcesData;
	}
	
	
	public int reducerCalculator(int percentage, int valMax, int currentNbr, boolean renewable) {
		int calc = valMax/1000;
		if (calc != 0) {		//round up value
			calc++;
		}
		
		if (renewable == true) {	//If this resource is renewable, it regenerate about 15% of industrialization each time
			int renew = calc*15;
			calc *= -percentage;
			calc += renew;
		}
		else calc *= -percentage;
		
		calc /= 2;
		//If renewable percentage > exploiting percentage -> then this resource grow 
		if ((calc > 0) && (currentNbr > 0)) {		
			calc /= currentNbr;	//devide by nbr of 
			calc++;				//round up value
		}
		else if ((calc < 0) && (currentNbr > 0)) {
			calc /= currentNbr;	//devide by nbr of 
			calc--;				//round down value 
		}
		
		return calc;
	}
	
	public Ressources removeEmptyRessources(Ressources ressourcesData) {
		int i;
		//Lakes remover
		for (i=0; i<ressourcesData.getLakes().getNumberOf(); i++) {
			if (ressourcesData.getLakes().lakeByIndex(i).getContentSize() <= 0) {
				ressourcesData.getLakes().delLake(i);
				i--;
			}
		}
		ressourcesData.getLakes().updateGlobalSize();
		
		//Suitable lands remover		
		for (i=0; i<ressourcesData.getSuitablesLands().getNumberOf(); i++) {
			if (ressourcesData.getSuitablesLands().suitableLandByIndex(i).getContentSize() <= 0) {
				ressourcesData.getSuitablesLands().delSuitableLand(i);	
				i--;
			}
		}
		ressourcesData.getSuitablesLands().updateGlobalSize();		
		
		//Fields remover		
		for (i=0; i<ressourcesData.getFields().getNumberOf(); i++) {
			if (ressourcesData.getFields().fieldByIndex(i).getContentSize() <= 0) {
				ressourcesData.getFields().delField(i);	
				i--;
			}
		}
		ressourcesData.getFields().updateGlobalSize();
		
		//Forests remover		
		for (i=0; i<ressourcesData.getForests().getNumberOf(); i++) {
			if (ressourcesData.getForests().forestByIndex(i).getContentSize() <= 0) {
				ressourcesData.getForests().delForest(i);	
				i--;
			}
		}
		ressourcesData.getForests().updateGlobalSize();
		
		//OilWell remover
		for (i=0; i<ressourcesData.getOilWell().getNumberOf(); i++) {
			if (ressourcesData.getOilWell().oilWellByIndex(i).getContentSize() <= 0) {
				ressourcesData.getOilWell().delOilWell(i);	
				i--;
			}
		}
		ressourcesData.getOilWell().updateGlobalSize();
		
		//GoldMines remover
		for (i=0; i<ressourcesData.getGoldMines().getNumberOf(); i++) {
			if (ressourcesData.getGoldMines().goldMineByIndex(i).getContentSize() <= 0) {
				ressourcesData.getGoldMines().delGoldMine(i);	
				i--;
			}
		}
		ressourcesData.getGoldMines().updateGlobalSize();
		
		//IronMines remover		
		for (i=0; i<ressourcesData.getIronMines().getNumberOf(); i++) {
			if (ressourcesData.getIronMines().ironMineByIndex(i).getContentSize() <= 0) {
				ressourcesData.getIronMines().delIronMine(i);	
				i--;
			}
		}
		ressourcesData.getIronMines().updateGlobalSize();
		
		//CoalMines remover
		for (i=0; i<ressourcesData.getCoalMines().getNumberOf(); i++) {
			if (ressourcesData.getCoalMines().coalMineByIndex(i).getContentSize() <= 0) {
				ressourcesData.getCoalMines().delCoalMine(i);	
				i--;
			}
		}
		ressourcesData.getCoalMines().updateGlobalSize();
		
		return ressourcesData;
	}


	public IndustrialFactors getIndustriesData() {
		return industriesData;
	}

	public void setIndustriesData(IndustrialFactors industriesData) {
		this.industriesData = industriesData;
	}
	
	
	
}

package processingEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import engine.RandomValue;
import region.Country;
import region.RegionMap;

//All is in million $
public class TradeAgreementsProcess {
	private String country;
	private RegionMap region;
	private int[][] prices;
	
	public TradeAgreementsProcess(String country, RegionMap region) {
		this.country = country;
		this.region = region;
		prices = new int[6][2];
		this.exploitationPrice();
	}
	
	private void exploitationPrice() {
		////////Commercial Agreement\\\\\\\\
		//Lakes, SuitableLands, Fields 
		int[] tab = new int[]{5000,8000};
		prices[0] = tab;
		//Wood, coal
		tab = new int[]{8000,10000};
		prices[1] = tab;
		//petrol, gold, iron
		tab = new int[]{10000,15000};
		prices[2] = tab;
		
		////////Commercial Agreement\\\\\\\\
		//Fishing, Animals, Farming
		tab = new int[]{200000,400000};
		prices[3] = tab;
		//Steel, Gold, Coal
		tab = new int[]{400000,700000};
		prices[4] = tab;
		//Wood, Fuel
		tab = new int[]{250000,400000};
		prices[5] = tab;
		
		
	}
	
	public RegionMap agreementsProcess() {
		region = this.commercialProcess();
		region = this.industrialProcess();
		region = this.militaryProcess();
		
		return region;
	}
	
	public RegionMap commercialProcess(){
		if (region.getState(country).getEconomicalFactors().getGdpValues().getGdp() > 2000000) { //Requirement
			int chance = RandomValue.generateNumber(10);
			if (chance == 5) {
				int ressourceChosen = RandomValue.generateNumber(8);							//Random resource
				
				//Check witch country match with the request
				Set<String> keySet = region.getMapRegion().keySet();
				ArrayList<Country> availableCountry = new ArrayList<Country>();
				switch (ressourceChosen) {
				case 0: for (String key : keySet) {
							if ((region.getMapRegion().get(key).getEconomicalFactors().getGdpValues().getGdp() <= 1500000) &&
								(region.getMapRegion().get(key).getIndustrialFactors().getFoodIndustries().getFishingIndustries() <= 10)) {
									availableCountry.add(region.getState(key));
							}
						}
						region = this.commercialTool(region, country, availableCountry, prices[0][0], prices[0][1]);
					break;
					
				case 1:	for (String key : keySet) {
							if ((region.getMapRegion().get(key).getEconomicalFactors().getGdpValues().getGdp() <= 1500000) &&
								(region.getMapRegion().get(key).getIndustrialFactors().getFoodIndustries().getAnimalIndustries() <= 10)) {
									availableCountry.add(region.getState(key));
							}
						}
						region = this.commercialTool(region, country,availableCountry, prices[0][0], prices[0][1]);
					break;
				case 2:	for (String key : keySet) {
							if ((region.getMapRegion().get(key).getEconomicalFactors().getGdpValues().getGdp() <= 1500000) &&
								(region.getMapRegion().get(key).getIndustrialFactors().getFoodIndustries().getFarmingIndustries() <= 10)) {
									availableCountry.add(region.getState(key));
							}
						}
						region = this.commercialTool(region, country, availableCountry, prices[0][0], prices[0][1]);
					break;
				case 3:	for (String key : keySet) {
							if ((region.getMapRegion().get(key).getEconomicalFactors().getGdpValues().getGdp() <= 1500000) &&
								(region.getMapRegion().get(key).getIndustrialFactors().getMiningProcessingIndustries().getSteelIndustries() <= 10)) {
									availableCountry.add(region.getState(key));
							}
						}
						region = this.commercialTool(region, country, availableCountry, prices[2][0], prices[2][1]);
					break;
				case 4:	for (String key : keySet) {
							if ((region.getMapRegion().get(key).getEconomicalFactors().getGdpValues().getGdp() <= 1500000) &&
								(region.getMapRegion().get(key).getIndustrialFactors().getMiningProcessingIndustries().getGoldIndustries() <= 10)) {
									availableCountry.add(region.getState(key));
							}
						}
					region = this.commercialTool(region, country, availableCountry, prices[2][0], prices[2][1]);
					break;
				case 5:	for (String key : keySet) {
							if ((region.getMapRegion().get(key).getEconomicalFactors().getGdpValues().getGdp() <= 1500000) &&
								(region.getMapRegion().get(key).getIndustrialFactors().getMiningProcessingIndustries().getCoalIndustries() <= 10)) {
									availableCountry.add(region.getState(key));
							}
						}
						region = this.commercialTool(region, country, availableCountry, prices[1][0], prices[1][1]);
					break;
				case 6:	for (String key : keySet) {
							if ((region.getMapRegion().get(key).getEconomicalFactors().getGdpValues().getGdp() <= 1500000) &&
								(region.getMapRegion().get(key).getIndustrialFactors().getWoodIndustry().getPercentageOf() <= 10)) {
									availableCountry.add(region.getState(key));
							}
						}
						region = this.commercialTool(region, country, availableCountry, prices[1][0], prices[1][1]);
					break;
				case 7:	for (String key : keySet) {
							if ((region.getMapRegion().get(key).getEconomicalFactors().getGdpValues().getGdp() <= 1500000) &&
								(region.getMapRegion().get(key).getIndustrialFactors().getFuelIndustry().getPercentageOf() <= 10)) {
									availableCountry.add(region.getState(key));
							}
						}
						region = this.commercialTool(region, country, availableCountry, prices[2][0], prices[2][1]);
					break;
				}
				
			}
		}
		
		//Now, we want to check if this country got earnings this year due to its commercials agreements
		ArrayList<int[]> investments = region.getState(country).getEconomicalFactors().getTradeAgreements().getCommAgr().getReturnOnInvestment();
		if (investments.isEmpty() == false) {
			int count = -1;
			for(int[] tab : investments) {
				count++;
				if (tab[1] != 0) {
					region.getState(country).getEconomicalFactors().getTradeAgreements().getCommAgr().newYear(count);
					int newVal = (region.getState(country).getEconomicalFactors().getGdpValues().getConsuption())+(tab[0]);
					region.getState(country).getEconomicalFactors().getGdpValues().setConsuption(newVal);
					newVal = (region.getState(country).getEconomicalFactors().getGdpValues().getInvestment())+(tab[0]);
					region.getState(country).getEconomicalFactors().getGdpValues().setInvestment(newVal);
					
					region = this.updatePciHid(country, region);
					
				}
			}
		}
		
		return region;
			
		
	}
	
	public RegionMap commercialTool(RegionMap regionIns, String countryName, ArrayList<Country> availableCountry , int priceMin, int priceMax) {
			//Are there countries corresponding to the criteria ?
			if (availableCountry.isEmpty() == true) return regionIns;
			
			//Choose country randomly
			int countrySelector = RandomValue.generateNumber(availableCountry.size());
			String countryChosen = availableCountry.get(countrySelector).getName();
			//Choose percentage of exploitation
			int exploitationPercentage = RandomValue.generateBoundedNumber(10, 31);
			
			//Add tradeArgeement
			regionIns.getState(countryChosen).getEconomicalFactors().getTradeAgreements().getCommAgr().addPartner(countryName);
			regionIns.getState(countryName).getEconomicalFactors().getTradeAgreements().getCommAgr().addPartner(countryChosen);
			
			//Add impact on economy for exporter
			int priceGenerate = RandomValue.generateBoundedNumber(priceMin, priceMax);
			int newVal = (regionIns.getState(countryChosen).getEconomicalFactors().getGdpValues().getExports())
							+(priceGenerate*exploitationPercentage);
			regionIns.getState(countryChosen).getEconomicalFactors().getGdpValues().setExports(newVal);
			regionIns = this.updatePciHid(countryChosen, regionIns);
			
			//Decrease of unemployment rate for exporter
			double newUnemploymentRate = (region.getState(countryChosen).getEconomicalFactors().getPopulationValues().getUnemploymentRate())
					-(exploitationPercentage*0.1);
			
			if (newUnemploymentRate < 0) region.getState(countryChosen).getEconomicalFactors().getPopulationValues().setUnemploymentRate(0);
			else region.getState(countryChosen).getEconomicalFactors().getPopulationValues().setUnemploymentRate(newUnemploymentRate);
			
			//Add impact on economy for exploiting country
			newVal = (regionIns.getState(countryName).getEconomicalFactors().getGdpValues().getImports())+(priceGenerate*exploitationPercentage);
			regionIns.getState(countryName).getEconomicalFactors().getGdpValues().setImports(newVal);
			regionIns = this.updatePciHid(countryName, regionIns);
			
			regionIns.getState(countryName).getEconomicalFactors().getTradeAgreements().getCommAgr().addReturnOnInvestment(priceGenerate);
			
			return regionIns;
			
	}
	
	
	public RegionMap industrialProcess() {
		int chance = RandomValue.generateNumber(20);
		if (chance == 10) {
			//Fill à tab with all industries percentages
			HashMap<Integer, Integer> percentagesIndustry = new HashMap<Integer, Integer>();
			percentagesIndustry.put(0, region.getState(country).getIndustrialFactors().getFoodIndustries().getFishingIndustries());
			percentagesIndustry.put(1, region.getState(country).getIndustrialFactors().getFoodIndustries().getAnimalIndustries());
			percentagesIndustry.put(2, region.getState(country).getIndustrialFactors().getFoodIndustries().getFarmingIndustries());
			percentagesIndustry.put(3, region.getState(country).getIndustrialFactors().getMiningProcessingIndustries().getSteelIndustries());
			percentagesIndustry.put(4, region.getState(country).getIndustrialFactors().getMiningProcessingIndustries().getGoldIndustries());
			percentagesIndustry.put(5, region.getState(country).getIndustrialFactors().getMiningProcessingIndustries().getCoalIndustries());
			percentagesIndustry.put(6, region.getState(country).getIndustrialFactors().getWoodIndustry().getPercentageOf());
			percentagesIndustry.put(7, region.getState(country).getIndustrialFactors().getFuelIndustry().getPercentageOf());
			
			//Find an industry with less 10% of exploitation
			boolean exist = false;
			for (int i=0; i<8; i++) {
				if (percentagesIndustry.get(i) <= 10) exist = true;
				else percentagesIndustry.remove(i);		
			}
			if (exist == true) {
				Set<Integer> keySet = percentagesIndustry.keySet();
				ArrayList<Integer> less10 = new ArrayList<Integer>();
				for (int key : keySet) {
					less10.add(key);
				}
				
				//Select industry randomly
				int ressourceIndex = RandomValue.generateNumber(less10.size());
				//Find country with 15 or more in this exploitation domain
				ArrayList<String> more15 = new ArrayList<String>();
				Set<String> keySet2 = region.getMapRegion().keySet();
				
				switch (ressourceIndex) {
				case 0: for (String key : keySet2) {
							if (region.getState(key).getIndustrialFactors().getFoodIndustries().getFishingIndustries() >= 15) more15.add(key);
						}
					break;
				case 1:	for (String key : keySet2) {
							if (region.getState(key).getIndustrialFactors().getFoodIndustries().getAnimalIndustries() >= 15) more15.add(key);
						}
					break;
				case 2:	for (String key : keySet2) {
							if (region.getState(key).getIndustrialFactors().getFoodIndustries().getFarmingIndustries() >= 15) more15.add(key);
						}
					break;
				case 3:	for (String key : keySet2) {
							if (region.getState(key).getIndustrialFactors().getMiningProcessingIndustries().getSteelIndustries() >= 15) more15.add(key);
						}
					break;
				case 4:	for (String key : keySet2) {
							if (region.getState(key).getIndustrialFactors().getMiningProcessingIndustries().getGoldIndustries() >= 15) more15.add(key);
						}
					break;
				case 5:	for (String key : keySet2) {
							if (region.getState(key).getIndustrialFactors().getMiningProcessingIndustries().getCoalIndustries() >= 15) more15.add(key);
						}
					break;
				case 6:	for (String key : keySet2) {
							if (region.getState(key).getIndustrialFactors().getWoodIndustry().getPercentageOf() >= 15) more15.add(key);
						}
					break;
				case 7:	for (String key : keySet2) {
							if (region.getState(key).getIndustrialFactors().getFuelIndustry().getPercentageOf() >= 15) more15.add(key);
						}
					break;
				}
				
				//Select a country randomly
				if (more15.isEmpty() == false) {
					if ((more15.size() > 1) || (more15.get(0).equals(country) == false)) { //If the country is the only one inside
						String countryChosen;
						do {
							int randCountry = RandomValue.generateNumber(more15.size());
							countryChosen = more15.get(randCountry);
						}while (((country.equals(countryChosen)) == true));
					
						//Add agreement
						region.getState(countryChosen).getEconomicalFactors().getTradeAgreements().getInduAgr().addPartner(country);
						region.getState(country).getEconomicalFactors().getTradeAgreements().getInduAgr().addPartner(countryChosen);
					
						//Increase GDP
						if ((ressourceIndex == 0) || (ressourceIndex == 1) || (ressourceIndex == 2)) {		  	//FoodIndustry
							region = this.industrialTool(countryChosen, region, prices[3][0], prices[3][1]);
						}
						else if ((ressourceIndex == 3) || (ressourceIndex == 4) || (ressourceIndex == 7)) { 	//Steel, Gold or Fuel
							region = this.industrialTool(countryChosen, region, prices[4][0], prices[4][1]);
						}
						else {																					//Coal or Wood
							region = this.industrialTool(countryChosen, region, prices[5][0], prices[5][1]);
						}
					}
				}
			}
		}
		return region;
	}
	
	public RegionMap industrialTool(String countryChosen, RegionMap regionIns, int priceMin, int priceMax) {
		//Increase Consuption, governmentSpending, Imports, exports for industrialAgreements Algorithm
		int randImportExport = RandomValue.generateBoundedNumber(priceMin, priceMax);
		regionIns.getState(countryChosen).getEconomicalFactors().getGdpValues().setExports(
				(regionIns.getState(countryChosen).getEconomicalFactors().getGdpValues().getExports())+randImportExport);
		
		regionIns.getState(country).getEconomicalFactors().getGdpValues().setImports(
				(regionIns.getState(country).getEconomicalFactors().getGdpValues().getImports())+randImportExport);
		int gdpIncrease = (int) (randImportExport*0.75);
		regionIns.getState(country).getEconomicalFactors().getGdpValues().setGovernementSpending(
				(regionIns.getState(country).getEconomicalFactors().getGdpValues().getGovernementSpending())+gdpIncrease);
		regionIns.getState(country).getEconomicalFactors().getGdpValues().setConsuption(
				(regionIns.getState(country).getEconomicalFactors().getGdpValues().getConsuption())+gdpIncrease);
		
		regionIns = this.updatePciHid(countryChosen, regionIns);
		regionIns = this.updatePciHid(country, regionIns);
		
		return regionIns;
	}
	
	
	public RegionMap militaryProcess() {
		//Requierement
		boolean yesWeCan = (region.getState(country).getEconomicalFactors().getTradeAgreements().getMilitaryAgr().getPartners().size()) < 3;
		int chance = RandomValue.generateNumber(15);
		//1/15 chance to make it
		if ((chance == 10) && (yesWeCan == true)) {
			ArrayList<String> availableCountry = new ArrayList<String>();
			Set<String> keySet = region.getMapRegion().keySet();
			
			//Listing available countries
			for (String key : keySet) {
				if ((region.getState(key).getEconomicalFactors().getTradeAgreements().getMilitaryAgr().getPartners().size()) < 3) {
					availableCountry.add(key);
				}
			}

			if ((availableCountry.size() > 1) || (availableCountry.get(0).equals(country) == false)) { //If the country is the only one inside
				String countryChosen;
				do {
					chance = RandomValue.generateNumber(availableCountry.size());
					countryChosen = availableCountry.get(chance);
				}while (((country.equals(countryChosen)) == true));
			
				//Add partner
				region.getState(countryChosen).getEconomicalFactors().getTradeAgreements().getMilitaryAgr().addPartner(country);
				region.getState(country).getEconomicalFactors().getTradeAgreements().getMilitaryAgr().addPartner(countryChosen);
			}
		}
		
		return region;
	}
	
	
	public RegionMap updatePciHid(String countryName, RegionMap regionIns) {
		regionIns.getState(countryName).getEconomicalFactors().getHidValues().getPerCapitaIncome().setIncome(
				regionIns.getState(countryName).getEconomicalFactors().getGdpValues().getGdp());			 //update pci
		regionIns.getState(countryName).getEconomicalFactors().getHidValues().setPerCapitaIncome(
				regionIns.getState(countryName).getEconomicalFactors().getHidValues().getPerCapitaIncome()); //update hid
		
		return regionIns;
	}

	public String getCountry() {
		return country;
	}

	public RegionMap getRegion() {
		return region;
	}

	public int[][] getPrices() {
		return prices;
	}
	
	
	
}

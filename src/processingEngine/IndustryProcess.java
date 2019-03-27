package processingEngine;
import engine.RandomValue;
import region.Country;

public class IndustryProcess {
	private Country country;
	
	
	
	public IndustryProcess(Country country) {
		this.country = country;
	}

	public Country industrialProcess() {
		int percentageRespect = 0;
		int[][] catastrophicTransition = country.getIndustrialFactors().getCatastrophicTransition();
		int chance, percentage;
		
		for (int index=0; index<8 ; index++) {
			chance = RandomValue.generateNumber(8);
			
			switch (index) {
			case 0:	if ((country.getRessources().getLakes().getGlobalSize() <= 0) && (catastrophicTransition[index][0] == 0)) {
						int[] tab = new int[] {1,9};
						catastrophicTransition[index] = tab;
					}
					else if (country.getRessources().getLakes().getGlobalSize() > 0) {
						percentage = country.getIndustrialFactors().getFoodIndustries().getFishingIndustries();
						if (chance == 0) {
							country.getIndustrialFactors().getFoodIndustries().setFishingIndustries(percentage-1);
							percentageRespect += 1;
						}
						else if (chance == 6) {
							country.getIndustrialFactors().getFoodIndustries().setFishingIndustries(percentage+1);
							percentageRespect -= 1;
						}
						else if (chance == 7) {
							chance = RandomValue.generateNumber(2);
							if (chance == 0) {
								country.getIndustrialFactors().getFoodIndustries().setFishingIndustries(percentage-2);
								percentageRespect += 2;
							}
							else {
									country.getIndustrialFactors().getFoodIndustries().setFishingIndustries(percentage+2);
									percentageRespect -= 2;
								}
							}
					
						if (country.getIndustrialFactors().getFoodIndustries().getFishingIndustries() < 0) {
							percentageRespect += country.getIndustrialFactors().getFoodIndustries().getFishingIndustries();
							country.getIndustrialFactors().getFoodIndustries().setFishingIndustries(0);
						}
					}
				break;
			case 1:	if ((country.getRessources().getSuitablesLands().getGlobalSize() <= 0) && (catastrophicTransition[index][0] == 0)) {
						int[] tab = new int[] {1,9};
						catastrophicTransition[index] = tab;
					}
					else if (country.getRessources().getSuitablesLands().getGlobalSize() > 0) {
						percentage = country.getIndustrialFactors().getFoodIndustries().getAnimalIndustries();
							if (chance == 0) {
								country.getIndustrialFactors().getFoodIndustries().setAnimalIndustries(percentage-1);
								percentageRespect += 1;
							}
							else if (chance == 6) {
								country.getIndustrialFactors().getFoodIndustries().setAnimalIndustries(percentage+1);
								percentageRespect -= 1;
							}
							else if (chance == 7) {
								chance = RandomValue.generateNumber(2);
								if (chance == 0) {
									country.getIndustrialFactors().getFoodIndustries().setAnimalIndustries(percentage-2);
									percentageRespect += 2;
								}
								else {
									country.getIndustrialFactors().getFoodIndustries().setAnimalIndustries(percentage+2);
									percentageRespect -= 2;
								}
							}

						if (country.getIndustrialFactors().getFoodIndustries().getAnimalIndustries() < 0) {
							percentageRespect += country.getIndustrialFactors().getFoodIndustries().getAnimalIndustries();
							country.getIndustrialFactors().getFoodIndustries().setAnimalIndustries(0);
						}
					}
				break;
			case 2:	if ((country.getRessources().getFields().getGlobalSize() <= 0) && (catastrophicTransition[index][0] == 0)) {
						int[] tab = new int[] {1,9};
						catastrophicTransition[index] = tab;
					}
					else if (country.getRessources().getFields().getGlobalSize() > 0) {
						percentage = country.getIndustrialFactors().getFoodIndustries().getFarmingIndustries();
							if (chance == 0) {
								country.getIndustrialFactors().getFoodIndustries().setFarmingIndustries(percentage-1);
								percentageRespect += 1;
							}
							else if (chance == 6) {
								country.getIndustrialFactors().getFoodIndustries().setFarmingIndustries(percentage+1);
								percentageRespect -= 1;
							}
							else if (chance == 7) {
								chance = RandomValue.generateNumber(2);
								if (chance == 0) {
									country.getIndustrialFactors().getFoodIndustries().setFarmingIndustries(percentage-2);
									percentageRespect += 2;
								}
								else {
									country.getIndustrialFactors().getFoodIndustries().setFarmingIndustries(percentage+2);
									percentageRespect -= 2;
								}
							}
					
						if (country.getIndustrialFactors().getFoodIndustries().getFarmingIndustries() < 0) {
							percentageRespect += country.getIndustrialFactors().getFoodIndustries().getFarmingIndustries();
							country.getIndustrialFactors().getFoodIndustries().setFarmingIndustries(0);
						}
					}
				break;
			case 3:	if ((country.getRessources().getIronMines().getGlobalSize() <= 0) && (catastrophicTransition[index][0] == 0)) {
						int[] tab = new int[] {1,9};
						catastrophicTransition[index] = tab;
					}
					else if (country.getRessources().getIronMines().getGlobalSize() > 0) {
						percentage = country.getIndustrialFactors().getMiningProcessingIndustries().getSteelIndustries();
							if (chance == 0) {
								country.getIndustrialFactors().getMiningProcessingIndustries().setSteelIndustries(percentage-1);
								percentageRespect += 1;
							}
							else if (chance == 6) {
								country.getIndustrialFactors().getMiningProcessingIndustries().setSteelIndustries(percentage+1);
								percentageRespect -= 1;
							}
							else if (chance == 7) {
								chance = RandomValue.generateNumber(2);
								if (chance == 0) {
									country.getIndustrialFactors().getMiningProcessingIndustries().setSteelIndustries(percentage-2);
									percentageRespect += 2;
								}
								else {
									country.getIndustrialFactors().getMiningProcessingIndustries().setSteelIndustries(percentage+2);
									percentageRespect -= 2;
								}
							}
					
						if (country.getIndustrialFactors().getMiningProcessingIndustries().getSteelIndustries() < 0) {
							percentageRespect += country.getIndustrialFactors().getMiningProcessingIndustries().getSteelIndustries();
							country.getIndustrialFactors().getMiningProcessingIndustries().setSteelIndustries(0);
						}
					}
				break;
			case 4:	if ((country.getRessources().getGoldMines().getGlobalSize() <= 0) && (catastrophicTransition[index][0] == 0)) {
						int[] tab = new int[] {1,9};
						catastrophicTransition[index] = tab;
					}
					else if (country.getRessources().getGoldMines().getGlobalSize() > 0) {
						percentage = country.getIndustrialFactors().getMiningProcessingIndustries().getGoldIndustries();
							if (chance == 0) {
								country.getIndustrialFactors().getMiningProcessingIndustries().setGoldIndustries(percentage-1);
								percentageRespect += 1;
							}
							else if (chance == 6) {
								country.getIndustrialFactors().getMiningProcessingIndustries().setGoldIndustries(percentage+1);
								percentageRespect -= 1;
							}
							else if (chance == 7) {
								chance = RandomValue.generateNumber(2);
								if (chance == 0) {
									country.getIndustrialFactors().getMiningProcessingIndustries().setGoldIndustries(percentage-2);
									percentageRespect += 2;
								}
								else {
									country.getIndustrialFactors().getMiningProcessingIndustries().setGoldIndustries(percentage+2);
									percentageRespect -= 2;
								}
							}
					
						if (country.getIndustrialFactors().getMiningProcessingIndustries().getGoldIndustries() < 0) {
							percentageRespect += country.getIndustrialFactors().getMiningProcessingIndustries().getGoldIndustries();
							country.getIndustrialFactors().getMiningProcessingIndustries().setGoldIndustries(0);
						}
					}
				break;
			case 5:	if ((country.getRessources().getCoalMines().getGlobalSize() <= 0) && (catastrophicTransition[index][0] == 0)) {
						int[] tab = new int[] {1,9};
						catastrophicTransition[index] = tab;
					}
					else if (country.getRessources().getCoalMines().getGlobalSize() > 0) {
						percentage = country.getIndustrialFactors().getMiningProcessingIndustries().getCoalIndustries();
							if (chance == 0) {
								country.getIndustrialFactors().getMiningProcessingIndustries().setCoalIndustries(percentage-1);
								percentageRespect += 1;
							}
							else if (chance == 6) {
								country.getIndustrialFactors().getMiningProcessingIndustries().setCoalIndustries(percentage+1);
								percentageRespect -= 1;
							}
							else if (chance == 7) {
								chance = RandomValue.generateNumber(2);
								if (chance == 0) {
									country.getIndustrialFactors().getMiningProcessingIndustries().setCoalIndustries(percentage-2);
									percentageRespect += 2;
								}
								else {
									country.getIndustrialFactors().getMiningProcessingIndustries().setCoalIndustries(percentage+2);
									percentageRespect -= 2;
								}
							}
					
						if (country.getIndustrialFactors().getMiningProcessingIndustries().getCoalIndustries() < 0) {
							percentageRespect += country.getIndustrialFactors().getMiningProcessingIndustries().getCoalIndustries();
							country.getIndustrialFactors().getMiningProcessingIndustries().setCoalIndustries(0);
						}
					}
				break;
			case 6:	if ((country.getRessources().getForests().getGlobalSize() <= 0) && (catastrophicTransition[index][0] == 0)) {
						int[] tab = new int[] {1,9};
						catastrophicTransition[index] = tab;
					}
					else if (country.getRessources().getForests().getGlobalSize() > 0) {
						percentage = country.getIndustrialFactors().getWoodIndustry().getPercentageOf();
							if (chance == 0) {
								country.getIndustrialFactors().getWoodIndustry().setPercentageOf(percentage-1);
								percentageRespect += 1;
							}
							else if (chance == 6) {
								country.getIndustrialFactors().getWoodIndustry().setPercentageOf(percentage+1);
								percentageRespect -= 1;
							}
							else if (chance == 7) {
								chance = RandomValue.generateNumber(2);
								if (chance == 0) {
									country.getIndustrialFactors().getWoodIndustry().setPercentageOf(percentage-2);
									percentageRespect += 2;
								}
								else {
									country.getIndustrialFactors().getWoodIndustry().setPercentageOf(percentage+2);
									percentageRespect -= 2;
								}
							}
							
						if (country.getIndustrialFactors().getWoodIndustry().getPercentageOf() < 0) {
							percentageRespect += country.getIndustrialFactors().getWoodIndustry().getPercentageOf();
							country.getIndustrialFactors().getWoodIndustry().setPercentageOf(0);
						}
					}
				break;
			case 7:	if ((country.getRessources().getOilWell().getGlobalSize() <= 0) && (catastrophicTransition[index][0] == 0)) {
						int[] tab = new int[] {1,9};
						catastrophicTransition[index] = tab;
					}
					else if (country.getRessources().getOilWell().getGlobalSize() > 0) {
						percentage = country.getIndustrialFactors().getFuelIndustry().getPercentageOf();
						if (chance == 0) {
							country.getIndustrialFactors().getFuelIndustry().setPercentageOf(percentage-1);
							percentageRespect += 1;
						}
						else if (chance == 6) {
							country.getIndustrialFactors().getFuelIndustry().setPercentageOf(percentage+1);
							percentageRespect -= 1;
						}
						else if (chance == 7) {
							chance = RandomValue.generateNumber(2);
							if (chance == 0) {
								country.getIndustrialFactors().getFuelIndustry().setPercentageOf(percentage-2);
								percentageRespect += 2;
							}
							else {
								country.getIndustrialFactors().getFuelIndustry().setPercentageOf(percentage+2);
								percentageRespect -= 2;
							}
						}
					
						if (country.getIndustrialFactors().getFuelIndustry().getPercentageOf() < 0) {
							percentageRespect += country.getIndustrialFactors().getFuelIndustry().getPercentageOf();
							country.getIndustrialFactors().getFuelIndustry().setPercentageOf(0);
						}
					}
				break;
			
			}
		}
		//Distribute extra percentages
		country = this.industrialRevolution(country, 10, percentageRespect);		//Index is out of bound
			
		country.getIndustrialFactors().setCatastrophicTransition(catastrophicTransition);
		//Check if a industry is in critical situation
		for (int i=0; i<8; i++) {
			if (catastrophicTransition[i][0] == 1) this.transitionProcess(country, i);
		}
		
		
		return country;
	}
	
	public Country transitionProcess(Country country, int index) {
		int[][] catastrophicTransition = country.getIndustrialFactors().getCatastrophicTransition();
		//Industrial revolution manager
		switch (index) {
		
		case 0: if (catastrophicTransition[index][1] == 9) {
					double unemploymentRate = (country.getEconomicalFactors().getPopulationValues().getUnemploymentRate()) +
						((country.getIndustrialFactors().getFoodIndustries().getFishingIndustries())/2);
					
					country.getEconomicalFactors().getPopulationValues().setUnemploymentRate(unemploymentRate);
					catastrophicTransition[index][1]--;
				}
				else if (catastrophicTransition[index][1] == 0) {
					int percentage = country.getIndustrialFactors().getFoodIndustries().getFishingIndustries();
					country.getEconomicalFactors().getPopulationValues().setUnemploymentRate(
							country.getEconomicalFactors().getPopulationValues().getUnemploymentRate()-percentage/2);
					
					country = this.industrialRevolution(country, index, percentage);
					catastrophicTransition[index][0] = 0;
				}
				else {
					catastrophicTransition[index][1]--;
				}
			break;
		case 1: if (catastrophicTransition[index][1] == 9) {
					double unemploymentRate = (country.getEconomicalFactors().getPopulationValues().getUnemploymentRate()) +
							((country.getIndustrialFactors().getFoodIndustries().getAnimalIndustries())/2);
				
					country.getEconomicalFactors().getPopulationValues().setUnemploymentRate(unemploymentRate);
					catastrophicTransition[index][1]--;
				}
				else if (catastrophicTransition[index][1] == 0) {
					int percentage = country.getIndustrialFactors().getFoodIndustries().getAnimalIndustries();
					country = this.industrialRevolution(country, index, percentage);
					catastrophicTransition[index][0] = 0;
				}
				else {
					catastrophicTransition[index][1]--;
				}
			break;
		case 2: if (catastrophicTransition[index][1] == 9) {
					double unemploymentRate = (country.getEconomicalFactors().getPopulationValues().getUnemploymentRate()) +
							((country.getIndustrialFactors().getFoodIndustries().getFarmingIndustries())/2);
				
					country.getEconomicalFactors().getPopulationValues().setUnemploymentRate(unemploymentRate);
					catastrophicTransition[index][1]--;
				}
				else if (catastrophicTransition[index][1] == 0) {
					int percentage = country.getIndustrialFactors().getFoodIndustries().getFarmingIndustries();
					country = this.industrialRevolution(country, index, percentage);
					catastrophicTransition[index][0] = 0;
				}
				else {
					catastrophicTransition[index][1]--;
				}
			break;
		case 3:	if (catastrophicTransition[index][1] == 9) {
					double unemploymentRate = (country.getEconomicalFactors().getPopulationValues().getUnemploymentRate()) +
							((country.getIndustrialFactors().getMiningProcessingIndustries().getSteelIndustries())/2);
				
					country.getEconomicalFactors().getPopulationValues().setUnemploymentRate(unemploymentRate);
					catastrophicTransition[index][1]--;
				}
				else if (catastrophicTransition[index][1] == 0) {
					int percentage = country.getIndustrialFactors().getMiningProcessingIndustries().getSteelIndustries();
					country = this.industrialRevolution(country, index, percentage);
					catastrophicTransition[index][0] = 0;
				}
				else {
					catastrophicTransition[index][1]--;
				}
			break;
		case 4: if (catastrophicTransition[index][1] == 9) {
					double unemploymentRate = (country.getEconomicalFactors().getPopulationValues().getUnemploymentRate()) +
							((country.getIndustrialFactors().getMiningProcessingIndustries().getGoldIndustries())/2);
		
					country.getEconomicalFactors().getPopulationValues().setUnemploymentRate(unemploymentRate);
					catastrophicTransition[index][1]--;
			}
			else if (catastrophicTransition[index][1] == 0) {
				int percentage = country.getIndustrialFactors().getMiningProcessingIndustries().getGoldIndustries();
				country = this.industrialRevolution(country, index, percentage);
				catastrophicTransition[index][0] = 0;
			}
			else {
				catastrophicTransition[index][1]--;
			}
			break;
		case 5: if (catastrophicTransition[index][1] == 9) {
					double unemploymentRate = (country.getEconomicalFactors().getPopulationValues().getUnemploymentRate()) +
							((country.getIndustrialFactors().getMiningProcessingIndustries().getCoalIndustries())/2);
		
					country.getEconomicalFactors().getPopulationValues().setUnemploymentRate(unemploymentRate);
					catastrophicTransition[index][1]--;
				}
				else if (catastrophicTransition[index][1] == 0) {
					int percentage = country.getIndustrialFactors().getMiningProcessingIndustries().getCoalIndustries();
					country = this.industrialRevolution(country, index, percentage);
					catastrophicTransition[index][0] = 0;
				}
				else {
					catastrophicTransition[index][1]--;
				}
			break;
		case 6: if (catastrophicTransition[index][1] == 9) {
					double unemploymentRate = (country.getEconomicalFactors().getPopulationValues().getUnemploymentRate()) +
							((country.getIndustrialFactors().getWoodIndustry().getPercentageOf())/2);
		
					country.getEconomicalFactors().getPopulationValues().setUnemploymentRate(unemploymentRate);
					catastrophicTransition[index][1]--;
				}
				else if (catastrophicTransition[index][1] == 0) {
					int percentage = country.getIndustrialFactors().getWoodIndustry().getPercentageOf();
					country = this.industrialRevolution(country, index, percentage);
					catastrophicTransition[index][0] = 0;
				}
				else {
					catastrophicTransition[index][1]--;
				}
			break;
		case 7: if (catastrophicTransition[index][1] == 9) {
					double unemploymentRate = (country.getEconomicalFactors().getPopulationValues().getUnemploymentRate()) +
							((country.getIndustrialFactors().getFuelIndustry().getPercentageOf())/2);
		
					country.getEconomicalFactors().getPopulationValues().setUnemploymentRate(unemploymentRate);
					catastrophicTransition[index][1]--;
				}
				else if (catastrophicTransition[index][1] == 0) {
					int percentage = country.getIndustrialFactors().getFuelIndustry().getPercentageOf();
					country = this.industrialRevolution(country, index, percentage);
					catastrophicTransition[index][0] = 0;
				}
				else {
					catastrophicTransition[index][1]--;
				}
			break;
		}
		
		country.getIndustrialFactors().setCatastrophicTransition(catastrophicTransition);
		return country;
	}
	
	public Country industrialRevolution(Country country, int index, int percentage) {
		int count = -1;
		int i = 0, add = 0;
		
		if(percentage > 0) add=1;
		else if (percentage < 0) add = -1;
		else return country;
		
		boolean[] criticalRessource = new boolean[] {country.getRessources().getByIndexCriticalRessource(0),
				country.getRessources().getByIndexCriticalRessource(1),
				country.getRessources().getByIndexCriticalRessource(2),
				country.getRessources().getByIndexCriticalRessource(6),
				country.getRessources().getByIndexCriticalRessource(5),
				country.getRessources().getByIndexCriticalRessource(7),
				country.getRessources().getByIndexCriticalRessource(3),
				country.getRessources().getByIndexCriticalRessource(4)
		};
		//Dispatch on others industries the percentage of the critical resource
		while(percentage != 0) {
			i++;
			if (i%8 != 0) count++;
			else count = 0;
			
			if ((count != index) && (criticalRessource[count] == false)) {
				switch (count) {
				case 0: country.getIndustrialFactors().getFoodIndustries().setFishingIndustries(
						country.getIndustrialFactors().getFoodIndustries().getFishingIndustries()+add);
						percentage -= add;
					break;
				case 1:	country.getIndustrialFactors().getFoodIndustries().setAnimalIndustries(
						country.getIndustrialFactors().getFoodIndustries().getAnimalIndustries()+add);
						percentage -= add;
					break;
				case 2: country.getIndustrialFactors().getFoodIndustries().setFarmingIndustries(
						country.getIndustrialFactors().getFoodIndustries().getFarmingIndustries()+add);
						percentage -= add;
					break;
				case 3: country.getIndustrialFactors().getMiningProcessingIndustries().setSteelIndustries(
						country.getIndustrialFactors().getMiningProcessingIndustries().getSteelIndustries()+add);
						percentage -= add;
					break;
				case 4:	country.getIndustrialFactors().getMiningProcessingIndustries().setGoldIndustries(
						country.getIndustrialFactors().getMiningProcessingIndustries().getGoldIndustries()+add);
						percentage -= add;
					break;
				case 5: country.getIndustrialFactors().getMiningProcessingIndustries().setCoalIndustries(
						country.getIndustrialFactors().getMiningProcessingIndustries().getCoalIndustries()+add);
						percentage -= add;
					break;
				case 6: country.getIndustrialFactors().getWoodIndustry().setPercentageOf(
						country.getIndustrialFactors().getWoodIndustry().getPercentageOf()+add);
						percentage -= add;
					break;
				case 7: country.getIndustrialFactors().getFuelIndustry().setPercentageOf(
						country.getIndustrialFactors().getFuelIndustry().getPercentageOf()+add);
						percentage -= add;
					break;
				}
			}
		}
		
		//Set to 0 industry of the critical resource
		double newUnemploymentRate;
		switch (index) {
		case 0: newUnemploymentRate = country.getEconomicalFactors().getPopulationValues().getUnemploymentRate()
				-(country.getIndustrialFactors().getFoodIndustries().getFishingIndustries()/2);
				country.getEconomicalFactors().getPopulationValues().setUnemploymentRate(newUnemploymentRate);
				country.getIndustrialFactors().getFoodIndustries().setFishingIndustries(0);
			break;
		case 1:	newUnemploymentRate = country.getEconomicalFactors().getPopulationValues().getUnemploymentRate()
				-(country.getIndustrialFactors().getFoodIndustries().getAnimalIndustries()/2);
				country.getEconomicalFactors().getPopulationValues().setUnemploymentRate(newUnemploymentRate);
				country.getIndustrialFactors().getFoodIndustries().setAnimalIndustries(0);
			break;
		case 2: newUnemploymentRate = country.getEconomicalFactors().getPopulationValues().getUnemploymentRate()
				-(country.getIndustrialFactors().getFoodIndustries().getFarmingIndustries()/2);
				country.getEconomicalFactors().getPopulationValues().setUnemploymentRate(newUnemploymentRate); 
				country.getIndustrialFactors().getFoodIndustries().setFarmingIndustries(0);
			break;
		case 3: newUnemploymentRate = country.getEconomicalFactors().getPopulationValues().getUnemploymentRate()
				-(country.getIndustrialFactors().getMiningProcessingIndustries().getSteelIndustries()/2);
				country.getEconomicalFactors().getPopulationValues().setUnemploymentRate(newUnemploymentRate);
				country.getIndustrialFactors().getMiningProcessingIndustries().setSteelIndustries(0);
			break;
		case 4:	newUnemploymentRate = country.getEconomicalFactors().getPopulationValues().getUnemploymentRate()
				-(country.getIndustrialFactors().getMiningProcessingIndustries().getGoldIndustries()/2);
				country.getEconomicalFactors().getPopulationValues().setUnemploymentRate(newUnemploymentRate);
				country.getIndustrialFactors().getMiningProcessingIndustries().setGoldIndustries(0);
			break;
		case 5: newUnemploymentRate = country.getEconomicalFactors().getPopulationValues().getUnemploymentRate()
				-(country.getIndustrialFactors().getMiningProcessingIndustries().getCoalIndustries()/2);
				country.getEconomicalFactors().getPopulationValues().setUnemploymentRate(newUnemploymentRate);
				country.getIndustrialFactors().getMiningProcessingIndustries().setCoalIndustries(0);
			break;
		case 6: newUnemploymentRate = country.getEconomicalFactors().getPopulationValues().getUnemploymentRate()
				-(country.getIndustrialFactors().getWoodIndustry().getPercentageOf()/2);
				country.getEconomicalFactors().getPopulationValues().setUnemploymentRate(newUnemploymentRate);
				country.getIndustrialFactors().getWoodIndustry().setPercentageOf(0);
			break;
		case 7: newUnemploymentRate = country.getEconomicalFactors().getPopulationValues().getUnemploymentRate()
				-(country.getIndustrialFactors().getFuelIndustry().getPercentageOf()/2);
				country.getEconomicalFactors().getPopulationValues().setUnemploymentRate(newUnemploymentRate);
				country.getIndustrialFactors().getFuelIndustry().setPercentageOf(0);
			break;
		default : return country;
		}
		
		if (country.getEconomicalFactors().getPopulationValues().getUnemploymentRate() < 0) 
			country.getEconomicalFactors().getPopulationValues().setUnemploymentRate(0);
			
		
		return country;
		
	}

	public Country getCountry() {
		return country;
	}

	
	
}

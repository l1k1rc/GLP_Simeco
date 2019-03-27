package engine;

import industries.*;
import political.PoliticalStatus;

import ressources.Ressources;

public class IndustriesAutomatedAlgorithm {
	private String economicalChoice;
	private Ressources ressourcesAvailable;
	private int[][] ressourcesLimits;
	private PoliticalStatus currentPS;
	private int percentageRemaining = 100;
	
	public IndustriesAutomatedAlgorithm(Ressources ressourcesAvailable, PoliticalStatus currentPS, int[][] ressourcesLimits) {
		this.ressourcesAvailable = ressourcesAvailable;
		this.currentPS = currentPS;
		this.ressourcesLimits = ressourcesLimits;
	}
	
	public IndustrialFactors automatedIndustriesCreation() {
		int value;
		//This algorithm will set the economic profile of countries according to the political status.
		if (currentPS.getRegime().equals("dictatorship")) {
			value = RandomValue.generateNumber(5);
			if (value == 0) economicalChoice = "logic";
			else if (value == 1) economicalChoice = "illogical";
			else economicalChoice = "profit";
		}
		else {
			value = RandomValue.generateNumber(10);
			if (value <= 4) economicalChoice = "logic";
			else if ((value > 4) && (value <=6)) economicalChoice = "illogical";
			else economicalChoice = "profit";

		}
		
		IndustrialFactors industries;
		industries = this.initChoice();  //Call distribution method
		return industries;
	}
	
	private IndustrialFactors initChoice() {
		IndustrialFactors industries;
		if (economicalChoice.equals("logic")) {
			industries = this.logicIndustry();
		}
		else if (economicalChoice.equals("illogical")) {
			industries = this.illogicalIndustry();
		}
		else {
			industries = this.profitIndustry();
		}
		return industries;
	}
	
	public IndustrialFactors logicIndustry() {
		/*
		 * In that class, the most important thing is to all resources on the same scale to compare them effectively.
		 * For exemple, Lakes with a limit number of 50 can't match with gold mines limited to 20, it does not make sens...
		 */
		int[] percentageTable = new int[8];
		double[] determinationTable = new double[8];
		
		//Step one : cumulate resources limits to determine the larger possible value (in terms of size)
		int[] cumulateRessourcesLimits = new int[] {0,0,0,0,0,0,0,0};
		int i,j;
		for(i=0; i<8; i++) {
			for (j=0; j<ressourcesLimits[i][0];j++) {
				cumulateRessourcesLimits[i] += ressourcesLimits[i][2];
			}
			
		}
		
		//Step two : determinate bigger value to equalize values
		int biggestValue = 0;
		for(i=0; i<8; i++) {
			if (biggestValue < cumulateRessourcesLimits[i]) biggestValue = cumulateRessourcesLimits[i];
		}
		
		//Step three : calculate multiplicator for each value to equalize them (indexed on the largest value)
		double[] coefMult = new double[8];
		for(i=0; i<8; i++) {
			coefMult[i] = (biggestValue/cumulateRessourcesLimits[i]);
		}
		
		//Step four : add up (additionner) all resources by type
		float[] cumulateValuesTable = new float[8];
		for (i=0; i<ressourcesAvailable.getLakes().getNumberOf(); i++) {
			cumulateValuesTable[0] += ressourcesAvailable.getLakes().lakeByIndex(i).getContentSize();	
		}
		for (i=0; i<ressourcesAvailable.getSuitablesLands().getNumberOf(); i++) {
			cumulateValuesTable[1] += ressourcesAvailable.getSuitablesLands().suitableLandByIndex(i).getContentSize();	
		}
		for (i=0; i<ressourcesAvailable.getFields().getNumberOf(); i++) {
			cumulateValuesTable[2] += ressourcesAvailable.getFields().fieldByIndex(i).getContentSize();
		}
		for (i=0; i<ressourcesAvailable.getForests().getNumberOf(); i++) {
			cumulateValuesTable[3] += ressourcesAvailable.getForests().forestByIndex(i).getContentSize();
		}
		for (i=0; i<ressourcesAvailable.getOilWell().getNumberOf(); i++) {
			cumulateValuesTable[4] += ressourcesAvailable.getOilWell().oilWellByIndex(i).getContentSize();
		}
		for (i=0; i<ressourcesAvailable.getGoldMines().getNumberOf(); i++) {
			cumulateValuesTable[5] += ressourcesAvailable.getGoldMines().goldMineByIndex(i).getContentSize();
		}
		for (i=0; i<ressourcesAvailable.getIronMines().getNumberOf(); i++) {
			cumulateValuesTable[6] += ressourcesAvailable.getIronMines().ironMineByIndex(i).getContentSize();	
		}
		for (i=0; i<ressourcesAvailable.getCoalMines().getNumberOf(); i++) {
			cumulateValuesTable[7] += ressourcesAvailable.getCoalMines().coalMineByIndex(i).getContentSize();	
		}
		
		//Step five : equalize values on the same scale (indexed on the largest value of country concerned)
		for (i=0; i<8; i++) {
			determinationTable[i] = cumulateValuesTable[i]*coefMult[i];
		}
		
		
		//Step six : set percentages randomly depending to abundance of the resource in decreasing direction
		//(Always stored in the order of resources set in "DataUML.dia")
		int indexRessource = 0;
		int percentage = 0;
		for (i=0; i<8; i++) {
			double value = 1000000;
			for(j=0; j<8; j++) {
				if (value > determinationTable[j]) {
					value = determinationTable[j];
					indexRessource = j;
				}
			}
			determinationTable[indexRessource] = 2000000;
			switch (i) {
				case 0: percentage = RandomValue.generateBoundedNumber(0,3);
					break;
				case 1:	percentage = RandomValue.generateBoundedNumber(3,6);
					break;
				case 2:	percentage = RandomValue.generateBoundedNumber(6,8);
					break;
				case 3: percentage = RandomValue.generateBoundedNumber(8,11);
					break;
				case 4: percentage = RandomValue.generateBoundedNumber(11,14);
					break;
				case 5: percentage = RandomValue.generateBoundedNumber(14,19);
					break;
				case 6: percentage = RandomValue.generateBoundedNumber(19,25);
					break;
				case 7: percentage = percentageRemaining;
					break;
				default:
			}
			percentageTable[indexRessource] = percentage;
			percentageRemaining -= percentage;
			
		}
		
		//Generate IndustrialFactors class
		FoodIndustries foodIndustries = new FoodIndustries(percentageTable[0],percentageTable[1],percentageTable[2]);
		MiningProcessingIndustries mpi = new MiningProcessingIndustries(percentageTable[5],percentageTable[6],percentageTable[7]);
		WoodIndustry woodIndustry = new WoodIndustry(percentageTable[3]);
		FuelIndustry fuelIndustry = new FuelIndustry(percentageTable[4]);
		
		IndustrialFactors industries = new IndustrialFactors(economicalChoice, foodIndustries, mpi, woodIndustry, fuelIndustry);
		return industries;
		
	}
	
	
	public IndustrialFactors illogicalIndustry() {
		int[] randomTable = new int[]{0,1,2,3,4,5,6,7};
		int tmp, rand,i;
		//Step one : Mix the table by exchanging tab[0] with tab[random number{0-7}] 25 times (25 times loop gave a good random result)
		for (i=0; i<25; i++) {
			rand = RandomValue.generateNumber(8);
			tmp = randomTable[0];
			randomTable[0] = randomTable[rand];
			randomTable[rand] = tmp;
		}
		
		//Step two : Set all percentage, growing in order of the percentageTable
		int[] percentageTable = new int[8];
		for (i=0; i<8; i++) {
			switch (i) {
				case 0: percentageTable[randomTable[i]] = RandomValue.generateBoundedNumber(1,5);
						percentageRemaining -= percentageTable[randomTable[i]];
					break;
				case 1:	percentageTable[randomTable[i]] = RandomValue.generateBoundedNumber(1,5);
						percentageRemaining -= percentageTable[randomTable[i]];
					break;
				case 2:	percentageTable[randomTable[i]] = RandomValue.generateBoundedNumber(1,5);
						percentageRemaining -= percentageTable[randomTable[i]];
					break;
				case 3: percentageTable[randomTable[i]] = RandomValue.generateBoundedNumber(1,5);
						percentageRemaining -= percentageTable[randomTable[i]];
					break;
				case 4: percentageTable[randomTable[i]] = RandomValue.generateBoundedNumber(1,5);
						percentageRemaining -= percentageTable[randomTable[i]];
					break;
				case 5: percentageTable[randomTable[i]] = RandomValue.generateBoundedNumber(5,10);
						percentageRemaining -= percentageTable[randomTable[i]];
					break;
				case 6: percentageTable[randomTable[i]] = RandomValue.generateBoundedNumber(30,35);
						percentageRemaining -= percentageTable[randomTable[i]];
					break;
				case 7: percentageTable[randomTable[i]] = percentageRemaining;
						percentageRemaining -= percentageTable[randomTable[i]];
					break;
				default:
			}
		}
		
		//Generate IndustrialFactors class
		FoodIndustries foodIndustries = new FoodIndustries(percentageTable[0],percentageTable[1],percentageTable[2]);
		MiningProcessingIndustries mpi = new MiningProcessingIndustries(percentageTable[5],percentageTable[6],percentageTable[7]);
		WoodIndustry woodIndustry = new WoodIndustry(percentageTable[3]);
		FuelIndustry fuelIndustry = new FuelIndustry(percentageTable[4]);
		
		IndustrialFactors industries = new IndustrialFactors(economicalChoice, foodIndustries, mpi, woodIndustry, fuelIndustry);
		return industries;
	}
	
	public IndustrialFactors profitIndustry() {
		int[] percentageTable = new int[8];
		int i;
		//Step one : generate a value between 4 and 7 (Rewind : 4 to 7 in the percentageTable correspond to Fuel/Gold/Iron/Coal ressources),
		//this random number will define which resource will be exploited to the height of 5%, others will set to 30%
		int rand = RandomValue.generateBoundedNumber(4, 8);
		for(i=4; i<8; i++) {
			if (i == rand) {
				percentageTable[i] = 5;
				percentageRemaining -= 5;
			}
			else {
				percentageTable[i] = 30;
				percentageRemaining -= 30;
			}
		}
		
		//Step two : This loop will set percentage between 0 and 1 to the others resources (percentage remaining for the last)
		for(i=0; i<4; i++) {
			if (i==3) {
				percentageTable[i] = percentageRemaining;
			}
			else {
				rand = RandomValue.generateNumber(2);
				percentageTable[i] = rand;
			}
			percentageRemaining -= rand;
		}
		
		
		//Generate IndustrialFactors class
		FoodIndustries foodIndustries = new FoodIndustries(percentageTable[0],percentageTable[1],percentageTable[2]);
		MiningProcessingIndustries mpi = new MiningProcessingIndustries(percentageTable[5],percentageTable[6],percentageTable[7]);
		WoodIndustry woodIndustry = new WoodIndustry(percentageTable[3]);
		FuelIndustry fuelIndustry = new FuelIndustry(percentageTable[4]);
		
		IndustrialFactors industries = new IndustrialFactors(economicalChoice, foodIndustries, mpi, woodIndustry, fuelIndustry);
		return industries;
	}

	public String getEconomicalChoice() {
		return economicalChoice;
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

	public int getPercentageRemaining() {
		return percentageRemaining;
	}
	
	

}

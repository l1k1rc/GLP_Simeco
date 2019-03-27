package engine;

import economy.EconomicalFactors;
import economy.GDPValues;
import economy.HIDValues;
import economy.PopulationValues;
import industries.IndustrialFactors;
//All is in million $ 
public class EconomicalFactorsAutomatedAlgorithm {
	private int[][] sizeValues;
	private IndustrialFactors industrialFactors;

	public EconomicalFactorsAutomatedAlgorithm(int[][] sizeValues, IndustrialFactors industrialFactors) {
		this.sizeValues = sizeValues;
		this.industrialFactors = industrialFactors;
	}
	
	public EconomicalFactors automatedEconomicalFactorsCreation() {
		GDPValues gdpValues = automatedGDPGenerator();
		HIDValues hidValues = automatedHIDGenerator(gdpValues);
		double populationGrowth = populationGrowthGenerator(gdpValues);
		int gini = giniGenerator();
		double reshercheSpending = reshercheSpendingGenerator();
		double middleAge = middleAgeGenerator(hidValues);
		double unemploymentRate = unemploymentRateGenerator();
		
		PopulationValues pv = new PopulationValues(populationGrowth, gini, reshercheSpending, middleAge, unemploymentRate);
		EconomicalFactors economicalFactors = new EconomicalFactors(hidValues, gdpValues, pv);
		return economicalFactors;
		
		
	}
	
	public GDPValues automatedGDPGenerator() {
		GDPValues gdp;
		int consuption;
		int investment;
		int governmentSpending;
		if (industrialFactors.getStartingType().equals("logic")) {
			consuption = RandomValue.generateBoundedNumber(300000, 1000000);
			investment = RandomValue.generateBoundedNumber(300000, 1000000);
			governmentSpending = RandomValue.generateBoundedNumber(300000, 1000000);
		}
		else if (industrialFactors.getStartingType().equals("profit")) {
			consuption = RandomValue.generateBoundedNumber(2000000, 5000000);
			investment = RandomValue.generateBoundedNumber(2000000, 5000000);
			governmentSpending = RandomValue.generateBoundedNumber(2000000, 5000000);
			
		}
		else {
			consuption = RandomValue.generateBoundedNumber(50000, 3000000);
			investment = RandomValue.generateBoundedNumber(50000, 3000000);
			governmentSpending = RandomValue.generateBoundedNumber(50000, 3000000);
		}
		
		gdp = new GDPValues(consuption, investment, governmentSpending);
		gdp.updateGDP();
		return gdp;
	}
	
	public HIDValues automatedHIDGenerator(GDPValues gdp) {
		HIDValues hid;
		double averageDurationOfSchooling;
		double expectingDurationOfSchooling;
		
		if (gdp.getGdp() >= 6000000) {
			averageDurationOfSchooling = RandomValue.generateBoundedPercentageValue(11, 13);
			expectingDurationOfSchooling = RandomValue.generateBoundedPercentageValue(15, 18);
		}
		if ((gdp.getGdp() >= 1500000) && (gdp.getGdp() < 6000000)) {
			averageDurationOfSchooling = RandomValue.generateBoundedPercentageValue(6, 11);
			expectingDurationOfSchooling = RandomValue.generateBoundedPercentageValue(12, 15);
		}
		else {
			averageDurationOfSchooling = RandomValue.generateBoundedPercentageValue(1, 6);
			expectingDurationOfSchooling = RandomValue.generateBoundedPercentageValue(7, 12);
		}
		
		int income = gdp.getGdp();
		int minimalPop = income/100000;		//100000 = maximal per capita income
		int population = RandomValue.generateBoundedNumber(minimalPop, 300);
		
		double lifeExpectancy = RandomValue.generateBoundedPercentageValue(50, 84);
		
		hid = new HIDValues(income, population, averageDurationOfSchooling, expectingDurationOfSchooling, lifeExpectancy);
		return hid;
	}
	
	
	
	public double populationGrowthGenerator(GDPValues gdp) {
		double populationGrowth;
		if (gdp.getGdp() <= 300000) {					//Index pour déterminer si la génération sera aléatoire ou orientée vers une forte croissance de la population
			int index = RandomValue.generateNumber(5);	//4/5 chances que la croissance de la population soit plus forte dans un pays pauvre
			if (index == 0) populationGrowth = RandomValue.generateBoundedPercentageValue(-1, 5);
			else populationGrowth = RandomValue.generateBoundedPercentageValue(2, 5);
		}
		else populationGrowth = RandomValue.generateBoundedPercentageValue(-1, 5);
		
		return populationGrowth;
	}
	
	public int giniGenerator() {
		int gini;
		
		if (industrialFactors.getStartingType().equals("logic")) {
			gini = RandomValue.generateBoundedNumber(20, 50);
		}
		else if (industrialFactors.getStartingType().equals("profit")) {
			gini = RandomValue.generateBoundedNumber(40, 80);
		}
		else {
			gini = RandomValue.generateBoundedNumber(20, 80);
		}
		
		return gini;
	}
	
	public double reshercheSpendingGenerator() {
		double reshercheSpending = RandomValue.generatePercentageValue(sizeValues[4][1]);
		return reshercheSpending;
	}
	
	public double middleAgeGenerator(HIDValues hid) {
		double middleAge = RandomValue.generateBoundedPercentageValue((hid.getLifeExpectancy()/2)-3, (hid.getLifeExpectancy()/2)+3);
		return middleAge;
	}
	
	public double unemploymentRateGenerator() {
		double unemploymentRate = RandomValue.generateBoundedPercentageValue(sizeValues[6][0], sizeValues[6][1]);
		return unemploymentRate;
	}
	

	public int[][] getSizeValues() {
		return sizeValues;
	}

	public IndustrialFactors getIndustrialFactors() {
		return industrialFactors;
	}
	
	
}

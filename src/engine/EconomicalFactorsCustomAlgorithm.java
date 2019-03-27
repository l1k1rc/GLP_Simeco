package engine;

import java.util.ArrayList;

import economy.EconomicalFactors;
import economy.GDPValues;
import economy.HIDValues;
import economy.PopulationValues;
import industries.IndustrialFactors;


public class EconomicalFactorsCustomAlgorithm {
	private ArrayList<Integer> alIsItCustom;
	private int[][] sizeValues;
	private IndustrialFactors industrialFactors;

	public EconomicalFactorsCustomAlgorithm(int[][] sizeValues, IndustrialFactors industrialFactors, ArrayList<Integer> alIsItCustom) {
		this.sizeValues = sizeValues;
		this.industrialFactors = industrialFactors;
		this.alIsItCustom = alIsItCustom;
	}
	
	public EconomicalFactors customEconomicalFactorsCreation() throws IndexOutOfBoundsException {
		int counter = 0;
		GDPValues gdpValues = null;
		HIDValues hidValues = null;
		double populationGrowth = 0;
		int gini = 0;
		double reshercheSpending = 0;
		double middleAge = 0;
		double unemploymentRate = 0;
		
		for (Integer index : alIsItCustom) {				//If index = 0 : Auto | If index = [-6,-7,-8,-9,-10] : Bounded | If index = R+* or -1 : Custom
			counter++;
			if (index == 0) {
				EconomicalFactorsAutomatedAlgorithm autoGen = new EconomicalFactorsAutomatedAlgorithm(sizeValues, industrialFactors);
			
				switch (counter) {
					case 1: 	gdpValues = autoGen.automatedGDPGenerator();
								break;
								
					case 2:		hidValues = autoGen.automatedHIDGenerator(gdpValues);
								break;
								
					case 3: 	populationGrowth = autoGen.populationGrowthGenerator(gdpValues);
								break;
								
					case 4: 	gini = autoGen.giniGenerator();
								break;
								
					case 5: 	reshercheSpending = autoGen.reshercheSpendingGenerator();
								break;
								
					case 6: 	middleAge = autoGen.middleAgeGenerator(hidValues);
								break;
								
					case 7: 	unemploymentRate = autoGen.unemploymentRateGenerator();
								break;
								
					default: 	throw new IndexOutOfBoundsException("En dehors de l'ArrayList de génération automatique des facteurs économiques");
				}
				
			}
			else if ((index >= -10) && (index <= -6)) {
				EconomicalFactorsBoundedAlgorithm boundedGen = new EconomicalFactorsBoundedAlgorithm(sizeValues);
				
				switch (counter) {
					case 1: 	gdpValues = boundedGen.boundedGDPGenerator(index);
								break;
							
					case 2:		hidValues = boundedGen.boundedHIDGenerator(index, gdpValues);
								break;
							
					case 3: 	populationGrowth = boundedGen.boundedPopulationGrowthGenerator(index);
								break;
							
					case 4: 	gini = boundedGen.boundedGiniGenerator(index);
								break;
							
					case 5: 	reshercheSpending = boundedGen.boundedReshercheSpendingGenerator(index);
								break;
							
					case 6: 	middleAge = boundedGen.boundedMiddleAgeGenerator(index);
								break;
							
					case 7:		unemploymentRate = boundedGen.boundedUnemploymentRateGenerator(index);
								break;
							
					default: 	throw new IndexOutOfBoundsException("En dehors de l'ArrayList de génération bornée des facteurs économiques");
				}
				
			}
			else {
				switch (counter) {
					case 1: 	gdpValues = this.customGDPGenerator(index);
								break;
							
					case 2:		hidValues = this.customHIDGenerator(index, gdpValues);
								break;
							
					case 3: 	populationGrowth = this.customPopulationGrowthGenerator(index);
								break;
							
					case 4: 	gini = this.customGiniGenerator(index);
								break;
							
					case 5: 	reshercheSpending = this.customReshercheSpendingGenerator(index);
								break;
							
					case 6: 	middleAge = this.customMiddleAgeGenerator(index);
								break;
							
					case 7: 	unemploymentRate = this.customUnemploymentRateGenerator(index);
								break;
							
					default: 	throw new IndexOutOfBoundsException("En dehors de l'ArrayList de génération custom des facteurs économiques");
					}
				}
		}
		PopulationValues pv = new PopulationValues(populationGrowth, gini, reshercheSpending, middleAge, unemploymentRate);
		EconomicalFactors economicalFactors = new EconomicalFactors(hidValues, gdpValues, pv);
		return economicalFactors;
	}

	
	public GDPValues customGDPGenerator(int index) {
		int gdpRequired = index;
		//We want to generate gdp in the opposite way
		GDPValues gdpGenerated = calc.ReverseGDPcalculator.reverseGDPCalc(gdpRequired);
		return gdpGenerated;
	}
	
	public HIDValues customHIDGenerator(int index, GDPValues gdp) {
		double hidRequired = index*Math.pow(10, -3);
		
		HIDValues hidGenerated = calc.ReverseHIDcalculator.reverseHIDCalc(hidRequired, gdp.getGdp());
		return hidGenerated;
	}
	
	public double customPopulationGrowthGenerator(int index) {
		double populationGrowth = index;
		return populationGrowth;	
	}
	
	public int customGiniGenerator(int index) {
		int gini = index;
		return gini;
	}
	
	public double customReshercheSpendingGenerator(int index) {
		double reshercheSpending = index;
		return reshercheSpending;
	}
	
	public double customMiddleAgeGenerator(int index) {
		double middleAge = index;
		return middleAge;
	}
	
	public double customUnemploymentRateGenerator(int index) {
		double unemploymentRate = index;
		return unemploymentRate;
	}

	public ArrayList<Integer> getAlIsItCustom() {
		return alIsItCustom;
	}

	public int[][] getSizeValues() {
		return sizeValues;
	}

	public IndustrialFactors getIndustrialFactors() {
		return industrialFactors;
	}
	
}

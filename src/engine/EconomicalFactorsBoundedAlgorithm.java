package engine;

import calc.BoundedSizesCalculator;
import economy.GDPValues;
import economy.HIDValues;

public class EconomicalFactorsBoundedAlgorithm {
	private int[][] sizeValues;

	public EconomicalFactorsBoundedAlgorithm(int[][] sizeValues) {
		this.sizeValues = sizeValues;
	}
	
	public GDPValues boundedGDPGenerator(int index)  throws IndexOutOfBoundsException{
		int[] sizeMinMax = BoundedSizesCalculator.bsCalcWithMin(index, sizeValues[0]);
		
		int gdpRequired = RandomValue.generateBoundedNumber(sizeMinMax[0], sizeMinMax[1]);
		//We want to generate gdp in the opposite way	
		GDPValues gdpGenerated = calc.ReverseGDPcalculator.reverseGDPCalc(gdpRequired);
		return gdpGenerated;
	}
	
	public HIDValues boundedHIDGenerator(int index, GDPValues gdp) throws IndexOutOfBoundsException{
		int[] sizeMinMax = BoundedSizesCalculator.bsCalcWithMin(index, sizeValues[1]);
		
		double hidRequired = RandomValue.generateBoundedNumber(sizeMinMax[0], sizeMinMax[1]);
		hidRequired *= Math.pow(10, -3);
		HIDValues hidGenerated = calc.ReverseHIDcalculator.reverseHIDCalc(hidRequired, gdp.getGdp());
		return hidGenerated;
	}
	
	public double boundedPopulationGrowthGenerator(int index) throws IndexOutOfBoundsException{
		int[] sizeMinMax = BoundedSizesCalculator.bsCalcWithMin(index, sizeValues[2]);
		
		double populationGrowth = RandomValue.generateBoundedNumber(sizeMinMax[0], sizeMinMax[1]);
		return populationGrowth;	
	}
	
	public int boundedGiniGenerator(int index) throws IndexOutOfBoundsException{
		int[] sizeMinMax = BoundedSizesCalculator.bsCalcWithMin(index, sizeValues[3]);
		
		int gini = RandomValue.generateBoundedNumber(sizeMinMax[0], sizeMinMax[1]);
		return gini;
	}
	
	public double boundedReshercheSpendingGenerator(int index) throws IndexOutOfBoundsException{
		int[] sizeMinMax = BoundedSizesCalculator.bsCalcWithMin(index, sizeValues[4]);
		
		double reshercheSpending = RandomValue.generateBoundedNumber(sizeMinMax[0], sizeMinMax[1]);
		return reshercheSpending;
	}
	
	public double boundedMiddleAgeGenerator(int index) throws IndexOutOfBoundsException{
		int[] sizeMinMax = BoundedSizesCalculator.bsCalcWithMin(index, sizeValues[5]);
		
		double middleAge = RandomValue.generateBoundedNumber(sizeMinMax[0], sizeMinMax[1]);
		return middleAge;
	}
	
	public double boundedUnemploymentRateGenerator(int index) throws IndexOutOfBoundsException{
		int[] sizeMinMax = BoundedSizesCalculator.bsCalcWithMin(index, sizeValues[6]);
		
		double unemploymentRate = RandomValue.generateBoundedNumber(sizeMinMax[0], sizeMinMax[1]);
		return unemploymentRate;
	}

	public int[][] getSizeValues() {
		return sizeValues;
	}
}

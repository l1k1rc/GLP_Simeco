package industries;

import calc.PercentageCalculator;

public class MiningProcessingIndustries implements IndustriesInterface{
	private int percentageGlobalOf;
	private SteelIndustry steelIndustries;
	private GoldIndustry goldIndustries;
	private CoalIndustry coalIndustries;
	
	public MiningProcessingIndustries() {
		this(0,0,0);
	}
	
	public MiningProcessingIndustries(int goldProcessPercentage,int steelProcessPercentage, int coalProcessPercentage) {
		steelIndustries = new SteelIndustry(steelProcessPercentage);
		goldIndustries = new GoldIndustry(goldProcessPercentage);
		coalIndustries = new CoalIndustry(coalProcessPercentage);
		this.updatePercentageGlobalOf();
	}
	
	public void updatePercentageGlobalOf() {
		percentageGlobalOf = PercentageCalculator.percentageCalc(getSteelIndustries(),getGoldIndustries(),getCoalIndustries());

	}
	
	public float getPercentageGlobalOf() {
		return percentageGlobalOf;
	}
	

	public int getSteelIndustries() {
		return steelIndustries.getPercentageOf();
	}

	public void setSteelIndustries(int steelProcessPercentage) {
		steelIndustries.setPercentageOf(steelProcessPercentage);
		this.updatePercentageGlobalOf();
	}

	public int getGoldIndustries() {
		return goldIndustries.getPercentageOf();
	}

	public void setGoldIndustries(int goldProcessPercentage) {
		goldIndustries.setPercentageOf(goldProcessPercentage);
		this.updatePercentageGlobalOf();
	}

	public int getCoalIndustries() {
		return coalIndustries.getPercentageOf();
	}

	public void setCoalIndustries(int coalProcessPercentage) {
		coalIndustries.setPercentageOf(coalProcessPercentage);
		this.updatePercentageGlobalOf();
	}
}

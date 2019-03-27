package industries;
import calc.PercentageCalculator;
public class FoodIndustries implements IndustriesInterface{
	private int percentageGlobalOf;
	private FishingIndustry fishingIndustries;
	private AnimalIndustry animalIndustries;
	private FarmingIndustry farmingIndustries;
	
	public FoodIndustries() {
		this(0,0,0);
	}
	
	public FoodIndustries(int fishingPercentage, int animalPercentage, int farmingPercentage) {
		fishingIndustries = new FishingIndustry(fishingPercentage);
		animalIndustries = new AnimalIndustry(animalPercentage);
		farmingIndustries = new FarmingIndustry(farmingPercentage);
		this.updatePercentageGlobalOf();
	}
	
	public void updatePercentageGlobalOf() {
		percentageGlobalOf = PercentageCalculator.percentageCalc(getFishingIndustries(),getAnimalIndustries(),getFarmingIndustries());
	}

	public float getPercentageGlobalOf() {
		return percentageGlobalOf;
	}

	public int getFishingIndustries() {
		return fishingIndustries.getPercentageOf();
	}

	public void setFishingIndustries(int fishingPercentage) {
		fishingIndustries.setPercentageOf(fishingPercentage);
		this.updatePercentageGlobalOf();
	}

	public int getAnimalIndustries() {
		return animalIndustries.getPercentageOf();
	}

	public void setAnimalIndustries(int animalPercentage) {
		animalIndustries.setPercentageOf(animalPercentage);
		this.updatePercentageGlobalOf();
	}

	public int getFarmingIndustries() {
		return farmingIndustries.getPercentageOf();
	}

	public void setFarmingIndustries(int farmingPercentage) {
		farmingIndustries.setPercentageOf(farmingPercentage);
		this.updatePercentageGlobalOf();
	}
}

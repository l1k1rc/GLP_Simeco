package industries;

public class IndustrialFactors {
	static int percentageIndex = 100;
	private String startingType; 							 //logic/illogical/profit
	private FoodIndustries foodIndustries;
	private MiningProcessingIndustries miningProcessingIndustries;
	private WoodIndustry woodIndustry;
	private FuelIndustry fuelIndustry;
	private int[][] catastrophicTransition;
	
	public IndustrialFactors(String type, FoodIndustries foodIndustries, MiningProcessingIndustries miningProcessingIndustries, WoodIndustry woodIndustry, FuelIndustry fuelIndustry) {
		startingType = type;
		this.foodIndustries = foodIndustries;
		this.miningProcessingIndustries = miningProcessingIndustries;
		this.woodIndustry = woodIndustry;
		this.fuelIndustry = fuelIndustry;
		
		catastrophicTransition = new int[8][2]; // 8 : Fishing, Animals, Farming, Steel, Gold, Coal, Wood, Fuel
		int[] set = new int[] {0,0};  			//{0 if catastrophicTransition is false, years remaining before industrial revolution}
		for (int i=0; i<8; i++) {
			catastrophicTransition[i] = set;
		}
	}

	public static int getPercentageIndex() {
		return percentageIndex;
	}
	

	public String getStartingType() {
		return startingType;
	}

	public void setStartingType(String startingType) {
		this.startingType = startingType;
	}

	public FoodIndustries getFoodIndustries() {
		return foodIndustries;
	}

	public MiningProcessingIndustries getMiningProcessingIndustries() {
		return miningProcessingIndustries;
	}

	public WoodIndustry getWoodIndustry() {
		return woodIndustry;
	}

	public FuelIndustry getFuelIndustry() {
		return fuelIndustry;
	}

	public int[][] getCatastrophicTransition() {
		return catastrophicTransition;
	}

	public void setCatastrophicTransition(int[][] catastrophicTransition) {
		this.catastrophicTransition = catastrophicTransition;
	}
	
	
}

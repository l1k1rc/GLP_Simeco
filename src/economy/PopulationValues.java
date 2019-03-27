package economy;

public class PopulationValues {
	private double populationGrowth;
	private double gini;
	private double reschercheSpending;
	private double middleAge;
	private double unemploymentRate;
	
	public PopulationValues(double populationGrowth, double gini, double reschercheSpending, double middleAge,
			double unemploymentRate) {
		this.populationGrowth = populationGrowth;
		this.gini = gini;
		this.reschercheSpending = reschercheSpending;
		this.middleAge = middleAge;
		this.unemploymentRate = unemploymentRate;
	}
	public double getPopulationGrowth() {
		return populationGrowth;
	}
	public void setPopulationGrowth(double populationGrowth) {
		this.populationGrowth = populationGrowth;
	}
	public double getGini() {
		return gini;
	}
	public void setGini(double gini) {
		this.gini = gini;
	}
	public double getReschercheSpending() {
		return reschercheSpending;
	}
	public void setReschercheSpending(double reschercheSpending) {
		this.reschercheSpending = reschercheSpending;
	}
	public double getMiddleAge() {
		return middleAge;
	}
	public void setMiddleAge(double middleAge) {
		this.middleAge = middleAge;
	}
	public double getUnemploymentRate() {
		return unemploymentRate;
	}
	public void setUnemploymentRate(double unemploymentRate) {
		this.unemploymentRate = unemploymentRate;
	}
}

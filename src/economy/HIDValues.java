package economy;
import calc.HIDcalculator;
//IDH
public class HIDValues {
	private double hid;
	private PerCapitaIncome perCapitaIncome;
	private Education education;
	private double lifeExpectancy;
	
	public HIDValues(int income, int population, double averageDurationOfSchooling, double expectationSchoolingDuration, double lifeExpectancy) {
		perCapitaIncome = new PerCapitaIncome(income, population);
		education = new Education(averageDurationOfSchooling, expectationSchoolingDuration);
		this.lifeExpectancy = lifeExpectancy;
		this.updateHID();
	}
	
	public void updateHID() {
		hid = HIDcalculator.hidCalc(perCapitaIncome, education, lifeExpectancy);
	}
	
	public double getHid() {
		return hid;
	}

	public PerCapitaIncome getPerCapitaIncome() {
		return perCapitaIncome;
	}

	public Education getEducation() {
		return education;
	}

	public double getLifeExpectancy() {
		return lifeExpectancy;
	}
	

	public void setPerCapitaIncome(PerCapitaIncome perCapitaIncome) {
		this.perCapitaIncome = perCapitaIncome;
		this.updateHID();
	}

	public void setEducation(Education education) {
		this.education = education;
		this.updateHID();
	}

	public void setLifeExpectancy(double lifeExpectancy) {
		this.lifeExpectancy = lifeExpectancy;
		this.updateHID();
	}

	
}

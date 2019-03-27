package economy;
import calc.PCIcalculator;
public class PerCapitaIncome {
	private double perCapitaIncome;
	private int income;
	private int population;
	
	public PerCapitaIncome(int income, int population) {
		this.income = income;
		this.population = population;
		this.updatePCI();
	}
	public void updatePCI() {
		this.perCapitaIncome = PCIcalculator.pciCalc(income, population);
	}
	public double getPerCapitaIncome() {
		return perCapitaIncome;
	}
	
	public int getIncome() {
		return income;
	}
	
	public void setIncome(int income) {
		this.income = income;
		this.updatePCI();
	}
	
	public int getPopulation() {
		return population;
	}
	
	public void setPopulation(int export) {
		this.population = export;
		this.updatePCI();
	}
}

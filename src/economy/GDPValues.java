package economy;
import calc.GDPcalculator;

//PIB
public class GDPValues {
	private int gdp;
	private int consuption;
	private int investment;
	private int governementSpending;
	private int exports;
	private int imports;
	
	public GDPValues(int consuption, int investment, int governementSpending) {
		this(consuption, investment, governementSpending, 0, 0);
	}
	
	public GDPValues(int consuption, int investment, int governementSpending, int exports, int imports) {
		this.consuption = consuption;
		this.investment = investment;
		this.governementSpending = governementSpending;
		this.exports = exports;
		this.imports = imports;
		this.updateGDP();
	}
	
	public void updateGDP() {
		gdp = GDPcalculator.gdpCalc(consuption, investment, governementSpending, exports, imports);
		
	}

	public int getGdp() {
		return gdp;
	}
	
	public int getConsuption() {
		return consuption;
	}


	public void setConsuption(int consuption) {
		this.consuption = consuption;
		this.updateGDP();
	}


	public int getInvestment() {
		return investment;
	}


	public void setInvestment(int investment) {
		this.investment = investment;
		this.updateGDP();
	}


	public int getGovernementSpending() {
		return governementSpending;
	}


	public void setGovernementSpending(int governementSpending) {
		this.governementSpending = governementSpending;
		this.updateGDP();
	}


	public int getExports() {
		return exports;
	}


	public void setExports(int exports) {
		this.exports = exports;
		this.updateGDP();
	}


	public int getImports() {
		return imports;
	}


	public void setImports(int imports) {
		this.imports = imports;
		this.updateGDP();
	}
}

package economy;

public class EconomicalFactors {
	private HIDValues hidValues;
	private GDPValues gdpValues;
	private PopulationValues populationValues;
	private TradeAgreements tradeAgreements;
	public EconomicalFactors(HIDValues hidValues, GDPValues gdpValues, PopulationValues populationValues) {
		this.hidValues = hidValues;
		this.gdpValues = gdpValues;
		this.populationValues = populationValues;
		tradeAgreements = new TradeAgreements();
	}
	public HIDValues getHidValues() {
		return hidValues;
	}
	public GDPValues getGdpValues() {
		return gdpValues;
	}
	public PopulationValues getPopulationValues() {
		return populationValues;
	}
	public TradeAgreements getTradeAgreements() {
		return tradeAgreements;
	}
	
	
	
	
}

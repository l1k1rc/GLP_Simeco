package economy;
import calc.NumberGlobalOfCalculator;

public class TradeAgreements {
	private int numberGlobalOf;
	private MilitaryAgreements militaryAgr;
	private CommercialAgreements commAgr;
	private IndustrialAgreements induAgr;

	public TradeAgreements() {
		numberGlobalOf = 0;
		militaryAgr = new MilitaryAgreements();
		commAgr = new CommercialAgreements();
		induAgr = new IndustrialAgreements();
	}
	
	public void updateNumberGlobalOf() {
		numberGlobalOf = NumberGlobalOfCalculator.numberCalc(militaryAgr.getNumberOf(), commAgr.getNumberOf(), induAgr.getNumberOf());
	}

	public int getNumberGlobalOf() {
		return numberGlobalOf;
	}

	public MilitaryAgreements getMilitaryAgr() {
		return militaryAgr;
	}

	public void addMilitaryAgr(String country) {
		militaryAgr.addPartner(country);
		updateNumberGlobalOf();
	}
	
	public void delMilitaryAgr(String country) {
		militaryAgr.delPartner(country);
		updateNumberGlobalOf();
	}

	public CommercialAgreements getCommAgr() {
		return commAgr;
	}

	public void addCommAgr(String country) {
		commAgr.addPartner(country);
		updateNumberGlobalOf();
	}
	
	public void delCommAgr(String country) {
		commAgr.delPartner(country);
		updateNumberGlobalOf();
	}

	public IndustrialAgreements getInduAgr() {
		return induAgr;
	}

	public void addInduAgr(String country) {
		induAgr.addPartner(country);
		updateNumberGlobalOf();
	}
	
	public void delInduAgr(String country) {
		induAgr.addPartner(country);
		updateNumberGlobalOf();
	}
}

package economy;

import java.util.ArrayList;

public class CommercialAgreements extends Agreements {
	private ArrayList<int[]> returnOnInvestment;
	
	public CommercialAgreements() {
		super();
		returnOnInvestment = new ArrayList<int[]>();
	}
	
	public void addReturnOnInvestment(int investment) {
		int[] rOI = new int[] {investment, 10};
		returnOnInvestment.add(rOI);
	}
	
	public void newYear(int index) {
		int[] tab = returnOnInvestment.get(index);
		tab[1]--;
		returnOnInvestment.set(index, tab);
	}

	public ArrayList<int[]> getReturnOnInvestment() {
		return returnOnInvestment;
	}

	public void setReturnOnInvestment(ArrayList<int[]> returnOnInvestment) {
		this.returnOnInvestment = returnOnInvestment;
	}
	
}
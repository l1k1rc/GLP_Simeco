package economy;

import java.util.ArrayList;

public class Agreements {
	private int numberOf;
	private ArrayList<String> partners;
	
	public Agreements() {
		numberOf = 0;
		partners = new ArrayList<String>();
	}
	
	public void addPartner(String country) {
		partners.add(country);
		numberOf++;
	}
	
	public void delPartner(String country) {
		partners.remove(country);
		numberOf--;
	}

	public int getNumberOf() {
		return numberOf;
	}


	public ArrayList<String> getPartners() {
		return partners;
	}
	
	
}

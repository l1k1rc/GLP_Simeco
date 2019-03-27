package engine;

import political.PoliticalStatus;

public class PoliticalStatusAlgorithm {
	private static int demFordict = 10;
	private boolean custom;
	private PoliticalStatus ps;

	public PoliticalStatusAlgorithm(boolean custom) {
		this.custom = custom;
	}
	
	public PoliticalStatus politicalInitialisation(int isItDemocracy) {
		if (custom == false) {
			int value = RandomValue.generateNumber(demFordict);
			if (value == 4) ps = new PoliticalStatus("dictatorship");
			
			else ps = new PoliticalStatus("democracy");
		}
		else {
			if (isItDemocracy == 1) ps = new PoliticalStatus("democracy");
			else ps = new PoliticalStatus("dictatorship");	
		}
		
		return ps;
	}
}

package engine;

import military.Militarisation;
import political.PoliticalStatus;

public class MilitarisationAlgorithm {
	private static int coefNuclearBomb = 20;
	private Militarisation militarisation;
	private PoliticalStatus ps;
	
	public MilitarisationAlgorithm(PoliticalStatus ps) {
		this.ps = ps;
		
	}
	
	public Militarisation militarisationInitialisation() {
		double nbSoldiers = nbSoldiersGenerator();
		double militaryBudget = militaryBudgetGenerator();
		boolean gotNuclearBomb = nuclearBombGenerator();
		militarisation = new Militarisation(nbSoldiers, militaryBudget, gotNuclearBomb);
		return militarisation;
	}
	
	public boolean nuclearBombGenerator() {
		boolean gotNuclearBomb = false;
		int value = RandomValue.generateNumber(coefNuclearBomb);
		if (value == 10) gotNuclearBomb = true;
		
		return gotNuclearBomb;	
	}
	
	public double nbSoldiersGenerator() {
		double nbSoldiers;
		if (ps.getRegime().equals("dictatroship")) {
			int nbr = RandomValue.generateNumber(4);		//Quand un pays est une dictature, il à 1/4 chance d'avoir beaucoup de soldats.
			if (nbr == 3) {									//Compared to south-Corea : 3 669 000 soldiers for 51 Million (7.2%).
				 nbSoldiers = RandomValue.generatePercentageValue(8);
			}
			else {
				nbSoldiers = RandomValue.generateBoundedPercentageValue(8, 51);		//Compared to north-Corea 50% of population is a soldier.
			}
		}
		else {
			 nbSoldiers = RandomValue.generatePercentageValue(8);			
		}
		return nbSoldiers;									//percentage of total hab 
	}
	
	public double militaryBudgetGenerator() {
		double militaryBudget;
		if (ps.getRegime().equals("dictatroship")) {
			militaryBudget  = RandomValue.generatePercentageValue(21);      //Erythree = 20%
		}
		else {
			militaryBudget  = RandomValue.generatePercentageValue(5);
		}
		
		return militaryBudget;
	}
	
}
	


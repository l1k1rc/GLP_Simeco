package military;

public class Militarisation {
	private double nbSoldiers;
	private double militaryBudget;
	private boolean nuclearBomb;
	
	public Militarisation(double nbSoldiers, double militaryBudget, boolean nuclearBomb) {
		this.nbSoldiers = nbSoldiers;
		this.militaryBudget = militaryBudget;
		this.nuclearBomb = nuclearBomb;
	}

	public double getNbSoldiers() {
		return nbSoldiers;
	}

	public void setNbSoldiers(double nbSoldiers) {
		this.nbSoldiers = nbSoldiers;
	}

	public double getMilitaryBudget() {
		return militaryBudget;
	}

	public void setMilitaryBudget(double militaryBudget) {
		this.militaryBudget = militaryBudget;
	}

	public boolean getNuclearBomb() {
		return nuclearBomb;
	}

	public void setNuclearBomb(boolean nuclearBomb) {
		this.nuclearBomb = nuclearBomb;
	}	
}

package processingEngine;

import economy.EconomicalFactors;
import military.Militarisation;
import political.PoliticalStatus;
import engine.RandomValue;

public class MilitaryProcess {

	private PoliticalStatus ps;
	private EconomicalFactors ef;

	public MilitaryProcess(PoliticalStatus ps, EconomicalFactors ef) {
		this.ps = ps;
		this.ef = ef;
	}

	public Militarisation militaryProcess(Militarisation militarisationData) {
		militarisationData = this.soldiersProcess(militarisationData);
		militarisationData = this.budgetProcess(militarisationData);
		militarisationData = this.nuclearProcess(militarisationData);
		
		return militarisationData;
	}
	
	
	public Militarisation soldiersProcess(Militarisation militarisation) {
		int chance = RandomValue.generateNumber(6);
		//Percentage soldiers
		if (ps.getRegime().equals("democracy")) {
			if (chance == 0) militarisation.setNbSoldiers(militarisation.getNbSoldiers()-0.1);
			else if (chance == 5) militarisation.setNbSoldiers(militarisation.getNbSoldiers()+0.1);	
		}
		else {
			if (chance == 0) militarisation.setNbSoldiers(militarisation.getNbSoldiers()-0.1);
			else if ((chance == 5) || (chance == 4)) militarisation.setNbSoldiers(militarisation.getNbSoldiers()+0.1);	
		}
		
		return militarisation;
	}
	
	public Militarisation budgetProcess(Militarisation militarisation) {
		int chance = RandomValue.generateNumber(5);
		//Military budget
		if (ps.getRegime().equals("democracy")) {
			if (ef.getGdpValues().getGdp() > 4000000) {	 //If gdp is high
				if (chance == 0) militarisation.setMilitaryBudget(militarisation.getMilitaryBudget()-0.1);
				else if ((chance > 1) && (chance < 5)) militarisation.setMilitaryBudget(militarisation.getMilitaryBudget()+0.1);
			}
			else if (ef.getGdpValues().getGdp() < 1000000) { //If pib is low
				if (chance == 4) militarisation.setMilitaryBudget(militarisation.getMilitaryBudget()+0.1);
				else if ((chance >= 0) && (chance < 4)) militarisation.setMilitaryBudget(militarisation.getMilitaryBudget()-0.1);
			}
			else {		//If pib is medium
				if (chance == 0) militarisation.setMilitaryBudget(militarisation.getMilitaryBudget()-0.1);
				else if ((chance == 4)) militarisation.setMilitaryBudget(militarisation.getMilitaryBudget()+0.1);
			}
		}
		else {
			if (chance == 0) militarisation.setMilitaryBudget(militarisation.getMilitaryBudget()-0.1);
			else if ((chance > 0) && (chance < 4)) militarisation.setMilitaryBudget(militarisation.getMilitaryBudget()+0.1);
			else militarisation.setMilitaryBudget(militarisation.getMilitaryBudget()+0.2);
		}
		
		return militarisation;
	}
	
	public Militarisation nuclearProcess(Militarisation militarisation) {
		if (militarisation.getNuclearBomb() == false) {
			double chancePercentage = ef.getPopulationValues().getReschercheSpending()*5;
			int chance = RandomValue.generateBoundedNumber(1, 101);
			
			if (chance < chancePercentage) militarisation.setNuclearBomb(true);
		}
		return militarisation;
	}

	public PoliticalStatus getPs() {
		return ps;
	}

	public void setPs(PoliticalStatus ps) {
		this.ps = ps;
	}

	public EconomicalFactors getEf() {
		return ef;
	}

	public void setEf(EconomicalFactors ef) {
		this.ef = ef;
	}
	
	
}

package processingEngine;
import engine.RandomValue;
import economy.EconomicalFactors;
import political.PoliticalStatus;

public class EconomicalFactorsProcess {
	private int chance;
	private double lastUnemploymentRate;
	private PoliticalStatus ps;
	private EconomicalFactors ef;
	
	
	
	public EconomicalFactorsProcess(double lastUnemploymentRate, PoliticalStatus ps, EconomicalFactors ef) {
		this.lastUnemploymentRate = lastUnemploymentRate;
		this.ps = ps;
		this.ef = ef;
	}

	public EconomicalFactors economicalProcess() {
		double newUR = ef.getPopulationValues().getUnemploymentRate() + this.unemploymentRateProcess();
		ef.getPopulationValues().setUnemploymentRate(newUR);
		
		int[] newCoefGDP = this.gdpProcess();
		int newConsuption = ef.getGdpValues().getConsuption() + newCoefGDP[0];
		ef.getGdpValues().setConsuption(newConsuption);
		int newInvestment = ef.getGdpValues().getInvestment() + newCoefGDP[1];
		ef.getGdpValues().setInvestment(newInvestment);
		int newGS = ef.getGdpValues().getGovernementSpending() + newCoefGDP[2];
		ef.getGdpValues().setGovernementSpending(newGS);
		
		
		double newPG = ef.getPopulationValues().getPopulationGrowth() + this.populationGrowthProcess();
		ef.getPopulationValues().setPopulationGrowth(newPG);
		
		double newGini = ef.getPopulationValues().getGini() + this.giniProcess();
		ef.getPopulationValues().setGini(newGini);
		
		double newRS = ef.getPopulationValues().getReschercheSpending() + this.reschercheSpendingProcess();
		ef.getPopulationValues().setReschercheSpending(newRS);
		
		double newLE = ef.getHidValues().getLifeExpectancy() + this.lifeExpectancyProcess();
		ef.getHidValues().setLifeExpectancy(newLE);
		
		double newMA = ef.getPopulationValues().getMiddleAge() + this.middleAgeProcess();
		ef.getPopulationValues().setMiddleAge(newMA);
		
		int newPopu = ef.getHidValues().getPerCapitaIncome().getPopulation() + this.populationProcess();
		ef.getHidValues().getPerCapitaIncome().setPopulation(newPopu);
		ef.getHidValues().getPerCapitaIncome().setIncome(ef.getGdpValues().getGdp());
		ef.getHidValues().setPerCapitaIncome(ef.getHidValues().getPerCapitaIncome()); // oui non ?
		
		double[] newCoefSchooling = this.schoolingProcess();
		ef.getHidValues().getEducation().setExpectationSchoolingDuration(ef.getHidValues().getEducation().getExpectationSchoolingDuration()
				+ newCoefSchooling[0]);
		ef.getHidValues().getEducation().setAverageDurationOfSchooling(ef.getHidValues().getEducation().getAverageDurationOfSchooling()
				+ newCoefSchooling[1]);
		ef.getHidValues().setEducation(ef.getHidValues().getEducation());
		
		return ef;
	}
	
	public double unemploymentRateProcess() {
		double ur = 0;
		chance = RandomValue.generateNumber(8);
		
		if (chance == 0) ur = -0.1;
		else if (chance == 6) ur = 0.1;
		else if (chance == 7) {
			chance = RandomValue.generateNumber(2);
			if (chance == 0) ur = -0.2;
			else ur = 0.2;
		}
		
		if (ef.getPopulationValues().getUnemploymentRate()+ur < 0 ) ur = 0;
		return ur;
	}
	
	public int[] gdpProcess() {
		int[] newGDP = new int[] {0,0,0};
		
		if (lastUnemploymentRate != ef.getPopulationValues().getUnemploymentRate()) {
			double difUR = lastUnemploymentRate - ef.getPopulationValues().getUnemploymentRate();
			double unemployedPopu = ef.getHidValues().getPerCapitaIncome().getPopulation()*(difUR/100);
			double incomLess = (ef.getHidValues().getPerCapitaIncome().getPerCapitaIncome())*0.3;
			int newConsuption = (int) (unemployedPopu*incomLess);
			
			newGDP[0] = newConsuption;
		}
		
		chance = RandomValue.generateNumber(3);
		int newInvest = 0;
		if (chance == 0) newInvest = -15000;
		else if (chance == 2) newInvest = 15000;
		
		newGDP[1] = newInvest;
		
		chance = RandomValue.generateNumber(3);
		int newGS = 0;
		if (chance == 0) newGS = -15000;
		else if (chance == 2) newGS = 15000;
		
		newGDP[2] = newGS;
		
		return newGDP;
	}
	
	public double populationGrowthProcess() {
		double pg = 0;
		chance = RandomValue.generateNumber(8);
		if (ef.getGdpValues().getGdp() <= 400000) {
			if (chance == 0) pg = -0.1;
			else if ((chance > 3) && (chance <=6)) pg = 0.1;
			else if (chance == 7) pg = 0.2;
		}
		else {
			if (chance == 0) pg = -0.1;
			else if (chance == 7) pg = 0.1;
		}
		
		if (ef.getPopulationValues().getPopulationGrowth()+pg < -2) pg = 0;
		return pg;
	}
	
	public double giniProcess() {
		double gini = 0;
		
		if (ps.getRegime().equals("dictatorship")) {
			chance = RandomValue.generateNumber(8);
			if ((chance == 0) || (chance == 1)) gini = -1;
			else if ((chance > 3) && (chance <= 7)) gini = 1;
		}
		else {
			chance = RandomValue.generateNumber(5);
			if (chance == 0) gini = -1;
			else if (chance == 4) gini = 1;
		}
		
		if ((ef.getPopulationValues().getGini()+gini < 10) || ef.getPopulationValues().getGini()+gini > 90) gini = 0;
		
		return gini;
	}
	
	public double reschercheSpendingProcess() {
		double rs = 0;
		chance = RandomValue.generateNumber(8);
		
		if (ef.getGdpValues().getGdp() > 2000000) {
			if (chance == 0) rs = -0.1;
			else if ((chance == 6) || (chance == 7)) rs = 0.1;
		}
		else if ((ef.getGdpValues().getGdp() <= 2000000) && (ef.getGdpValues().getGdp() > 1000000)) {
			if (chance == 0) rs = -0.1;
			else if (chance == 7) rs = 0.1;
		}
		else {
			if ((chance == 0) || (chance == 1)) rs = -0.1;
			else if (chance == 7) rs = 0.1;
		}
		
		if (ef.getPopulationValues().getReschercheSpending()+rs == 0) rs = 0;
		
		return rs;
	}
	
	public double lifeExpectancyProcess() {
		double le = 0;
		chance = RandomValue.generateNumber(8);
		
		if (ef.getPopulationValues().getReschercheSpending() > 2.5) {
			if (chance == 0) le = -0.8;
			else if ((chance > 4) && (chance <=7)) le = 0.8;
		}
		if ((ef.getPopulationValues().getReschercheSpending() > 1.5) && (ef.getPopulationValues().getReschercheSpending() <= 2.5)) {
			if (chance == 0) le = -0.8;
			else if (chance == 7) le = 0.8;
		}
		else {
			if ((chance >= 0) && (chance < 3)) le = -0.8;
			else if (chance == 7) le = 0.8;
		}
		
		//2nd dependence
		if (ef.getGdpValues().getGovernementSpending() > 1500000) {
			if (chance == 0) le += -0.8;
			else if ((chance > 4) && (chance <=7)) le += 0.8;
		}
		if ((ef.getGdpValues().getGovernementSpending() > 800000) && (ef.getGdpValues().getGovernementSpending() <= 1500000)) {
			if (chance == 0) le += -0.8;
			else if (chance == 7) le += 0.8;
		}
		else {
			if ((chance >= 0) && (chance < 3)) le += -0.8;
			else if (chance == 7) le += 0.8;
		}
		
		if (ef.getHidValues().getLifeExpectancy()+le < 45) le = 0;
		
		return le;
	}
	
	public double middleAgeProcess() {
		double ma = 0;
		chance = RandomValue.generateNumber(8);
		
		if (ef.getHidValues().getLifeExpectancy() < 60) {
			if ((chance >= 0) && (chance < 4)) ma = -0.5;
			else if (chance == 7) ma = 0.5;
			
		}
		if ((ef.getHidValues().getLifeExpectancy() >= 60) && (ef.getHidValues().getLifeExpectancy() < 70)) {
			if ((chance == 0) || (chance == 1)) ma = -0.5;
			else if ((chance == 6) || (chance == 7)) ma = 0.5;
		}
		else {
			if (chance == 0) ma = -0.5;
			else if ((chance > 3) && (chance <= 7)) ma = 0.5;
		}
		
		if (ef.getPopulationValues().getMiddleAge()+ma <= 14) ma = 0;
		
		return ma;
	}
	
	public int populationProcess() {
		int pop = (int) ((ef.getHidValues().getPerCapitaIncome().getPopulation())*(ef.getPopulationValues().getPopulationGrowth()/100));
		return pop;
	}
	
	public double[] schoolingProcess() {
		double eds = 0;
		double ads = 0;
		
		chance = RandomValue.generateNumber(8);
		if (ef.getGdpValues().getGdp() > 2000000) {
			if (chance == 0) eds = -0.1;
			else if ((chance > 5) && (chance <=7)) eds = 0.1;
		}
		if ((ef.getGdpValues().getGdp() > 900000) && (ef.getGdpValues().getGdp() <= 2000000)) {
			if (chance == 0) eds = -0.1;
			else if (chance == 7) eds = 0.1;
		}
		else {
			if ((chance >= 0) && (chance < 2)) eds = -0.1;
			else if (chance == 7) eds = 0.1;
		}
		
		//2nd dependence
		chance = RandomValue.generateNumber(8);
		if (ef.getGdpValues().getGdp() > 2000000) {
			if (chance == 0) ads = -0.1;
			else if ((chance > 5) && (chance <=7)) ads = 0.1;
		}
		if ((ef.getGdpValues().getGdp() > 900000) && (ef.getGdpValues().getGdp() <= 2000000)) {
			if (chance == 0) ads = -0.1;
			else if (chance == 7) ads = 0.1;
		}
		else {
			if ((chance >= 0) && (chance < 2)) ads = -0.1;
			else if (chance == 7) ads = 0.1;
		}
		
		if (ef.getHidValues().getEducation().getAverageDurationOfSchooling()+ads > 
				ef.getHidValues().getEducation().getExpectationSchoolingDuration()+eds) ads = 0;
		
		
		double[] schooling = new double[] {eds, ads};
		
		return schooling;
		
	}
	
	
	
	
	
	
	
	
	
}

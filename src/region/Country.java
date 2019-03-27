package region;
import industries.*;
import political.PoliticalStatus;
import economy.*;
import ressources.*;
import military.*;

public class Country {
	private String name;
	private IndustrialFactors industrialFactors;
	private EconomicalFactors economicalFactors;
	private Ressources ressources;
	private PoliticalStatus politicalStatus;
	private Militarisation militarisation;
	
	public Country(String name, Ressources ressources) {
		this.name = name;
		this.ressources = ressources;
	}
	
	public Country(String name, IndustrialFactors industrialFactors, EconomicalFactors economicalFactors,
			Ressources ressources, PoliticalStatus politicalStatus, Militarisation militarisation) {
		super();
		this.name = name;
		this.industrialFactors = industrialFactors;
		this.economicalFactors = economicalFactors;
		this.ressources = ressources;
		this.politicalStatus = politicalStatus;
		this.militarisation = militarisation;
	}
	
	public String getName() {
		return name;
	}
	public IndustrialFactors getIndustrialFactors() {
		return industrialFactors;
	}
	public EconomicalFactors getEconomicalFactors() {
		return economicalFactors;
	}
	public Ressources getRessources() {
		return ressources;
	}

	public PoliticalStatus getPoliticalStatus() {
		return politicalStatus;
	}
	public Militarisation getMilitarisation() {
		return militarisation;
	}

	public void setIndustrialFactors(IndustrialFactors industrialFactors) {
		this.industrialFactors = industrialFactors;
	}

	public void setEconomicalFactors(EconomicalFactors economicalFactors) {
		this.economicalFactors = economicalFactors;
	}

	public void setRessources(Ressources ressources) {
		this.ressources = ressources;
	}

	public void setPoliticalStatus(PoliticalStatus politicalStatus) {
		this.politicalStatus = politicalStatus;
	}

	public void setMilitarisation(Militarisation militarisation) {
		this.militarisation = militarisation;
	}
	
	
	

}

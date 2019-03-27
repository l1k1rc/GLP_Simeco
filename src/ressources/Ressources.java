package ressources;

public class Ressources {
	private boolean[] criticalRessources;
	private boolean[] helpAvailable;
	private GlobalLakes lakes;
	private GlobalSuitableLands suitablesLands;
	private GlobalFields fields;
	private GlobalForests forests;
	private GlobalOil oilWell;
	private GlobalGoldMines goldMines;
	private GlobalIronMines ironMines;
	private GlobalCoalMines coalMines;
	
	public Ressources(GlobalLakes lakes, GlobalSuitableLands suitablesLands, GlobalFields fields, GlobalForests forests,
			GlobalOil oilWell, GlobalGoldMines goldMines, GlobalIronMines ironMines, GlobalCoalMines coalMines) {
		this.lakes = lakes;
		this.suitablesLands = suitablesLands;
		this.fields = fields;
		this.forests = forests;
		this.oilWell = oilWell;
		this.goldMines = goldMines;
		this.ironMines = ironMines;
		this.coalMines = coalMines;
		this.criticalRessources = new boolean[] {false,false,false,false,false,false,false,false};
		this.helpAvailable = new boolean[] {true,true,true,true,true,true,true,true};
	}

	public GlobalLakes getLakes() {
		return lakes;
	}
	
	public GlobalSuitableLands getSuitablesLands() {
		return suitablesLands;
	}
	
	public GlobalFields getFields() {
		return fields;
	}
	
	public GlobalForests getForests() {
		return forests;
	}
	
	public GlobalOil getOilWell() {
		return oilWell;
	}
	
	public GlobalGoldMines getGoldMines() {
		return goldMines;
	}
	
	public GlobalIronMines getIronMines() {
		return ironMines;
	}
	
	public GlobalCoalMines getCoalMines() {
		return coalMines;
	}

	public boolean[] getCriticalRessources() {
		return criticalRessources;
	}

	public void setCriticalRessources(boolean[] criticalRessources) {
		this.criticalRessources = criticalRessources;
	}
	
	public void replaceCriticalRessource(int index, boolean isIt) {
		this.criticalRessources[index] = isIt;
	}
	
	public boolean getByIndexCriticalRessource(int index) {
		return this.criticalRessources[index];
	}

	public boolean[] getHelpAvailable() {
		return helpAvailable;
	}

	public void setHelpAvailable(boolean[] helpAvailable) {
		this.helpAvailable = helpAvailable;
	}
	
	public void replaceHelpAvailable(int index, boolean isIt) {
		this.criticalRessources[index] = isIt;
	}
	
	public boolean getByIndexHelpAvailable(int index) {
		return this.helpAvailable[index];
	}
}

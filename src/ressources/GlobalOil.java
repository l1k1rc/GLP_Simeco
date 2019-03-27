package ressources;

import java.util.ArrayList;

public class GlobalOil implements UpdatesInterface {
	
	private int numberOf;
	private float globalSize;
	private ArrayList<OilWell> globalOilWells;
	
	public GlobalOil() {
		this.numberOf = 0;
		this.globalSize = 0;
		globalOilWells = new ArrayList<OilWell>();
	}
	
	public void addOilWell(float size) {
		OilWell oilWell = new OilWell(size);
		globalOilWells.add(oilWell);
		this.updateNumberOf();
		this.updateGlobalSize();
	}
	
	public void delOilWell(int index) {
		globalOilWells.remove(index);
		this.updateNumberOf();
	}
	
	public void updateNumberOf() {
		numberOf = globalOilWells.size();
	}
	

	public void updateGlobalSize() {
		globalSize = 0;
		for(OilWell index : globalOilWells) {
			globalSize += index.getContentSize();
		}
	}
	
	public int getNumberOf() {
		return numberOf;
	}
		
	public float getGlobalSize() {
		return globalSize;
	}
	
	public ArrayList<OilWell> globalOilWells() {
		return globalOilWells;
	}
	
	public OilWell oilWellByIndex(int index) {
		return globalOilWells.get(index);
	}

}

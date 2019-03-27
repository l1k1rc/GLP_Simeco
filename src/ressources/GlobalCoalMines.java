package ressources;

import java.util.ArrayList;

public class GlobalCoalMines implements UpdatesInterface {
	
	private int numberOf;
	private float globalSize;
	private ArrayList<CoalMine> globalCoalMines;
	
	public GlobalCoalMines() {
		this.numberOf = 0;
		this.globalSize = 0;
		globalCoalMines = new ArrayList<CoalMine>();
	}
	
	public void addCoalMine(float size) {
		CoalMine coalMine = new CoalMine(size);
		globalCoalMines.add(coalMine);
		this.updateNumberOf();
		this.updateGlobalSize();
	}
	
	public void delCoalMine(int index) {
		globalCoalMines.remove(index);
		this.updateNumberOf();
	}
	
	public void updateNumberOf() {
		numberOf = globalCoalMines.size();
	}
	

	public void updateGlobalSize() {
		globalSize = 0;
		for(CoalMine index : globalCoalMines) {
			globalSize += index.getContentSize();
		}
	}
	
	
	public int getNumberOf() {
		return numberOf;
	}
		
	public float getGlobalSize() {
		return globalSize;
	}
	
	public ArrayList<CoalMine> getGlobalCoalMines() {
		return globalCoalMines;
	}
	
	public CoalMine coalMineByIndex(int index) {
		return globalCoalMines.get(index);
	}

}

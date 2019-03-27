package ressources;

import java.util.ArrayList;

public class GlobalGoldMines implements UpdatesInterface {
	
	private int numberOf;
	private float globalSize;
	private ArrayList<GoldMine> globalGoldMines;
	
	public GlobalGoldMines() {
		this.numberOf = 0;
		this.globalSize = 0;
		globalGoldMines = new ArrayList<GoldMine>();
	}
	
	public void addGoldMine(float size) {
		GoldMine goldMine = new GoldMine(size);
		globalGoldMines.add(goldMine);
		this.updateNumberOf();
		this.updateGlobalSize();
	}
	
	public void delGoldMine(int index) {
		globalGoldMines.remove(index);
		this.updateNumberOf();
	}
	
	public void updateNumberOf() {
		numberOf = globalGoldMines.size();
	}
	

	public void updateGlobalSize() {
		globalSize = 0;
		for(GoldMine index : globalGoldMines) {
			globalSize += index.getContentSize();
		}
	}
	
	
	public int getNumberOf() {
		return numberOf;
	}
		
	public float getGlobalSize() {
		return globalSize;
	}
	
	public ArrayList<GoldMine> getGlobalGoldMines() {
		return globalGoldMines;
	}
	
	public GoldMine goldMineByIndex(int index) {
		return globalGoldMines.get(index);
	}

}

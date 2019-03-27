package ressources;

import java.util.ArrayList;

public class GlobalIronMines implements UpdatesInterface {
	
	private int numberOf;
	private float globalSize;
	private ArrayList<IronMine> globalIronMines;
	
	public GlobalIronMines() {
		this.numberOf = 0;
		this.globalSize = 0;
		globalIronMines = new ArrayList<IronMine>();
	}
	
	public void addIronMine(float size) {
		IronMine ironMine = new IronMine(size);
		globalIronMines.add(ironMine);
		this.updateNumberOf();
		this.updateGlobalSize();
	}
	
	public void delIronMine(int index) {
		globalIronMines.remove(index);
		this.updateNumberOf();
	}
	
	public void updateNumberOf() {
		numberOf = globalIronMines.size();
	}
	

	public void updateGlobalSize() {
		globalSize = 0;
		for(IronMine index : globalIronMines) {
			globalSize += index.getContentSize();
		}
	}
	
	
	public int getNumberOf() {
		return numberOf;
	}
		
	public float getGlobalSize() {
		return globalSize;
	}
	
	public ArrayList<IronMine> getGlobalIronMines() {
		return globalIronMines;
	}
	
	public IronMine ironMineByIndex(int index) {
		return globalIronMines.get(index);
	}

}

package ressources;

import java.util.ArrayList;

public class GlobalLakes implements UpdatesInterface {
	
	private int numberOf;
	private float globalSize;
	private ArrayList<Lake> globalLakes;
	
	public GlobalLakes() {
		this.numberOf = 0;
		this.globalSize = 0;
		globalLakes = new ArrayList<Lake>();
	}
	
	public void addLake(float size) {
		Lake lake = new Lake(size);
		globalLakes.add(lake);
		this.updateNumberOf();
		this.updateGlobalSize();
	}
	
	public void delLake(int index) {
		globalLakes.remove(index);
		this.updateNumberOf();
	}
	
	
	public void updateNumberOf() {
		numberOf = globalLakes.size();
	}
	

	public void updateGlobalSize() {
		globalSize = 0;
		for(Lake index : globalLakes) {
			globalSize += index.getContentSize();
		}
	}
	
	
	public int getNumberOf() {
		return numberOf;
	}
		
	public float getGlobalSize() {
		return globalSize;
	}
	
	public ArrayList<Lake> getGlobalLakes() {
		return globalLakes;
	}
	
	public Lake lakeByIndex(int index) {
		return globalLakes.get(index);
	}

}

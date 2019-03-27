package ressources;

import java.util.ArrayList;

public class GlobalForests implements UpdatesInterface {
	
	private int numberOf;
	private float globalSize;
	private ArrayList<Forest> globalForests;
	
	public GlobalForests() {
		this.numberOf = 0;
		this.globalSize = 0;
		globalForests = new ArrayList<Forest>();
	}
	
	public void addForest(float size) {
		Forest forest = new Forest(size);
		globalForests.add(forest);
		this.updateNumberOf();
		this.updateGlobalSize();
	}
	
	public void delForest(int index) {
		globalForests.remove(index);
		this.updateNumberOf();
	}
	
	public void updateNumberOf() {
		numberOf = globalForests.size();
	}
	

	public void updateGlobalSize() {
		globalSize = 0;
		for(Forest index : globalForests) {
			globalSize += index.getContentSize();
		}
	}
	
	
	public int getNumberOf() {
		return numberOf;
	}
		
	public float getGlobalSize() {
		return globalSize;
	}
	
	public ArrayList<Forest> getGlobalForests() {
		return globalForests;
	}
	
	public Forest forestByIndex(int index) {
		return globalForests.get(index);
	}

}

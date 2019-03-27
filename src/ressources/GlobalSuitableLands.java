package ressources;

import java.util.ArrayList;

public class GlobalSuitableLands implements UpdatesInterface {
	
	private int numberOf;
	private float globalSize;
	private ArrayList<SuitableLand> globalSuitableLands;
	
	public GlobalSuitableLands() {
		this.numberOf = 0;
		this.globalSize = 0;
		globalSuitableLands = new ArrayList<SuitableLand>();
	}
	
	public void addSuitableLand(float size) {
		SuitableLand suitableLand = new SuitableLand(size);
		globalSuitableLands.add(suitableLand);
		this.updateNumberOf();
		this.updateGlobalSize();
	}
	
	public void delSuitableLand(int index) {
		globalSuitableLands.remove(index);
		this.updateNumberOf();
	}
	
	public void updateNumberOf() {
		numberOf = globalSuitableLands.size();
	}
	

	public void updateGlobalSize() {
		globalSize = 0;
		for(SuitableLand index : globalSuitableLands) {
			globalSize += index.getContentSize();
		}
	}
	
	
	public int getNumberOf() {
		return numberOf;
	}
		
	public float getGlobalSize() {
		return globalSize;
	}
	
	public ArrayList<SuitableLand> getGlobalSuitableLands() {
		return globalSuitableLands;
	}
	
	public SuitableLand suitableLandByIndex(int index) {
		return globalSuitableLands.get(index);
	}

}

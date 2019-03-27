package ressources;

import java.util.ArrayList;

public class GlobalFields implements UpdatesInterface {
	
	private int numberOf;
	private float globalSize;
	private ArrayList<Field> globalFields;
	
	public GlobalFields() {
		this.numberOf = 0;
		this.globalSize = 0;
		globalFields = new ArrayList<Field>();
	}
	
	public void addField(float size) {
		Field field = new Field(size);
		globalFields.add(field);
		this.updateNumberOf();
		this.updateGlobalSize();
	}
	
	public void delField(int index) {
		globalFields.remove(index);
		this.updateNumberOf();
	}
	
	public void updateNumberOf() {
		numberOf = globalFields.size();
	}
	

	public void updateGlobalSize() {
		globalSize = 0;
		for(Field index : globalFields) {
			globalSize += index.getContentSize();
		}
	}
	
	
	public int getNumberOf() {
		return numberOf;
	}
		
	public float getGlobalSize() {
		return globalSize;
	}
	
	public ArrayList<Field> getGlobalFields() {
		return globalFields;
	}
	
	public Field fieldByIndex(int index) {
		return globalFields.get(index);
	}

}

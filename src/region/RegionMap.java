package region;

import java.util.HashMap;
import java.util.Set;
import java.util.Map;

public class RegionMap {
	private HashMap<String,Country> mapRegion;
	
	public RegionMap() {
		mapRegion = new HashMap<String,Country>();
	}
	
	public void addState(Country country) throws Exception{
		if(mapRegion.containsKey(country.getName()) == false){
			mapRegion.put(country.getName(), country);
		}else throw new Exception("Ce pays existe déjà");
	}
	
	public Country getState(String name) throws NullPointerException {
		Set<String> keySet = mapRegion.keySet();
		for (String key : keySet) {
			if((key.contains(name) == true)) {
				return (Country) mapRegion.get(name);
			}
			
		}throw new NullPointerException("Pays inexistant");
	}
	
	public void setCountry(Country country) {
		mapRegion.put(country.getName(), country);
	}
	
	public void affiche() {
		for(Map.Entry<String,Country> mapentry : mapRegion.entrySet()) {
			System.out.println(mapentry.getKey());
			
		}
	}

	public HashMap<String, Country> getMapRegion() {
		return mapRegion;
	}
	
}

package engine;


import ressources.*;

//Cette classe veut génerer toutes les ressources d'un pays de manière automatique à l'intérieur de tailles par défaut.
public class RessourcesAutomatedAlgorithm {

	private int[][] sizeValues;
	
	public RessourcesAutomatedAlgorithm(int[][] sizeValues) {
		this.sizeValues = sizeValues;
	}

	/*.....Initialisation de l'algorythme.....*/
	public Ressources automatedRessourcesCreation() {
		GlobalLakes lakesGenerated = globalLakesGenerator();
		GlobalSuitableLands suitableLandsGenerated = globalSuitableLandsGenerator();
		GlobalFields fieldsGenerated = globalFieldsGenerator();
		GlobalForests forestsGenerated = globalForestsGenerator();
		GlobalOil oilWellsGenerated = globalOilGenerator();
		GlobalGoldMines goldMinesGenerated = globalGoldMinesGenerator();
		GlobalIronMines ironMinesGenerated = globalIronMinesGenerator();
		GlobalCoalMines coalMinesGenerated = globalCoalMinesGenerator();
		
		Ressources ressourcesGenerated = new Ressources(lakesGenerated, suitableLandsGenerated, fieldsGenerated, forestsGenerated, oilWellsGenerated,
				goldMinesGenerated, ironMinesGenerated, coalMinesGenerated);
	
		return ressourcesGenerated;
	}
	
	
	/*.....Génération automatique des ressources.....*/
	public GlobalLakes globalLakesGenerator() {
		int nbLakes = RandomValue.generateNumber(sizeValues[0][0]);
		GlobalLakes lakes = new GlobalLakes();
		for(int i=0; i < nbLakes ; i++) {
			int size = RandomValue.generateBoundedNumber(sizeValues[0][1], sizeValues[0][2]); //En Km^3 basé sur la taille du lac Léman (plus grand lac d'europe occidentale) 578.3Km²*0.309km = 117Km^3
			lakes.addLake(size);
		}
		return lakes;
	}
	
	public GlobalSuitableLands globalSuitableLandsGenerator() {
		int nbSL = RandomValue.generateNumber(sizeValues[1][0]);
		GlobalSuitableLands sl = new GlobalSuitableLands();
		for(int i=0; i < nbSL ; i++) {
			int size = RandomValue.generateBoundedNumber(sizeValues[1][1], sizeValues[1][2]); //En Km²
			sl.addSuitableLand(size);
		}
		return sl;
	}
	
	public GlobalFields globalFieldsGenerator() {
		int nbFields = RandomValue.generateNumber(sizeValues[2][0]);
		GlobalFields fields = new GlobalFields();
		for(int i=0; i < nbFields ; i++) {
			int size = RandomValue.generateBoundedNumber(sizeValues[2][1], sizeValues[2][2]); //En hectares
			fields.addField(size);
		}
		return fields;
	}
	
	public GlobalForests globalForestsGenerator() {
		int nbForests = RandomValue.generateNumber(sizeValues[3][0]);
		GlobalForests forests = new GlobalForests();
		for(int i=0; i < nbForests ; i++) {
			int size = RandomValue.generateBoundedNumber(sizeValues[3][1], sizeValues[3][2]); //En Km²
			forests.addForest(size);
		}
		return forests;
	}
	
	public GlobalOil globalOilGenerator() {
		int nbOil = RandomValue.generateNumber(sizeValues[4][0]);
		GlobalOil oil = new GlobalOil();
		for(int i=0; i < nbOil ; i++) {
			int size = RandomValue.generateBoundedNumber(sizeValues[4][1], sizeValues[4][2]); //En Km²
			oil.addOilWell(size);
		}
		return oil;
	}
	
	public GlobalGoldMines globalGoldMinesGenerator() {
		int nbGM = RandomValue.generateNumber(sizeValues[5][0]);
		GlobalGoldMines gm = new GlobalGoldMines();
		for(int i=0; i < nbGM ; i++) {
			int size = RandomValue.generateBoundedNumber(sizeValues[5][1], sizeValues[5][2]); //Profondeur en m
			gm.addGoldMine(size);
		}
		return gm;
	}
	
	public GlobalIronMines globalIronMinesGenerator() {
		int nbIM = RandomValue.generateNumber(sizeValues[6][0]);
		GlobalIronMines im = new GlobalIronMines();
		for(int i=0; i < nbIM ; i++) {
			int size = RandomValue.generateBoundedNumber(sizeValues[6][1], sizeValues[6][2]); //Profondeur en m
			im.addIronMine(size);
		}
		return im;
	}
	
	public GlobalCoalMines globalCoalMinesGenerator() {
		int nbCM = RandomValue.generateNumber(sizeValues[7][0]);
		GlobalCoalMines cm = new GlobalCoalMines();
		for(int i=0; i < nbCM ; i++) {
			int size = RandomValue.generateBoundedNumber(sizeValues[7][1], sizeValues[7][2]); //Profondeur en m
			cm.addCoalMine(size);
		}
		return cm;
	}

	public int[][] getSizeValues() {
		return sizeValues;
	}

}
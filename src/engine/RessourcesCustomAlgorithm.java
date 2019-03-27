package engine;

import java.util.ArrayList;


import ressources.GlobalCoalMines;
import ressources.GlobalFields;
import ressources.GlobalForests;
import ressources.GlobalGoldMines;
import ressources.GlobalIronMines;
import ressources.GlobalLakes;
import ressources.GlobalOil;
import ressources.GlobalSuitableLands;
import ressources.Ressources;

/*Cette classe veut générer toutes les ressources d'un pays qui à été sélectionné en custom, pour se faire elle demande le nom du pays, une AL avec les choix pour chaques ressources
et un tableau avec les tailles et nombres par défaut de ces dernières.*/
public class RessourcesCustomAlgorithm {
	private ArrayList<Integer> isItCustom;
	private int[][] sizeValues;
	
	
	public RessourcesCustomAlgorithm(ArrayList<Integer> isItCustom, int[][] sizeValues) {
		this.isItCustom = isItCustom;
		this.sizeValues = sizeValues;
	}
	
	/*.....Assignation en fonction de Automated, Bounded ou Custom.....*/
	public Ressources customCountryCreation() throws IndexOutOfBoundsException {
		int counter = 0;
		GlobalLakes lakesGenerated = new GlobalLakes();
		GlobalSuitableLands suitableLandsGenerated = new GlobalSuitableLands();
		GlobalFields fieldsGenerated = new GlobalFields();
		GlobalForests forestsGenerated = new GlobalForests();
		GlobalOil oilWellsGenerated = new GlobalOil();
		GlobalGoldMines goldMinesGenerated = new GlobalGoldMines();
		GlobalIronMines ironMinesGenerated = new GlobalIronMines();
		GlobalCoalMines coalMinesGenerated = new GlobalCoalMines();
		
		for (Integer index : isItCustom) {				//Si index = 0 : Auto | Si index = [-6,-7,-8,-9,-10] : Bounded | Si index = R+* : Custom
			counter++;
			if (index == 0) {
				RessourcesAutomatedAlgorithm autoGen = new RessourcesAutomatedAlgorithm(sizeValues);
			
				switch (counter) {
					case 1: 	lakesGenerated = autoGen.globalLakesGenerator();
								break;
								
					case 2:		suitableLandsGenerated = autoGen.globalSuitableLandsGenerator();
								break;
								
					case 3: 	fieldsGenerated = autoGen.globalFieldsGenerator();
								break;
								
					case 4: 	forestsGenerated = autoGen.globalForestsGenerator();
								break;
								
					case 5: 	oilWellsGenerated = autoGen.globalOilGenerator();
								break;
								
					case 6: 	goldMinesGenerated = autoGen.globalGoldMinesGenerator();
								break;
								
					case 7: 	ironMinesGenerated = autoGen.globalIronMinesGenerator();
								break;
								
					case 8: 	coalMinesGenerated = autoGen.globalCoalMinesGenerator(); 
								break;
								
					default: 	throw new IndexOutOfBoundsException("En dehors de l'ArrayList de génération automatique des ressources");
				}
				
			}
			else if ((index >= -10) && (index <= -6)) {
				RessourcesBoundedAlgorithm boundedGen = new RessourcesBoundedAlgorithm(sizeValues);
				
				switch (counter) {
					case 1: 	lakesGenerated = boundedGen.globalBoundedLakesGenerator(index);
								break;
							
					case 2:		suitableLandsGenerated = boundedGen.globalBoundedSuitableLandsGenerator(index);
								break;
							
					case 3: 	fieldsGenerated = boundedGen.globalBoundedFieldsGenerator(index);
								break;
							
					case 4: 	forestsGenerated = boundedGen.globalBoundedForestsGenerator(index);
								break;
							
					case 5: 	oilWellsGenerated = boundedGen.globalBoundedOilGenerator(index);
								break;
							
					case 6: 	goldMinesGenerated = boundedGen.globalBoundedGoldMinesGenerator(index);
								break;
							
					case 7:		ironMinesGenerated = boundedGen.globalBoundedIronMinesGenerator(index);
								break;
							
					case 8: 	coalMinesGenerated = boundedGen.globalBoundedCoalMinesGenerator(index);
								break;
							
					default: 	throw new IndexOutOfBoundsException("En dehors de l'ArrayList de génération bornée des ressources");
				}
				
			}
			else {
				switch (counter) {
					case 1: 	lakesGenerated = globalLakesCustomGenerator(index);
								break;
							
					case 2:		suitableLandsGenerated = globalSuitableLandsCustomGenerator(index);
								break;
							
					case 3: 	fieldsGenerated = globalFieldsCustomGenerator(index);
								break;
							
					case 4: 	forestsGenerated = globalForestsCustomGenerator(index);
								break;
							
					case 5: 	oilWellsGenerated = globalOilCustomGenerator(index);
								break;
							
					case 6: 	goldMinesGenerated = globalGoldMinesCustomGenerator(index);
								break;
							
					case 7: 	ironMinesGenerated = globalIronMinesCustomGenerator(index);
								break;
							
					case 8: 	coalMinesGenerated = globalCoalMinesCustomGenerator(index); 
								break;
							
					default: 	throw new IndexOutOfBoundsException("En dehors de l'ArrayList de génération custom des ressources");
					}
				}
		}
		Ressources ressourcesGenerated = new Ressources(lakesGenerated, suitableLandsGenerated, fieldsGenerated, forestsGenerated, oilWellsGenerated,
				goldMinesGenerated, ironMinesGenerated, coalMinesGenerated);
		
		return ressourcesGenerated;
	}
	
	
	/*.....Génération custom des ressources.....*/
	public GlobalLakes globalLakesCustomGenerator(int nbr) {
		GlobalLakes lakes = new GlobalLakes();
		for(int i=0; i < nbr ; i++) {
			int size = RandomValue.generateBoundedNumber(sizeValues[0][1], sizeValues[0][2]); //En m^3 basé sur la taille du lac Léman (plus grand lac d'europe occidentale) 578.3Km²*309m
			lakes.addLake(size);
		}
		return lakes;
	}
	
	public GlobalSuitableLands globalSuitableLandsCustomGenerator(int nbr) {
		GlobalSuitableLands sl = new GlobalSuitableLands();
		for(int i=0; i < nbr ; i++) {
			int size = RandomValue.generateBoundedNumber(sizeValues[1][1], sizeValues[1][2]); //En Km²
			sl.addSuitableLand(size);
		}
		return sl;
	}
	
	public GlobalFields globalFieldsCustomGenerator(int nbr) {
		GlobalFields fields = new GlobalFields();
		for(int i=0; i < nbr ; i++) {
			int size = RandomValue.generateBoundedNumber(sizeValues[2][1], sizeValues[2][2]); //En hectares
			fields.addField(size);
		}
		return fields;
	}
	
	public GlobalForests globalForestsCustomGenerator(int nbr) {
		GlobalForests forests = new GlobalForests();
		for(int i=0; i < nbr ; i++) {
			int size = RandomValue.generateBoundedNumber(sizeValues[3][1], sizeValues[3][2]); //En Km²
			forests.addForest(size);
		}
		return forests;
	}
	
	public GlobalOil globalOilCustomGenerator(int nbr) {
		GlobalOil oil = new GlobalOil();
		for(int i=0; i < nbr ; i++) {
			int size = RandomValue.generateBoundedNumber(sizeValues[4][1], sizeValues[4][2]); //En Km²
			oil.addOilWell(size);
		}
		return oil;
	}
	
	public GlobalGoldMines globalGoldMinesCustomGenerator(int nbr) {
		GlobalGoldMines gm = new GlobalGoldMines();
		for(int i=0; i < nbr; i++) {
			int size = RandomValue.generateBoundedNumber(sizeValues[5][1], sizeValues[5][2]); //Profondeur en m
			gm.addGoldMine(size);
		}
		return gm;
	}
	
	public GlobalIronMines globalIronMinesCustomGenerator(int nbr) {
		GlobalIronMines im = new GlobalIronMines();
		for(int i=0; i < nbr ; i++) {
			int size = RandomValue.generateBoundedNumber(sizeValues[6][1], sizeValues[6][2]); //Profondeur en m
			im.addIronMine(size);
		}
		return im;
	}
	
	public GlobalCoalMines globalCoalMinesCustomGenerator(int nbr) {
		GlobalCoalMines cm = new GlobalCoalMines();
		for(int i=0; i < nbr ; i++) {
			int size = RandomValue.generateBoundedNumber(sizeValues[7][1], sizeValues[7][2]); //Profondeur en m
			cm.addCoalMine(size);
		}
		return cm;
	}

	public ArrayList<Integer> getIsItCustom() {
		return isItCustom;
	}

	public int[][] getSizeValues() {
		return sizeValues;
	}
	
}
package engine;

import calc.BoundedSizesCalculator;


import ressources.GlobalCoalMines;
import ressources.GlobalFields;
import ressources.GlobalForests;
import ressources.GlobalGoldMines;
import ressources.GlobalIronMines;
import ressources.GlobalLakes;
import ressources.GlobalOil;
import ressources.GlobalSuitableLands;

//Cette classe veut génerer toutes les ressources d'un pays de manière bornée à l'intérieur de tailles par défaut.
public class RessourcesBoundedAlgorithm {
	private int[][] sizeValues;
	private int[] sizeMinMax;

	
	public RessourcesBoundedAlgorithm(int[][] sizeValues) {
		this.sizeValues = sizeValues;
		sizeMinMax = new int[2];
	}
	
	/*.....Génération bornée des ressources.....*/
	public GlobalLakes globalBoundedLakesGenerator(int index) throws IndexOutOfBoundsException{
		sizeMinMax = BoundedSizesCalculator.bsCalc(index, sizeValues[0][0]);				//Calcul intervalle
		
		int nbLakes = RandomValue.generateBoundedNumber(sizeMinMax[0], sizeMinMax[1]);
		GlobalLakes lakes = new GlobalLakes();
		for(int i=0; i < nbLakes ; i++) {
			int size = RandomValue.generateBoundedNumber(sizeValues[0][1], sizeValues[0][2]); //En m^3 basé sur la taille du lac Léman (plus grand lac d'europe occidentale) 578.3Km²*309m
			lakes.addLake(size);
		}
		return lakes;
	}
	
	
	public GlobalSuitableLands globalBoundedSuitableLandsGenerator(int index) throws IndexOutOfBoundsException{
		sizeMinMax = BoundedSizesCalculator.bsCalc(index, sizeValues[1][0]);				//Calcul intervalle
		
		int nbSL = RandomValue.generateBoundedNumber(sizeMinMax[0], sizeMinMax[1]);
		GlobalSuitableLands sl = new GlobalSuitableLands();
		for(int i=0; i < nbSL ; i++) {
			int size = RandomValue.generateBoundedNumber(sizeValues[1][1], sizeValues[1][2]); //En Km²
			sl.addSuitableLand(size);
		}
		return sl;
	}
	
	public GlobalFields globalBoundedFieldsGenerator(int index) throws IndexOutOfBoundsException{
		sizeMinMax = BoundedSizesCalculator.bsCalc(index, sizeValues[2][0]);				//Calcul intervalle
		
		int nbFields = RandomValue.generateBoundedNumber(sizeMinMax[0], sizeMinMax[1]);
		GlobalFields fields = new GlobalFields();
		for(int i=0; i < nbFields ; i++) {
			int size = RandomValue.generateBoundedNumber(sizeValues[2][1], sizeValues[2][2]); //En hectares
			fields.addField(size);
		}
		return fields;
	}
	
	public GlobalForests globalBoundedForestsGenerator(int index) throws IndexOutOfBoundsException{
		sizeMinMax = BoundedSizesCalculator.bsCalc(index, sizeValues[3][0]);				//Calcul intervalle
		
		int nbForests = RandomValue.generateBoundedNumber(sizeMinMax[0], sizeMinMax[1]);
		GlobalForests forests = new GlobalForests();
		for(int i=0; i < nbForests ; i++) {
			int size = RandomValue.generateBoundedNumber(sizeValues[3][1], sizeValues[3][2]); //En Km²
			forests.addForest(size);
		}
		return forests;
	}
	
	public GlobalOil globalBoundedOilGenerator(int index) throws IndexOutOfBoundsException{
		sizeMinMax = BoundedSizesCalculator.bsCalc(index, sizeValues[4][0]);				//Calcul intervalle
		
		int nbOil = RandomValue.generateBoundedNumber(sizeMinMax[0], sizeMinMax[1]);
		GlobalOil oil = new GlobalOil();
		for(int i=0; i < nbOil ; i++) {
			int size = RandomValue.generateBoundedNumber(sizeValues[4][1], sizeValues[4][2]); //En Km²
			oil.addOilWell(size);
		}
		return oil;
	}
	
	public GlobalGoldMines globalBoundedGoldMinesGenerator(int index) throws IndexOutOfBoundsException{
		sizeMinMax = BoundedSizesCalculator.bsCalc(index, sizeValues[5][0]);				//Calcul intervalle
		
		int nbGM = RandomValue.generateBoundedNumber(sizeMinMax[0], sizeMinMax[1]);
		GlobalGoldMines gm = new GlobalGoldMines();
		for(int i=0; i < nbGM ; i++) {
			int size = RandomValue.generateBoundedNumber(sizeValues[5][1], sizeValues[5][2]); //Profondeur en m
			gm.addGoldMine(size);
		}
		return gm;
	}
	
	public GlobalIronMines globalBoundedIronMinesGenerator(int index) throws IndexOutOfBoundsException{
		sizeMinMax = BoundedSizesCalculator.bsCalc(index, sizeValues[6][0]);				//Calcul intervalle
		
		int nbIM = RandomValue.generateBoundedNumber(sizeMinMax[0], sizeMinMax[1]);
		GlobalIronMines im = new GlobalIronMines();
		for(int i=0; i < nbIM ; i++) {
			int size = RandomValue.generateBoundedNumber(sizeValues[6][1], sizeValues[6][2]); //Profondeur en m
			im.addIronMine(size);
		}
		return im;
	}
	
	public GlobalCoalMines globalBoundedCoalMinesGenerator(int index) throws IndexOutOfBoundsException{
		sizeMinMax = BoundedSizesCalculator.bsCalc(index, sizeValues[7][0]);				//Calcul intervalle
		
		int nbCM = RandomValue.generateBoundedNumber(sizeMinMax[0], sizeMinMax[1]);
		GlobalCoalMines cm = new GlobalCoalMines();
		for(int i=0; i < nbCM ; i++) {
			int size = RandomValue.generateBoundedNumber(sizeValues[7][1], sizeValues[7][2]); //Profondeur en m
			cm.addCoalMine(size);
		}
		return cm;
	}
	
}

package calc;

import economy.GDPValues;
import engine.RandomValue;

public class ReverseGDPcalculator {
	
	public static GDPValues reverseGDPCalc(int gdpRequired) {
		int consuption = RandomValue.generateBoundedNumber((gdpRequired/3)-(gdpRequired/7), (gdpRequired/3)+(gdpRequired/7));
		int investment = RandomValue.generateBoundedNumber((gdpRequired/3)-(gdpRequired/7), (gdpRequired/3)+(gdpRequired/7));
		int governmentSpending = gdpRequired - (consuption + investment);
		
		GDPValues gdpGenerated = new GDPValues(consuption, investment, governmentSpending);
		return gdpGenerated;
	}

}

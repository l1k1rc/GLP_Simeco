package calc;
import economy.PerCapitaIncome;
import economy.Education;
import java.lang.Math;

//ID = (realValue - minValue)/(maxValue - minValue)
//Formule de calcul pour chaque élement, à savoir: Espérence de vie, Education et Revenus par habitants 

public class HIDcalculator {
	static float indexLifeExpectancyMax = 83.4f;
	static float indexLifeExpectancyMin = 20.0f;
	
	static float indexAverageDurationOfSchoolingMax = 13.1f;
	static float indexAverageDurationOfSchoolingMin = 0;
	
	static float indexExpectationSchoolingDurationMax = 18.0f;
	static float indexExpectationSchoolingDurationMin = 0;
	static float combinedIndexOfEducation = 0.978f;
	
	static float indexPCIMax = 107721.0f; //124740.0f;
	static float indexPCIMin = 100.0f;
	
	public static double hidCalc(PerCapitaIncome pci, Education education, double lifeExpectancy) {
		double pciCalc = (Math.log(pci.getPerCapitaIncome())-Math.log(indexPCIMin))/(Math.log(indexPCIMax)-Math.log(indexPCIMin));
		//System.out.println(pciCalc);
		
		double schoolingDurationCalc = (education.getAverageDurationOfSchooling()-indexAverageDurationOfSchoolingMin)
				/(indexAverageDurationOfSchoolingMax-indexAverageDurationOfSchoolingMin);
		//System.out.println(schoolingDurationCalc);
		
		double schoolingExpectationCalc = (education.getExpectationSchoolingDuration()-indexExpectationSchoolingDurationMin)
				/(indexExpectationSchoolingDurationMax-indexExpectationSchoolingDurationMin);
		//System.out.println(schoolingExpectationCalc);

		double educationCalc = (Math.sqrt(schoolingDurationCalc*schoolingExpectationCalc)-indexAverageDurationOfSchoolingMin)
				/(combinedIndexOfEducation-indexAverageDurationOfSchoolingMin);
		//System.out.println(educationCalc);

		double lifeExpectancyCalc = (lifeExpectancy-indexLifeExpectancyMin)/(indexLifeExpectancyMax-indexLifeExpectancyMin);
		//System.out.println(lifeExpectancyCalc);

		double hid = Math.pow((pciCalc*educationCalc*lifeExpectancyCalc),(1.0/3));
		return hid;
	}

}

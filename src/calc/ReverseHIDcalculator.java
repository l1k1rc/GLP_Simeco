package calc;
import economy.HIDValues;
import engine.RandomValue;
public class ReverseHIDcalculator {
		static float indexLifeExpectancyMax = 83.4f;
		static float indexLifeExpectancyMin = 20.0f;
		
		static float indexAverageDurationOfSchoolingMax = 13.1f;
		static float indexAverageDurationOfSchoolingMin = 0;
		
		static float indexExpectationSchoolingDurationMax = 18.0f;
		static float indexExpectationSchoolingDurationMin = 0;
		static float combinedIndexOfEducation = 0.978f;
		
		static float indexPCIMax = 107721.0f; //124740.0f;
		static float indexPCIMin = 100.0f;
		
		public static HIDValues reverseHIDCalc(double hid, int gdp) {
			double[] values = new double[] {0.750, 0.666, (Math.pow(hid, 3))/(0.750*0.666)};
			
			//Random assign
			int index1 = RandomValue.generateNumber(3);
			double lifeExpectancy = indexLifeExpectancyMin+(values[index1]*(indexLifeExpectancyMax-indexLifeExpectancyMin)); //Reverse calc

			//Random assign n°2
			int index2;
			 do{
				 index2 =  RandomValue.generateNumber(3);
			 }while (index2 == index1);
			 double perCapitaIncome = Math.log(indexPCIMin)+(values[index2]*(Math.log(indexPCIMax)-Math.log(indexPCIMin))); //Reverse calc
			 perCapitaIncome = Math.exp(perCapitaIncome);
			 int income = gdp;
			 int population = (int) (income/perCapitaIncome);  //Determine population
		
			 //Last assign
			 int index3;
			 do{
				 index3 =  RandomValue.generateNumber(3);
			 }while ((index3 == index1) && (index3 == index2));
			 
			double schoolingInd = Math.pow((combinedIndexOfEducation*values[index3]),2);
			double averageSchoolingInd;
			double expectedSchoolingInd;
			//Expected Schooling is ever superior than average Schooling, below if will check that
			if (schoolingInd*2 > 0.5) {
				expectedSchoolingInd = schoolingInd*2 ;
				averageSchoolingInd = 0.5 ;
			}
			else {
				expectedSchoolingInd = 0.5 ;
				averageSchoolingInd = schoolingInd*2 ;
			}
			
			//Reverse calc
			double averageSchooling = averageSchoolingInd*indexAverageDurationOfSchoolingMax;
			double expectedSchooling = expectedSchoolingInd*indexExpectationSchoolingDurationMax;
			
			HIDValues hidGenerated = new HIDValues(income, population, averageSchooling, expectedSchooling, lifeExpectancy);
			return hidGenerated;
			
		}
}

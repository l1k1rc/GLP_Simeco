package engine;

import java.util.Random;

public class RandomValue {
	private static int value;
	
	public static int generateNumber(int maxValue) {
		Random r = new Random();
		value = r.nextInt(maxValue);
		return value;
	}
	
	public static int generateBoundedNumber(int minValue, int maxValue) {
		Random r = new Random();
		value = minValue + r.nextInt(maxValue - minValue);
		return value;
	}
	
	public static double generateDoubleBoundedNumber(double minValue, double maxValue) {
		Random r = new Random();
		double value = minValue + (maxValue - minValue) * r.nextDouble();

		return value;
	}
	
	public static double generatePercentageValue(int maxValue) {
		double percentage;
		int integ;
		int decimal;
		integ = RandomValue.generateNumber(maxValue);
		decimal = RandomValue.generateNumber(10);
		percentage = integ+(decimal*0.1);
		return percentage;
	}
	
	public static double generateBoundedPercentageValue(double minValue, double maxValue) {
		double percentage;
		double integ;
		int decimal;
		integ = generateDoubleBoundedNumber(minValue, maxValue);
		decimal = RandomValue.generateNumber(10);
		percentage = integ+(decimal*0.1);
		return percentage;
	}
	
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		RandomValue.value = value;
	}

	
	
}

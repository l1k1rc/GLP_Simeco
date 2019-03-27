package calc;

public class GDPcalculator {

	public static int gdpCalc(int consuption, int investment, int gs, int exports, int imports) {
		int gdp = consuption + investment + gs + (exports - imports);
		return gdp;
	}
	
}

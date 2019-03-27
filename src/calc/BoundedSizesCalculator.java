package calc;

//-1 = Very High | -2 = High | -3 Medium | -4 = Low | -5 = Very Low
public class BoundedSizesCalculator {

	public static int[] bsCalc(int index, int size) {
		int[] interval = new int[2];
		
		switch (index) {
			case -6:	interval[0] = (size/5)*4;
						interval[1] = (size/5)*5;
						break;
						
			case -7:	interval[0] = (size/5)*3;
						interval[1] = (size/5)*4;
						break;
						
			case -8: 	interval[0] = (size/5)*2;
						interval[1] = (size/5)*3;
						break;
						
			case -9:	interval[0] = (size/5)*1;
						interval[1] = (size/5)*2;
						break;
						
			case -10: 	interval[0] = (size/5)*0;
						interval[1] = (size/5)*1;
						break;
						
			default: 	throw new IndexOutOfBoundsException(index + " n'a pas de concordance");
		}
		return interval;
	}
	
	public static int[] bsCalcWithMin(int index, int[] sizeBound) {
		int[] interval = new int[2];
		int tempoMin = sizeBound[0];
		int size = sizeBound[1]-sizeBound[0];
		switch (index) {
			case -6:	interval[0] = (size/5)*4;
						interval[1] = (size/5)*5;
						break;
						
			case -7:	interval[0] = (size/5)*3;
						interval[1] = (size/5)*4;
						break;
						
			case -8: 	interval[0] = (size/5)*2;
						interval[1] = (size/5)*3;
						break;
						
			case -9:	interval[0] = (size/5)*1;
						interval[1] = (size/5)*2;
						break;
						
			case -10: 	interval[0] = (size/5)*0;
						interval[1] = (size/5)*1;
						break;
						
			default: 	throw new IndexOutOfBoundsException(index + " n'a pas de concordance");
		}
		interval[0] += tempoMin;
		interval[1] += tempoMin;
		return interval;
	}
}

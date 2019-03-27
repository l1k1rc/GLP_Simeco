package ihm.fontElements;

import java.awt.Color;
import java.awt.Font;

/**
 * Class which allows to regroup every fonts and colors in the program.
 * @author MATTHIEU
 *
 */
public class AllFont{

	private static Font f1=new Font("Arial rounded MT Bold", Font.PLAIN, 14);
	private static Font f2 = new Font("C", Font.PLAIN, 15);
    private static Font f3 = new Font("Verdana", Font.BOLD, 28);
    private static Font fMap=new Font("Times New Roman", Font.BOLD, 15);
    private static Font fMapCountries=new Font("Times New Roman", Font.BOLD, 18);
    private static Font fMenu = new Font("Times New Roman", Font.PLAIN, 25);
    
    private static Color ressource=new Color(111, 122, 235);
    private static Color politicalStatue=new Color(236, 180, 77);
    private static Color industrialFactors=new Color( 166, 42, 170);
    private static Color gdh=new Color(214, 57, 32 );
    private static Color hid=new Color( 92, 210, 197 );
    private static Color natalL=new Color( 124, 232, 82  );
    private static Color gini=new Color( 161, 92, 210 );
    private static Color research=new Color( 48, 107, 171 );
    private static Color soldier=new Color( 32, 149, 42  );
    private static Color mediumAge=new Color( 149, 97, 32 );
    private static Color unChom=new Color( 108, 70, 20 );
    private static Color powerMon=new Color( 228, 211, 89 );
    private static Color pop=new Color( 228, 89, 163);
    private static Color nTravel=new Color( 232, 143, 82 );
    
	public AllFont() {}
	
	public static Color getnTravel() {
		return nTravel;
	}

	public static Color getRessource() {
		return ressource;
	}

	public static Color getPoliticalStatue() {
		return politicalStatue;
	}

	public static Color getIndustrialFactors() {
		return industrialFactors;
	}

	public static Color getGdh() {
		return gdh;
	}

	public static Color getHid() {
		return hid;
	}

	public static Color getNatalL() {
		return natalL;
	}

	public static Color getGini() {
		return gini;
	}

	public static Color getResearch() {
		return research;
	}

	public static Color getSoldier() {
		return soldier;
	}

	public static Color getMediumAge() {
		return mediumAge;
	}

	public static Color getUnChom() {
		return unChom;
	}

	public static Color getPowerMon() {
		return powerMon;
	}

	public static Color getPop() {
		return pop;
	}

	public static Font getF1() {
		return f1;
	}
	public static Font getF2() {
		return f2;
	}
	public static Font getF3() {
		return f3;
	}
	public static Font getfMap() {
		return fMap;
	}
	public static Font getfMapCountries() {
		return fMapCountries;
	}
	public static Font getfMenu() {
		return fMenu;
	}
	
}

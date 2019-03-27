package ihm.graphChart;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import ihm.parametersWindow.Sorting;
 /**
  * Class which allows to build the PieChat graphics.
  * @author MATTHIEU
  *
  */
public class BuildChart extends ApplicationFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor which send the HashMap containing countries informations.
	 */
	public BuildChart(HashMap<String, int[]> globalPower) {
		super("");
		// TODO Auto-generated constructor stub
	      PieChart_AWT("Classement des puissances mondiales", globalPower);  
	      RefineryUtilities.centerFrameOnScreen( this );    
	}
		/**
		 * Allows to initialize the graphics ( here it's a pie ).
		 * @param windTitle : title of the window
		 * @param hmRanking : HashMap which contains N countries with their values in the "country ranking"
		 */
	   public void PieChart_AWT( String windTitle,HashMap<String, int[]> globalPower ) {                                  // 2
	      setContentPane(createDemoPanel( globalPower));
	   }
	   /**
	    * Process which allows to create the different values of the pie : that is to say, country's name and country's value
	    * @param hmRanking : HashMap which contains N countries with their values in the "country ranking"
	    * @return dataset
	    */
	   private static PieDataset createDataset(HashMap<String, int[]> globalPower) {                                 //5 
	      DefaultPieDataset dataset = new DefaultPieDataset( );
	      for(@SuppressWarnings("rawtypes") Map.Entry mapentry : globalPower.entrySet()) {
	    	  dataset.setValue(Sorting.getText().get(0), globalPower.get(mapentry.getKey())[0]);
	    	  dataset.setValue(Sorting.getText().get(1), globalPower.get(mapentry.getKey())[1]);
	    	  dataset.setValue(Sorting.getText().get(2), globalPower.get(mapentry.getKey())[2]);
	    	  dataset.setValue(Sorting.getText().get(3), globalPower.get(mapentry.getKey())[3]);
	    	  dataset.setValue(Sorting.getText().get(4), globalPower.get(mapentry.getKey())[4]);
	    	  dataset.setValue(Sorting.getText().get(5), globalPower.get(mapentry.getKey())[5]);
	    	  dataset.setValue(Sorting.getText().get(6), globalPower.get(mapentry.getKey())[6]);
	    	  dataset.setValue(Sorting.getText().get(7), globalPower.get(mapentry.getKey())[7]);
	    	  dataset.setValue(Sorting.getText().get(8), globalPower.get(mapentry.getKey())[8]);
	    	  dataset.setValue(Sorting.getText().get(9), globalPower.get(mapentry.getKey())[9]);
	      }
	      
	      return dataset;         
	   }
	   /**
	    * Initialize the JFreeChat window
	    * @param dataset : A PieDataset variable from JFreeChart package
	    * @see : JFreeChart
	    * @return chart 
	    */
	   private static JFreeChart createChart( PieDataset dataset ) {                                                 //4
	      JFreeChart chart = ChartFactory.createPieChart(      
	         "Classement des pays par puissance",   // chart title 
	         dataset,          // data    
	         true,             // include legend   
	         true, 
	         false);

	      return chart;
	   }
	   /**
	    * 
	    * @param hmRanking : HashMap which contains N countries with their values in the "country ranking"
	    * @return ChartPanel with the variable "chart" ( the panel associated )
	    */
	   public static JPanel createDemoPanel(HashMap<String, int[]> globalPower) {                                     // 3
	      JFreeChart chart = createChart(createDataset(globalPower) );  
	      return new ChartPanel( chart ); 
	   }

	}
  
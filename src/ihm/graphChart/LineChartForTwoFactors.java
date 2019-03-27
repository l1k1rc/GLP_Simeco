package ihm.graphChart;

import org.jfree.chart.ChartPanel;

import java.util.HashMap;
import java.util.Map;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.chart.plot.PlotOrientation;
/**
 * Class which allows to build a LineChart graphics.
 * @author MATTHIEU
 *
 */
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
public class LineChartForTwoFactors extends ApplicationFrame {

	private static final long serialVersionUID = 1L;
	/**
	 * Allows to send the parameters.
	 * Create a graph with two curved lines.
	 * @param factor : economical factors for the graphics title
	 * @param time : time of the evolution
	 */
	public LineChartForTwoFactors(HashMap<String,double[]> hmValues, int whichOne, int whichOther,String one, String other,String factor) {  //1
		super("R");
		XYDataset dataset = createDataset(hmValues,whichOne,whichOther,one,other);
		JFreeChart chart = createChart(dataset,factor);
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
		setContentPane(chartPanel);

	}
	/**
	 * Add the different values to the graph.
	 * @param hmValues : HashMap which contains the valeus
	 * @param whichOne : which value to send
	 * @param whichOther : which value to send
	 * @param one : name of the first value
	 * @param other : name of the second value
	 * @return
	 */
	private XYDataset createDataset(HashMap<String, double[]> hmValues,int whichOne,int whichOther,String one,String other) {

		XYSeries series1 = new XYSeries(one);
		for(@SuppressWarnings("rawtypes") Map.Entry mapentry : hmValues.entrySet()) {
			series1.add(Integer.parseInt(mapentry.getKey().toString()), hmValues.get(mapentry.getKey())[whichOne]);
		}

		XYSeries series2 = new XYSeries(other);
		for(@SuppressWarnings("rawtypes") Map.Entry mapentry : hmValues.entrySet()) {
			series2.add(Integer.parseInt(mapentry.getKey().toString()), hmValues.get(mapentry.getKey())[whichOther]);
		}

		

		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series1);
		dataset.addSeries(series2);


		return dataset;

	}
/**
 * Parameters for the graph.
 * @param dataset : graph selected
 * @param factor : name of the graph 
 * @return
 */
	private JFreeChart createChart(XYDataset dataset,String factor) {
		return ChartFactory.createXYLineChart(factor, "Temps (année)", "Valeurs (u)", dataset, PlotOrientation.VERTICAL, true, true, false);
	}

}

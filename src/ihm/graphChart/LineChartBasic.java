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
public class LineChartBasic extends ApplicationFrame {

	private static final long serialVersionUID = 1L;
	/**
	 * Allows to send the parameters.
	 * Create a graph with one curved line.
	 * @param factor : economical factors for the graphics title
	 * @param time : time of the evolution
	 */
	public LineChartBasic(HashMap<String,double[]> hmValues, int whichOne,String name,String factor) {  //1
		super("R");
		XYDataset dataset = createDataset(hmValues,whichOne,name);
		JFreeChart chart = createChart(dataset,factor);
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
		setContentPane(chartPanel);

	}
	/**
	 * Add the different values to the graph.
	 * @param hmValues : HashMap which contains the values
	 * @param whichOne : Which parameter
	 * @param name : name of the parameter
	 * @return : the graph
	 */
	private XYDataset createDataset(HashMap<String, double[]> hmValues,int whichOne,String name) {

		XYSeries series1 = new XYSeries(name);
		for(@SuppressWarnings("rawtypes") Map.Entry mapentry : hmValues.entrySet()) {
			series1.add(Integer.parseInt(mapentry.getKey().toString()), hmValues.get(mapentry.getKey())[whichOne]);
		}

		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series1);


		return dataset;

	}

	private JFreeChart createChart(XYDataset dataset,String factor) {
		return ChartFactory.createXYLineChart(factor, "Temps (année)", "Valeurs (u)", dataset, PlotOrientation.VERTICAL, true, true, false);
	}

}


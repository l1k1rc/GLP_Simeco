package ihm.graphChart;
import org.jfree.chart.ChartPanel;

import java.util.HashMap;
import java.util.Map;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.chart.plot.PlotOrientation;
/*
 * Class which allows to build a LineChart graphics.
 * @author MATTHIEU
 *
 */
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
public class LineChartRessources extends ApplicationFrame {

	private static final long serialVersionUID = 1L;
	/**
	 * Allows to send the parameters.
	 * Create a graph with 8 curved line for each industry.
	 * @param factor : economical factors for the graphics title
	 * @param time : time of the evolution
	 */
	public LineChartRessources(HashMap<String,double[]> hmValues) {  //1
		super("Ressources");
		XYDataset dataset = createDataset(hmValues);
		JFreeChart chart = createChart(dataset);
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
		setContentPane(chartPanel);

	}
	/**
	 * Add the different values to the graph.
	 * @param hmValues : which contains each values
	 * @return
	 */
	private XYDataset createDataset(HashMap<String, double[]> hmValues) {

		XYSeries series1 = new XYSeries("Lac");
		for(@SuppressWarnings("rawtypes") Map.Entry mapentry : hmValues.entrySet()) {
			series1.add(Integer.parseInt(mapentry.getKey().toString()), hmValues.get(mapentry.getKey())[0]);
		}

		XYSeries series2 = new XYSeries("Terre exploitable");
		for(@SuppressWarnings("rawtypes") Map.Entry mapentry : hmValues.entrySet()) {
			series2.add(Integer.parseInt(mapentry.getKey().toString()), hmValues.get(mapentry.getKey())[1]);
		}

		XYSeries series3 = new XYSeries("Champs");
		for(@SuppressWarnings("rawtypes") Map.Entry mapentry : hmValues.entrySet()) {
			series3.add(Integer.parseInt(mapentry.getKey().toString()), hmValues.get(mapentry.getKey())[2]);
		}
		XYSeries series4 = new XYSeries("Forêt");
		for(@SuppressWarnings("rawtypes") Map.Entry mapentry : hmValues.entrySet()) {
			series4.add(Integer.parseInt(mapentry.getKey().toString()), hmValues.get(mapentry.getKey())[3]);
		}
		XYSeries series5 = new XYSeries("Puit pétrolier");
		for(@SuppressWarnings("rawtypes") Map.Entry mapentry : hmValues.entrySet()) {
			series5.add(Integer.parseInt(mapentry.getKey().toString()), hmValues.get(mapentry.getKey())[4]);
		}
		XYSeries series6 = new XYSeries("Or");
		for(@SuppressWarnings("rawtypes") Map.Entry mapentry : hmValues.entrySet()) {
			series6.add(Integer.parseInt(mapentry.getKey().toString()), hmValues.get(mapentry.getKey())[5]);
		}
		XYSeries series7 = new XYSeries("Fer");
		for(@SuppressWarnings("rawtypes") Map.Entry mapentry : hmValues.entrySet()) {
			series7.add(Integer.parseInt(mapentry.getKey().toString()), hmValues.get(mapentry.getKey())[6]);
		}
		XYSeries series8 = new XYSeries("Charbon");
		for(@SuppressWarnings("rawtypes") Map.Entry mapentry : hmValues.entrySet()) {
			series8.add(Integer.parseInt(mapentry.getKey().toString()), hmValues.get(mapentry.getKey())[7]);
		}

		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series1);
		dataset.addSeries(series2);
		dataset.addSeries(series3);
		dataset.addSeries(series4);
		dataset.addSeries(series5);
		dataset.addSeries(series6);
		dataset.addSeries(series7);
		dataset.addSeries(series8);

		return dataset;

	}
	/**
	 * Parameters for the graph.
	 * @param dataset : graph to send
	 * @return
	 */
	private JFreeChart createChart(XYDataset dataset) {
		return ChartFactory.createXYLineChart("Ressources", "Temps (année)", "Valeurs (u)", dataset, PlotOrientation.VERTICAL, true, true, false);
	}

}

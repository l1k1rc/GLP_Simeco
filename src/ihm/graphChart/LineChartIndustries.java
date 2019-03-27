package ihm.graphChart;

import java.util.HashMap;
import java.util.Map;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;

public class LineChartIndustries extends ApplicationFrame {

	private static final long serialVersionUID = 1L;
	/**
	 * Create a graph with 8 curved line for each industry.
	 */
	public LineChartIndustries(HashMap<String, double[]> hmValues) {
		super("Industries");
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

		XYSeries series1 = new XYSeries("Poisson");
		for(@SuppressWarnings("rawtypes") Map.Entry mapentry : hmValues.entrySet()) {
			series1.add(Integer.parseInt(mapentry.getKey().toString()), hmValues.get(mapentry.getKey())[8]);
		}

		XYSeries series2 = new XYSeries("Animale");
		for(@SuppressWarnings("rawtypes") Map.Entry mapentry : hmValues.entrySet()) {
			series2.add(Integer.parseInt(mapentry.getKey().toString()), hmValues.get(mapentry.getKey())[9]);
		}

		XYSeries series3 = new XYSeries("Ferme");
		for(@SuppressWarnings("rawtypes") Map.Entry mapentry : hmValues.entrySet()) {
			series3.add(Integer.parseInt(mapentry.getKey().toString()), hmValues.get(mapentry.getKey())[10]);
		}
		XYSeries series4 = new XYSeries("Fer");
		for(@SuppressWarnings("rawtypes") Map.Entry mapentry : hmValues.entrySet()) {
			series4.add(Integer.parseInt(mapentry.getKey().toString()), hmValues.get(mapentry.getKey())[11]);
		}
		XYSeries series5 = new XYSeries("Or");
		for(@SuppressWarnings("rawtypes") Map.Entry mapentry : hmValues.entrySet()) {
			series5.add(Integer.parseInt(mapentry.getKey().toString()), hmValues.get(mapentry.getKey())[12]);
		}
		XYSeries series6 = new XYSeries("Charbon");
		for(@SuppressWarnings("rawtypes") Map.Entry mapentry : hmValues.entrySet()) {
			series6.add(Integer.parseInt(mapentry.getKey().toString()), hmValues.get(mapentry.getKey())[13]);
		}
		XYSeries series7 = new XYSeries("Bois");
		for(@SuppressWarnings("rawtypes") Map.Entry mapentry : hmValues.entrySet()) {
			series7.add(Integer.parseInt(mapentry.getKey().toString()), hmValues.get(mapentry.getKey())[14]);
		}
		XYSeries series8 = new XYSeries("Pétrolière");
		for(@SuppressWarnings("rawtypes") Map.Entry mapentry : hmValues.entrySet()) {
			series8.add(Integer.parseInt(mapentry.getKey().toString()), hmValues.get(mapentry.getKey())[15]);
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
	 * Parameters for graph.
	 * @param dataset : graph to send
	 * @return
	 */
	private JFreeChart createChart(XYDataset dataset) {
		return ChartFactory.createXYLineChart("Industries", "Temps (année)", "Valeurs (%)", dataset, PlotOrientation.VERTICAL, true, true, false);
	}

}
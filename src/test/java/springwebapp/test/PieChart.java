package springwebapp.test;

import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class PieChart {
	public static void chart(int pass, int fail, int skip) {
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("Pass", pass);
		dataset.setValue("Fail", fail);
		dataset.setValue("Skip", skip);

		JFreeChart chart = ChartFactory.createPieChart("Report Generate", // chart
																			// title
				dataset, // data
				true, // include legend
				true, false);

		int width = 640; /* Width of the image */
		int height = 480; /* Height of the image */
		File pieChart = new File("PieChart.jpeg");
		try {
			ChartUtilities.saveChartAsJPEG(pieChart, chart, width, height);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
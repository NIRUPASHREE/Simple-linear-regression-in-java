package niru;
import java.awt.Color;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 * A simple demonstration application showing how to create a line chart using data from an
 * {@link XYDataset}.
 *
 */

public class lineChart extends JPanel{

    /**
     * Creates a new demo.
     *
     * @param title  the frame title.
     */
    public lineChart() {
        String title="Scatterplot: Performace with IQ";
        final XYDataset dataset = createDataset();
        final JFreeChart chart = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(600, 370));
        add(chartPanel);
	   
    }
    
    /**
     * Creates a sample dataset.
     * 
     * @return a sample dataset.
     */
    private XYDataset createDataset() {
        
        final XYSeries series1 = new XYSeries("Scatter-Plot");
        series1.add(106.0, 115.0);
        series1.add(97.0, 104.0);
        series1.add(108.0, 98.0);
        series1.add(96.0, 101.0);
        series1.add(112.0, 98.0);
        series1.add(111.0, 106.0);
        series1.add(97.0, 95.0);
        series1.add(99.0, 98.0);
        series1.add(87.0, 87.0);
        series1.add(91.0, 86.0);
        
        final XYSeries series2 = new XYSeries("line");
        series2.add(106.0,( 106*0.64)+34.26 );
        series2.add(97.0, ( 97*0.64)+34.26 );
        series2.add(108.0,( 108*0.64)+34.26 );
        series2.add(96.0, ( 96*0.64)+34.26 );
        series2.add(112.0,( 112*0.64)+34.26 );
        series2.add(111.0,( 111*0.64)+34.26 );
        series2.add(97.0, ( 97*0.64)+34.26 );
        series2.add(99.0, ( 99*0.64)+34.26 );
        series2.add(87.0, ( 87*0.64)+34.26 );
        series2.add(91.0, ( 91*0.64)+34.26 );


        final XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series1);
        dataset.addSeries(series2);
        return dataset;
        
    }
    
    /**
     * Creates a chart.
     * 
     * @param dataset  the data for the chart.
     * 
     * @return a chart.
     */
    private JFreeChart createChart(final XYDataset dataset) {
        
        // create the chart...
        final JFreeChart chart = ChartFactory.createXYLineChart(
            "JOB PERFORMANCE BY IQ 		 EMPLOYESS|N=10",      // chart title
            "IQ test score",                      // x axis label
            "Job performance test-score",                      // y axis label
            dataset,                  // data
            PlotOrientation.VERTICAL,
            true,                     // include legend
            true,                     // tooltips
            false                     // urls
        );

        // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...
        chart.setBackgroundPaint(Color.white);

//        final StandardLegend legend = (StandardLegend) chart.getLegend();
  //      legend.setDisplaySeriesShapes(true);
        
        // get a reference to the plot for further customisation...
        final XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.lightGray);
    //    plot.setAxisOffset(new Spacer(Spacer.ABSOLUTE, 5.0, 5.0, 5.0, 5.0));
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);
        
        final XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesLinesVisible(0, false);
        renderer.setSeriesShapesVisible(1, false);
        plot.setRenderer(renderer);

        // change the auto tick unit selection to integer units only...
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        // OPTIONAL CUSTOMISATION COMPLETED.
                
        return chart;
        
    }
}

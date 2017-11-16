package com.application;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import com.model.BinomialDistribution;
import com.model.DefaultGenerator;
import com.model.Evaluator;
import com.model.IGenerator;
import com.model.LCGenerator;
import com.model.MiddleSquare;
import com.model.PoissonDistribution;


public class Application extends JFrame {
	IGenerator middleSquare ;
	IGenerator lCG ;
	IGenerator defaultGenerator;
	Evaluator evaluate;
	IGenerator poisson ;
	IGenerator binomial;
	List<Double> generatedNumbers;
	
	 public Application() {
		 generatedNumbers = new ArrayList<>();
		 middleSquare = new MiddleSquare(4793);
		 lCG = new LCGenerator(19, 22,4, 563);
		defaultGenerator = new DefaultGenerator(6785);
		evaluate = new Evaluator(defaultGenerator, 20000);
		poisson = new PoissonDistribution(defaultGenerator, 200, 78);
		 binomial = new BinomialDistribution(defaultGenerator, 10000, 0.2);
		 for(int i = 0; i < 100;i++) {
			generatedNumbers.add(binomial.next());
		 }
	     initUI();
	    }

	    private void initUI() {

	        XYDataset dataset = createDataset();
	        JFreeChart chart = createChart(dataset);
	        ChartPanel chartPanel = new ChartPanel(chart);
	        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
	        chartPanel.setBackground(Color.white);
	        add(chartPanel);

	        pack();
	        setTitle("Distribution");
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    }

	    private XYDataset createDataset() {

	        XYSeries series = new XYSeries("2017");
	        series.add(0.1, numbersInInterval(0, 0.1));
	        series.add(0.2, numbersInInterval(0.1, 0.2));
	        series.add(0.3, numbersInInterval(0.2, 0.3));
	        series.add(0.4, numbersInInterval(0.3, 0.4));
	        series.add(0.5, numbersInInterval(0.4, 0.5));
	        series.add(0.6, numbersInInterval(0.5, 0.6));
	        series.add(0.7, numbersInInterval(0.6, 0.7));
	        series.add(0.8,numbersInInterval(0.7, 0.8));
	        series.add(0.9,numbersInInterval(0.8, 0.9));
	        
	        XYSeriesCollection dataset = new XYSeriesCollection();
	        dataset.addSeries(series);

	        return dataset;
	    }

	    private JFreeChart createChart(XYDataset dataset) {

	        JFreeChart chart = ChartFactory.createXYLineChart(
	                "Average distribution per subinterval", 
	                "Subinterval", 
	                "Numbers per interval", 
	                dataset, 
	                PlotOrientation.VERTICAL,
	                true, 
	                true, 
	                false 
	        );

	        XYPlot plot = chart.getXYPlot();

	        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
	        renderer.setSeriesPaint(0, Color.RED);
	        renderer.setSeriesStroke(0, new BasicStroke(2.0f));

	        plot.setRenderer(renderer);
	        plot.setBackgroundPaint(Color.white);

	        plot.setRangeGridlinesVisible(true);
	        plot.setRangeGridlinePaint(Color.BLACK);

	        plot.setDomainGridlinesVisible(true);
	        plot.setDomainGridlinePaint(Color.BLACK);

	        chart.getLegend().setFrame(BlockBorder.NONE);

	        chart.setTitle(new TextTitle("Average distribution per subinterval",
	                        new Font("Serif", java.awt.Font.BOLD, 18)
	                )
	        );

	        return chart;

	    }
		
	public static void main(String[] args) {
		/*IGenerator middleSquare = new MiddleSquare(4793);
		IGenerator lCG = new LCGenerator(19, 22,4, 563);
		IGenerator defaultGenerator = new DefaultGenerator(678);
		Evaluator evaluate = new Evaluator(defaultGenerator, 20000);
		IGenerator poisson = new PoissonDistribution(defaultGenerator, 100, 23);
		IGenerator binomial = new BinomialDistribution(defaultGenerator, 50, 0.4);*/
		/*for(int i = 0;i<20000;i++) {
			System.out.println("Result MiddleSquaare:" + middleSquare.next());
			
		}*/
		
		/*for(int i = 0;i<20000;i++) {
			System.out.println("Result default :" + defaultGenerator.next());
			
		}*/
		
		
		SwingUtilities.invokeLater(() -> {
			Application ex = new Application();
            ex.setVisible(true);
        });
		
	}
	
	public int numbersInInterval(double a, double b) {
		int contor = 0;
		for (Double double1 : generatedNumbers) {
			if((a <= double1) && (double1 < b)) {
				contor++;
				
			} 
		}
		System.out.println(contor);
		return contor;
	}
}

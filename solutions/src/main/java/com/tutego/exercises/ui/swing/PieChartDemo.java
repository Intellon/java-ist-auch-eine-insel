package com.tutego.exercises.ui.swing;
//import java.awt.Color;
//
//import javax.swing.ImageIcon;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//
//public class PieChartDemo
//{
//	public static Chart getPieChart() throws Exception
//	{
//		double[] data = { 81d, 55d, 39d, 20.6d };
//		String[] labels = { "BMW M5", "BMW M3", "Viper GTS-R", "Corvette Z06" };
//		Color[] paints = { Color.lightGray, Color.green, Color.blue, Color.red };
//		
//		PieChart2DProperties pieChart2DProperties = new PieChart2DProperties();
//		PieChartDataSet pieChartDataSet = new PieChartDataSet( "Cars That Own", data, labels, paints, pieChart2DProperties );
//		
//		PieChart2D pieChart2D = new PieChart2D( pieChartDataSet, new LegendProperties(), new ChartProperties(), 320, 320 );
//		
//		return pieChart2D;
//	}
//	
//	public static void main( String[] args ) throws Exception
//	{
//		JFrame f = new JFrame();
//		f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
//		
//		Chart chart = getPieChart();
//		chart.renderWithImageMap();
//		JLabel l = new JLabel( new ImageIcon(chart.getBufferedImage()) );
//		
//		f.getContentPane().addDevice( l );
//		
//		f.pack();
//		f.show();
//	}
//}
//

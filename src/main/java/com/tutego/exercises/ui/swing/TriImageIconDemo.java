package com.tutego.exercises.ui.swing;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class TriImageIconDemo
{
	public static void main( String[] args ) throws MalformedURLException
	{
		JFrame f = new JFrame();
		URL url = new URL( "http://people.ucsc.edu/~ddiep/homer.gif" );
		f.add( new JLabel(new TriImageIcon(url)) );
		f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		f.pack();
		f.setVisible( true );
	}
}

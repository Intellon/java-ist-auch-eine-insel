package com.tutego.exercises.ui.swing;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.Timer;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class BlinkKlammer extends JFrame
{
  private static final long serialVersionUID = -166608028092644493L;

  static MutableAttributeSet attr = new SimpleAttributeSet();
	static boolean toggle = false;
	
  public static void main( String[] args ) throws Exception
  {
		JFrame f = new JFrame();
		f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		JTextPane textpane = new JTextPane();
		final DefaultStyledDocument doc = new DefaultStyledDocument();
		textpane.setDocument( doc );
		
		doc.insertString( doc.getLength(), "Hier wird gleich was ge�ndert.", attr );
		
		new Timer( 1000, e -> {
    	StyleConstants.setBold( attr, toggle ^= true );
    	doc.setCharacterAttributes( 1, 20, attr, false);
    }).start();

		f.getContentPane().add( new JScrollPane( textpane ) );
		f.setSize( 200, 100 );

		f.setVisible( true );
  }
}

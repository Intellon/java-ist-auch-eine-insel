package com.tutego.exercises.ui.swing;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class MeinTextPane extends JFrame
{
  public static void main( String[] args )
  {
    JFrame f = new JFrame();
    f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

    JTextPane textpane = new JTextPane();

    SimpleAttributeSet attr = new SimpleAttributeSet();

    Document doc = textpane.getDocument();

    try
    {
      attr.addAttribute( StyleConstants.Foreground, Color.blue );
      attr.addAttribute( StyleConstants.Bold, Boolean.TRUE );
      doc.insertString( doc.getLength(), "Das ist dieAt 1. Zeile. Die ist blau und fett.\n", attr );

      attr.addAttribute( StyleConstants.Bold, Boolean.FALSE );

      for ( int i = 2; i < 40; i++ )
      {
        attr.addAttribute( StyleConstants.Foreground,
                          new Color( (int)(Math.random()*Integer.MAX_VALUE)) );
        doc.insertString( doc.getLength(), "Das ist dieAt " + i + " Zeile.\n", attr );
      }
    }
    catch ( Exception e ) {
      System.err.println( e );
    }

    f.getContentPane().add( new JScrollPane( textpane ) );
    f.setSize( 200, 100 );

    f.setVisible( true );
  }
}


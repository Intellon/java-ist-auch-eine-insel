package com.tutego.exercises.ui.swing;

import java.awt.GridLayout;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.UIManager;

@SuppressWarnings("all")
public class MacOSLaF
{
  public static void main( String[] args )
  {
    JFrame f = new JFrame();

    try
    {
      // UIManager.setLookAndFeel("net.sourceforge.mlf.metouia.MetouiaLookAndFeel");
      UIManager.setLookAndFeel( "com.stefankrause.xplookandfeel.XPLookAndFeel" );
    }
    catch ( Exception e )
    {
      System.err.println( "Error loading L&F: " + e );
    }

    JMenuBar mb = new JMenuBar();
    JMenu jmi = new JMenu( "MenuItem" );
    mb.add( jmi );
    jmi.add( new JMenuItem( "Item1" ) );
    jmi.add( new JMenuItem( "Item2" ) );
    f.setJMenuBar( mb );

    f.getContentPane().setLayout( new GridLayout( 3, 3 ) );

    f.getContentPane().add( new JButton( "Hallo" ) );
    f.getContentPane().add( new JLabel( "Label" ) );
    f.getContentPane().add( new JTextField( "JTextField" ) );
    f.getContentPane().add( new JSlider() );
    f.getContentPane().add( new JPanel() { {
        add( new JScrollBar( JScrollBar.HORIZONTAL ) );
      } } );
    f.getContentPane().add( new JCheckBox() );
    f.getContentPane().add( new JScrollPane( new JList( Locale
                                .getAvailableLocales() ) ) );
    f.getContentPane().add( new JRadioButton( "RadioButton" ) );
    f.getContentPane().add( new JTree() );

    f.setSize( 200, 300 );
    f.setVisible( true );

    f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
  }
}
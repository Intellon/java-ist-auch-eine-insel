package com.tutego.exercises.ui.swing;

import java.io.File;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

public class ListDemo {

  public static JList<File> liste( String path ) {
    File file = new File( path );
    File[] files = file.listFiles();

    return new JList<>( files );
  }

  public static void main( String[] args ) {
    try {
      UIManager.setLookAndFeel( "com.sun.java.swing.plaf.windows.WindowsLookAndFeel" );
    }
    catch ( Exception ex ) {
      System.out.println( ex );
    }

    JFrame f = new JFrame();
    f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    JScrollPane scrollpane = new JScrollPane( liste( "C:/" ) );

    f.getContentPane().add( scrollpane );
    f.pack();
    f.setVisible( true );
  }
}
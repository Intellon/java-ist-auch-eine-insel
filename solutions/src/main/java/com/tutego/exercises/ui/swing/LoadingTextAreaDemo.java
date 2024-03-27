package com.tutego.exercises.ui.swing;

import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class LoadingTextAreaDemo {

  public static void main( String[] args ) {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    JTextArea ta = new LoadingTextArea( "C:/test.txt" );
    frame.getContentPane().add( new JScrollPane( ta ) );
    frame.pack();
    frame.setVisible( true );
  }
}

class LoadingTextArea extends JTextArea {

  public LoadingTextArea( String filename ) {
    try ( FileReader r = new FileReader( filename ) ) {
      read( r, null );
    }
    catch ( IOException e ) {
      e.printStackTrace();
    }
  }
}
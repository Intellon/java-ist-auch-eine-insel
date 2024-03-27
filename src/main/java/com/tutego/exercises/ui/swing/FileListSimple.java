package com.tutego.exercises.ui.swing;

import java.io.File;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class FileListSimple extends JFrame {
  private static final long serialVersionUID = -5825179736639276129L;

  private JList<File> list;

  public FileListSimple() {
    list = new JList<>( new File( "c:/" ).listFiles() );

    getContentPane().add( new JScrollPane( list ) );
  }

  public static void main( String[] args ) {
    JFrame f = new FileListSimple();
    f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    f.pack();
    f.setVisible( true );
  }
}
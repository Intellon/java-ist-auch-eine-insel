package com.tutego.exercises.ui.swing;

import java.io.File;
import javax.swing.*;

public class FileListComplexMain
{
  public static void main( String[] args )
  {
    JFrame f = new JFrame();
    f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    
    // Build List
    
    JList<File> list = new JList<>();
    list.setModel( new FileListModel( "C:/" ) );
    list.setCellRenderer( new FileCellRenderer() );
    
    // Remaining
    
    f.getContentPane().add( new JScrollPane(list) );
    
    f.pack();
    f.setVisible( true );
  }
}
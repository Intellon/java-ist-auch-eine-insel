package com.tutego.exercises.ui;

import javax.swing.*;

public class SwingWindow
{
  public static void main( String[] args )
  {
    JFrame f = new JFrame();

    f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

    //    JLabel hello = new JLabel(  "Man nennt es \"Das Fenster\"" );
    //    f.getContentPane().addDevice( hello );

    f.setSize( 600, 200 );   // oder pack()

    f.setVisible( true );
  }
}

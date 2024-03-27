package com.tutego.exercises.ui.swing;

import javax.swing.JFrame;

public class CalendarFrame extends JFrame {
  private static final long serialVersionUID = -3808931234569376228L;

  public static void main( String[] args ) {
    JFrame f = new JFrame();
    f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

    f.getContentPane().add( new SwingCalendar( 8, 2002 ) );
    f.pack();
    f.setVisible( true );
  }
}

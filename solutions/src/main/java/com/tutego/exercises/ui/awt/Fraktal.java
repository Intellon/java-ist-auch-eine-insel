package com.tutego.exercises.ui.awt;

import java.awt.*;
import java.awt.event.*;

public class Fraktal extends Frame {

  private static final long serialVersionUID = 4374842040917695258L;

  public Fraktal() {
    super( "Grafik mit Ulli" );
    setSize( 400, 300 );
    setVisible( true );

    addWindowListener( new WindowAdapter() {
      @Override
      public void windowClosing( WindowEvent e ) {
        System.exit( 0 );
      }
    } );
  }

  static void drawPoint( Graphics g, int x, int y ) {
    g.drawLine( x, y, x, y );
  }

  @Override
  public void paint( Graphics g ) {
    double x = 1, y = 1;

    for ( int i = 0; i < 50000; i++ ) {
      drawPoint( g, (int) (x * 200) + 10, (int) (y * 200) + 50 );

      double z = Math.random();

      if ( z < 0.333 ) {
        x = x / 2;
        y = y / 2;
      }
      else if ( z < 0.666 ) {
        x = (1 + x) / 2;
        y = (1 + y) / 2;
      }
      else {
        x = (1 + x) / 2;
        y = y / 2;
      }
    }
  }

  public static void main( String[] args ) {
    new Fraktal();
  }
}
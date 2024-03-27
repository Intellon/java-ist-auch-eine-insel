package com.tutego.exercises.lang;

import java.awt.*;

public class Distance {

  //tag::solution[]
  static double dist( Point p ) {
    return Math.sqrt( p.x * p.x + p.y * p.y );
  }

  static void abs( Point p ) {
    p.x = Math.abs( p.x );
    p.y = Math.abs( p.y );
  }

  public static void main( String[] args ) {
    Point punkt = new Point( 5, 5 );

    System.out.println( "x-Koordinate: " + punkt.x );
    System.out.println( "y-Koordinate: " + punkt.y );
    System.out.println( "Abstand vom Koordinatenursprung: " + dist( punkt ) );

    Point p = new Point( -2, 2 );
    System.out.println( p.toString() ); // -2,2
    abs( p );
    System.out.println( p.toString() ); // 2,2
  }
  //end::solution[]
}

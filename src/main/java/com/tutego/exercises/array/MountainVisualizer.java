package com.tutego.exercises.array;

public class MountainVisualizer {

  //tag::solution[]
  private static String mountainChar() { return "*"; }

  public static void visualizeMountain( int[] altitudes ) {

    int maxAltitude = altitudes[ 0 ];

    for ( int i = 0; i < altitudes.length; i++ )
      if ( altitudes[ i ] > maxAltitude )
        maxAltitude = altitudes[ i ];

    for ( int height = maxAltitude; height >= 0; height-- ) {
      System.out.print( height + " " );
      for ( int altitude : altitudes )
        System.out.print( altitude == height ? mountainChar() : ' ' );
      System.out.println();
    }
  }
  //end::solution[]

  public static void main( String[] args ) {
    int[] mountain = { 0, 1, 1, 2, 2, 3, 3, 3, 4, 5, 4, 3, 2, 2, 1, 0 };
    visualizeMountain( mountain );
  }
}

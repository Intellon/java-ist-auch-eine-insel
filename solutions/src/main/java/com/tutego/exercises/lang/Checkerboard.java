package com.tutego.exercises.lang;

public class Checkerboard {

  public static void main( String[] args ) {
    //tag::solution[]
    System.out.print( "Schachbrettbreite: " );
    int width = new java.util.Scanner( System.in ).nextInt();

    System.out.print( "Schachbretthöhe: " );
    int height = new java.util.Scanner( System.in ).nextInt();

    for ( int y = 0; y < height; y++ ) {
      for ( int x = 0; x < width; x++ )
        System.out.print( (x + y) % 2 == 1 ? '#' : ' ' );
      System.out.println();
    }
    //end::solution[]

    System.out.println();

    // Alternative mit Array für die At Zeichen
    char[] chars = { ' ', '#' };
    for ( int y = 0; y < height; y++ ) {
      for ( int x = 0; x < width; x++ )
        System.out.print( chars[ (x + y) % 2 ] );
      System.out.println();
    }
  }
}
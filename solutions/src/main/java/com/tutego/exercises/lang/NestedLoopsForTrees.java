package com.tutego.exercises.lang;

public class NestedLoopsForTrees {

  public static void main( String[] args ) {
    //tag::solution[]

    final int MAX = 5;

    // Normale Ausgabe
    for ( int i = 1; i <= MAX; i++ ) {
      for ( int j = 1; j <= i; j++ )
        System.out.print( i );

      System.out.println();
    }
    System.out.println();

    // Zentrierte Ausgabe
    for ( int i = 1; i <= MAX; i++ ) {
      for ( int indent = 0; indent < (MAX - i); indent++ )
        System.out.print( " " );

      for ( int j = 1; j <= i; j++ )
        System.out.print( i + " " );

      System.out.println();
    }
    //end::solution[]
  }
}
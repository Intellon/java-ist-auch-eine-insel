package com.tutego.exercises.os;

import java.util.Arrays;

public class SortCommandlineArguments {
  //tag::solution[]
  public static void main( String[] args ) {

    if ( args.length == 0 ) {
      System.out.println( "Keine Parameter, keine Sortierung" );
      return;
    }

    int[] numbers = new int[ args.length ];

    // Convert args to numbers
    for ( int i = 0; i < args.length; i++ )
      numbers[ i ] = Integer.parseInt( args[ i ] );

    Arrays.sort( numbers );

    System.out.print( "Sortiere Elemente: " );
    System.out.println( Arrays.toString( numbers ) );

    System.out.printf( "%nKleinstes Element: %d%n", numbers[ 0 ] );
    System.out.printf( "Größtes Element: %d%n", numbers[ numbers.length - 1 ] );
  }
  //end::solution[]
}

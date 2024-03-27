package com.tutego.exercises.lang.exception;

import java.util.Arrays;

public class StringsToInteger {

  //tag::solution[]
  private static int parseIntOrElse( String number, int defaultValue ) {
    try {
      return Integer.parseInt( number );
    }
    catch ( NumberFormatException e ) {
      return defaultValue;
    }
  }

  public static int[] parseInts( String... numbers ) {
    if ( numbers == null || numbers.length == 0 )
      throw new IllegalArgumentException( "array is null or does not contain any value" );

    int[] result = new int[ numbers.length ];

    for ( int i = 0; i < numbers.length; i++ )
      result[ i ] = parseIntOrElse( numbers[ i ], 0 );

    // Arrays.setAll( result, index -> parseIntOrElse( numbers[ index ], 0 ) );

    return result;
  }
  //end::solution[]

  public static void main( String[] args ) {
    for ( int e : parseInts( "2", "55", "5" ) )
      System.out.println( e );
  }
}
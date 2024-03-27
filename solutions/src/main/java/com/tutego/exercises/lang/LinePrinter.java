package com.tutego.exercises.lang;

public class LinePrinter {

  //tag::solution1[]
  public static void lines() {
    System.out.print( "♥♥♥♥♥♥♥♥♥♥" );
  }
  //end::solution1[]

  //tag::solution2[]
  public static void lines( int len, char c ) {
    while ( len-- > 0 )
      System.out.print( c );
  }

  public static void lines( int len ) {
    lines( len, '-' );
  }

  public static void lines( String prefix, int len, char c, String suffix ) {
    System.out.print( prefix );
    lines( len, c );
    System.out.print( suffix );
  }
  //end::solution2[]

  public static void lines( int len, String string ) {
    int noOfFullStrings = len / string.length();

    String remainString = string.substring( 0, len % string.length() );

    while ( noOfFullStrings-- > 0 )
      System.out.print( string );

    System.out.println( remainString );
  }
}

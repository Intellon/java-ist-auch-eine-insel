package com.tutego.exercises.string;

public class PrintUnderline {

  public static void main( String[] args ) {
    String text = "Hallo super Welt, heute ist das Wetter aber super schön";
    underline( text, "super" );
  }

  //tag::solution[]
  private static void outputChar( char c, int count ) {
    for ( int i = 0; i < count; i++ )
      System.out.print( c );
  }

  static void underline( String string, String search ) {
    System.out.println( string );

    for ( int nextIndex = 0, lastIndex = 0;
          (nextIndex = string.indexOf( search, lastIndex )) >= 0; ) {

      outputChar( ' ', nextIndex - lastIndex );
      outputChar( '-', search.length() );
      lastIndex = nextIndex + search.length();
    }
  }
  //end::solution[]
}

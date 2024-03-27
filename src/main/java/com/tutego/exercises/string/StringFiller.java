package com.tutego.exercises.string;

public class StringFiller {

  //tag::solution[]
  private static String mix( String string, String fill ) {

    if ( string == null || string.length() == 0 )
      return "";

    if ( fill == null || fill.length() == 0 )
      return string;

    String result = "";

    for ( int i = 0; i < string.length() - 1; i++ ) {
      char c = string.charAt( i );
      result += c + fill;
    }

    result += string.charAt( string.length() - 1 );

    return result;
  }
  //end::solution[]

  public static void main( String[] args ) {
    System.out.println( mix( "Der Rum ist alle!", "  " ) );
    System.out.println( mix( "Blimey", "\uD83D\uDC7B" ) );
    System.out.println( mix( "HI", "!!" ) );
    System.out.println( mix( "*", "!!" ) );
    System.out.println( mix( "", "!!" ) );
  }

}

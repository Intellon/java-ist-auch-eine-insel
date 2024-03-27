package com.tutego.exercises.string;

import java.util.Arrays;

public class RemoveVowel {

  //tag::solution[]
  public static String removeVowels1( String string ) {
    string = string.replace( "a", "" ).replace( "A", "" );
    string = string.replace( "ä", "" ).replace( "Ä", "" );
    string = string.replace( "e", "" ).replace( "E", "" );
    string = string.replace( "o", "" ).replace( "O", "" );
    string = string.replace( "ö", "" ).replace( "Ö", "" );
    string = string.replace( "u", "" ).replace( "U", "" );
    string = string.replace( "ü", "" ).replace( "Ü", "" );
    string = string.replace( "i", "" ).replace( "I", "" );
    string = string.replace( "y", "" ).replace( "Y", "" );
    return string;
  }

  /////////////////////////////////////////////////////////////////////////////////

  public static String removeVowels2( String string ) {
    char[] chars = new char[string.length()];
    int len = 0;

    for ( int i = 0; i < string.length(); i++ ) {
      char c = string.charAt( i );

      if ( "aeiouöäüyAEIOUÄÖÜY".indexOf( c ) < 0 )
        chars[ len++ ] = c;
    }

    return new String( chars, 0, len );
  }

  /////////////////////////////////////////////////////////////////////////////////

  public static String removeVowels3( String string ) {
    final char[] VOWELS = { 'a', 'e', 'i', 'o', 'u', 'y', 'ä', 'ö', 'ü' };
    String result = "";
    for ( int i = 0; i < string.length(); i++ ) {
      char c = string.charAt( i );
      int pos = Arrays.binarySearch( VOWELS, Character.toLowerCase( c ) );
      if ( pos < 0 )
        result = result + c;
    }
    return result;
  }

  /////////////////////////////////////////////////////////////////////////////////

  private static boolean isVowel( char c ) {
    return "aeiouyäöüAEIOUYÄÖÜ".indexOf( c ) >= 0;
  }

  public static String removeVowels4( String string ) {
    StringBuilder result = new StringBuilder( string.length() );
    for ( int i = 0; i < string.length(); i++ ) {
      char c = string.charAt( i );
      if ( !isVowel( c ) )
        result.append( c );
    }
    return result.toString();
  }

  /////////////////////////////////////////////////////////////////////////////////

  public static String removeVowels5( String string ) {
    return string.replaceAll( "[aeiouyäöüAEIOUYÄÖÜ]", "" );
  }

  /////////////////////////////////////////////////////////////////////////////////

  public static String removeVowels6( String string ) {
    String result = "";
    String[] tokens = string.split( "[aeiouyäöüAEIOUYÄÖÜ]" );
    for ( String value : tokens )
      result += value;
    return result;
  }
  //end::solution[]

  /////////////////////////////////////////////////////////////////////////////////

  public static void main( String[] args ) {
    System.out.println( removeVowels1( "Hallo Javanesen" ) );
    System.out.println( removeVowels2( "Hallo Javanesen" ) );
    System.out.println( removeVowels3( "Hallo Javanesen" ) );
    System.out.println( removeVowels4( "Hallo Javanesen" ) );
    System.out.println( removeVowels5( "Hallo Javanesen" ) );
    System.out.println( removeVowels6( "Hallo Javanesen" ) );
  }
}

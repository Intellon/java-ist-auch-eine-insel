package com.tutego.exercises.string;

public class PasswordTester {

  //tag::solution[]
  public static final int MIN_PASSWORD_LEN = 8;

  public static boolean isGoodPassword( String password ) {

    if ( password.length() < MIN_PASSWORD_LEN ) {
      System.err.println( "Passwort zu kurz" );
      return false;
    }

    if ( !containsUppercaseLetter( password ) ) {
      System.err.println( "Muss Großbuchstaben enthalten" );
      return false;
    }

    if ( !containsLowercaseLetter( password ) ) {
      System.err.println( "Muss Kleinbuchstaben enthalten" );
      return false;
    }

    if ( !containsDigit( password ) ) {
      System.err.println( "Muss Ziffer enthalten" );
      return false;
    }

    if ( !containsSpecialCharacter( password ) ) {
      System.err.println( "Muss Sonderzeichen wie ., enthalten" );
      return false;
    }

    return true;
  }

  private static boolean containsUppercaseLetter( String string ) {
    for ( int i = 0; i < string.length(); i++ ) {
      char c = string.charAt( i );
      if ( Character.isUpperCase( c ) )
        return true;
    }
    return false;
  }

  private static boolean containsLowercaseLetter( String string ) {
    for ( int i = 0; i < string.length(); i++ ) {
      char c = string.charAt( i );
      if ( Character.isLowerCase( c ) )
        return true;
    }
    return false;
  }

  private static boolean containsDigit( String string ) {
    for ( int i = 0; i < string.length(); i++ ) {
      char c = string.charAt( i );
      if ( Character.isDigit( c ) )
        return true;
    }
    return false;
  }

  private static boolean containsSpecialCharacter( String string ) {
    for ( int i = 0; i < string.length(); i++ ) {
      char c = string.charAt( i );
      switch ( c ) {
        case '.':
        case ',':
          return true;
      }
    }
    return false;
  }

  public static void main( String[] args ) {
    System.out.println( isGoodPassword( "zukurz" ) );
    System.out.println( isGoodPassword( "nurkleinbuchstaben" ) );
    System.out.println( isGoodPassword( "keineziffern" ) );
    System.out.println( isGoodPassword( "Mit0Sonderzeichen" ) );
    System.out.println( isGoodPassword( "Mit 3 Sonderzeichen .$#&" ) );
  }
  //end::solution[]
}

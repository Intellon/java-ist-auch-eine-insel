package com.tutego.exercises.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringJoiner;

public class MorseEncoderDemo {

  public static void main( String[] args ) {
    String string = "Morse code is a method used in telecommunication. BOTTOMMOST";
    MorseEncoder encoder = new MorseEncoder();
    String encoded = encoder.encode( string );
    System.out.println( encoded );
    System.out.println( encoder.decode( encoded ) );
  }
}

//tag::solution[]
class MorseEncoder {
  private final Map<Character, String> charToMorse = new HashMap();
  private final Map<String, Character> morseToChar = new HashMap();

  MorseEncoder() {
    charToMorse.put( 'a', ".-" );
    charToMorse.put( 'b', "-..." );
    charToMorse.put( 'c', "-.-" );
    charToMorse.put( 'd', "-.." );
    charToMorse.put( 'e', "." );
    charToMorse.put( 'f', "..-." );
    charToMorse.put( 'g', "--." );
    charToMorse.put( 'h', "...." );
    charToMorse.put( 'i', ".." );
    charToMorse.put( 'j', ".---" );
    charToMorse.put( 'k', "-." );
    charToMorse.put( 'l', ".-.." );
    charToMorse.put( 'm', "--" );
    charToMorse.put( 'n', "-." );
    charToMorse.put( 'o', "---" );
    charToMorse.put( 'p', ".--." );
    charToMorse.put( 'q', "--.-" );
    charToMorse.put( 'r', ".-." );
    charToMorse.put( 's', "..." );
    charToMorse.put( 't', "-" );
    charToMorse.put( 'u', "..-" );
    charToMorse.put( 'v', "...-" );
    charToMorse.put( 'w', ".--" );
    charToMorse.put( 'x', "-..-" );
    charToMorse.put( 'y', "-.--" );
    charToMorse.put( 'z', "--.." );
    charToMorse.put( '1', ".----" );
    charToMorse.put( '2', "..---" );
    charToMorse.put( '3', "...--" );
    charToMorse.put( '4', "....-" );
    charToMorse.put( '5', "....." );
    charToMorse.put( '6', "-...." );
    charToMorse.put( '7', "--..." );
    charToMorse.put( '8', "---.." );
    charToMorse.put( '9', "----." );
    charToMorse.put( '0', "-----" );

    charToMorse.forEach( (character, string) -> morseToChar.put( string, character ) );
  }

  public String encode( String string ) {
    StringJoiner result = new StringJoiner( " " );
    for ( int i = 0; i < string.length(); i++ ) {
      if ( string.charAt( i ) == ' ' )
        result.add( "" );
      else {
        String maybeMorse = charToMorse.get( Character.toLowerCase( string.charAt( i ) ) );
        if ( maybeMorse != null )
          result.add( maybeMorse );
      }
    }
    return result.toString();
  }

  public String decode( String string ) {
    StringBuilder result = new StringBuilder( string.length() / 4 );

    for ( String token : string.split( "  " ) ) {
      Scanner scanner = new Scanner( token );
      while ( scanner.hasNext() ) {
        Character maybeChar = morseToChar.get( scanner.next() );
        if ( maybeChar != null )
          result.append( maybeChar );
      }
      result.append( ' ' );
    }

    return result.toString();
  }
}
//end::solution[]

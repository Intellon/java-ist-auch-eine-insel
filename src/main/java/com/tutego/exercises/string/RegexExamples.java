package com.tutego.exercises.string;

import java.util.regex.Pattern;

public class RegexExamples {

  public static void main( String[] args ) {
    //tag::solution[]
    // Eine Zeichenfolge aus exakt 10 Ziffern.

    System.out.println( "0123456789".matches( "\\d{10}" ) );       // true
    System.out.println( "1".matches( "\\d{10}" ) );                // false
    System.out.println( "abcdefghij".matches( "\\d{10}" ) );       // false

    // Eine Zeichenfolge aus 10 bis 20 Ziffern und Buchstaben.

    System.out.println( "01234567".matches( "\\d{5,10}" ) );       // true
    System.out.println( "0".matches( "\\d{5,10}" ) );              // false
    System.out.println( "01234567890123".matches( "\\d{5,10}" ) ); // false

    // Eine Zeichenfolge, die wie ein Satz auf `.`, `!` oder `?` endet.

    System.out.println( "Ja? Ja!".matches( ".*?[.!?]" ) );         // true
    System.out.println( "Nein?".matches( ".*?[.!?]" ) );           // true
    System.out.println( "Ok.".matches( ".*?[.!?]" ) );             // true
    System.out.println( "No".matches( ".*?[.!?]" ) );              // true

    // Eine Zeichenfolge, die keine Ziffern enthält.

    System.out.println( "Ciao".matches( "\\D+" ) );                // true
    System.out.println( "Cia0".matches( "\\D+" ) );                // false
    System.out.println( "".matches( "\\D+" ) );                    // false

    // Die Amtsbezeichnung bzw. Namenstitel, Prof., Dr., Dr. med., Dr. h.c.,

    Pattern pattern = Pattern.compile( "(Prof\\.|Dr\\. med\\.|Dr\\. h\\.c\\.|Dr\\.)\\s" );
    System.out.println( pattern.matcher( "Hallo Herr Dr. Miles" ).find() ); // true
    System.out.println( pattern.matcher( "Nix mit Dr. h.c. Thai med." ).find() ); // true
    System.out.println( pattern.matcher( "Megan Dr.Thai" ).find() ); // false
    //end::solution[]
  }
}

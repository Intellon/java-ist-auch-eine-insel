package com.tutego.exercises.lang;

import javax.swing.JOptionPane;

public class AskForCandy {

  //tag::solution[]
  enum CandyType {
    CARAMELS,
    CHOCOLATE,
    GUMMIES,
    LICORICE,
    LOLLIPOPS,
    CHEWING_GUMS,
    COTTON_CANDY
  }

  static CandyType fromName( String input ) {
    try {
      input = input.trim().toUpperCase().replace( ' ', '_' );
      return CandyType.valueOf( input );
    }
    catch ( IllegalArgumentException e ) {
      System.err.println( "Unknown type" );
      return null;
    }
  }

  public static void main( String[] args ) {
    String input = JOptionPane.showInputDialog( null, "Name einer Süßigkeit" );
    if ( input != null )
      System.out.println( fromName( input ) );
  }
  //end::solution[]
}
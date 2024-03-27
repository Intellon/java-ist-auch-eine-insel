package com.tutego.exercises.lang;

public class HumanReadableLiter {

  @SuppressWarnings( "resource" )
  public static void main( String[] args ) {
    //tag::solution[]
    System.out.println( "Bitte Menge in Liter angeben" );
    double value = new java.util.Scanner( System.in ).nextDouble();

    if ( value >= 1 )
      System.out.printf( "ca. %d l", (int) value );
    else if ( value >= 0.1 )     // 1 l = 100 cl
      System.out.printf( "ca. %d cl", (int) (value * 100) );
    else if ( value >= 0.001 )   // 1 l = 1000 ml
      System.out.printf( "ca. %d ml", (int) (value * 1000) );
    else
      System.err.println( "Wert zu klein zur Darstellung" );
    //end::solution[]
  }
}

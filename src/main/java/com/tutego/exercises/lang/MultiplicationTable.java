package com.tutego.exercises.lang;

public class MultiplicationTable {

  //tag::solution[]
  private static void startTable() { System.out.println( "<table>" ); }

  private static void endTable() { System.out.println( "</table>" ); }

  private static void startRow() { System.out.print( "<tr>" ); }

  private static void endRow() { System.out.println( "</tr>" ); }

  private static void headerCell( String value ) {
    System.out.print( "<th>" + value + "</th>" );
  }

  private static void dataCell( String value ) {
    System.out.print( "<td>" + value + "</td>" );
  }

  private static void dataCell( int value ) {
    dataCell( Integer.toString( value ) );
  }

  public static void main( String[] args ) {
    startTable();

    startRow();
    headerCell( "Anzahl" ); headerCell( "Flammenwerfer" ); headerCell( "Feuerlöscher" );
    endRow();

    for ( int i = 1; i <= 10; i++ ) {
      startRow();
      dataCell( i );
      dataCell( 500 * i );
      dataCell( 100 * i );
      endRow();
    }

    endTable();
  }
  //end::solution[]
}

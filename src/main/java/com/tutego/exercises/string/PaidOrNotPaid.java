package com.tutego.exercises.string;

public class PaidOrNotPaid {

  //tag::solution[]
  public static void printList( String[] names, boolean[] paid ) {

    if ( names == null || paid == null || names.length != paid.length )
      return;

    int maxColumnLength = 0;
    for ( String name : names )
      maxColumnLength = Math.max( maxColumnLength, name.length() );

    String format = "%-" + maxColumnLength + "s    %sbezahlt%n";

    for ( int i = 0; i < names.length; i++ ) {
      System.out.printf( format, names[i], paid[i] ? "" : "nicht " );
    }
  }
  //end::solution[]

  public static void main( String[] args ) {
    String[] names = { "Dory Dab", "Bob Banjo", "Cod Buri", "Bugsy" };
    boolean[] paid = { true, true, true, false };
    printList( names, paid );
  }
}

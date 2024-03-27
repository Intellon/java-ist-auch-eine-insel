package com.tutego.exercises.lang;

public class NumberOfBottles {

  public static void main( String[] args ) {
    //tag::solution[]
    int noOfBottles = 99;  // oder 0, 1, 99, ...

    System.out.println( "Es gibt " + noOfBottles + " " +
                        (noOfBottles != 1 ? "Flaschen" : "Flasche") + "." );

    System.out.printf( "Es gibt %d Flasche%s.%n",
                       noOfBottles, noOfBottles != 1 ? "n" : "" );
    //end::solution[]
  }
}

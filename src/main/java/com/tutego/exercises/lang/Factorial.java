package com.tutego.exercises.lang;

import java.util.Scanner;

public class Factorial {

  public static void main( String[] args ) {
    //tag::solution[]
    System.out.println( "Zahl eingeben:" );
    int n = new Scanner( System.in ).nextInt();

    if ( n < 0 )
      System.err.println( "Zahl darf nicht negativ sein" );
    else if ( n < 2 )
      System.out.printf( "%d! = 1", n );
    else {
      System.out.printf( "%d! = 1", n );
      long factorial = 1;

      for ( int multiplier = 2; multiplier <= n; multiplier++ ) {
        System.out.printf( " * %d", multiplier );
        factorial *= multiplier;
      }

      System.out.printf( " = %d%n", factorial );
    }
    //end::solution[]
  }
}

package com.tutego.exercises.lang;

import java.util.Scanner;

public class IsFactorial {

  public static void main( String[] args ) {
    //tag::solution[]
    System.out.println( "Zahl eingeben:" );
    long n = new Scanner( System.in ).nextLong();

    if ( n < 1 )
      System.err.println( "Fakultäten sind immer >= 1" );
    else {
      long number  = n;
      long divisor = 2;

      while ( number % divisor == 0 ) {
        number /= divisor;
        divisor++;
      }

      if ( number == 1 )
        System.out.printf( "%d = %d!", n, divisor - 1 );
      else
        System.out.printf( "%d ist keine Fakultät", n );
    }
    //end::solution[]
  }
}

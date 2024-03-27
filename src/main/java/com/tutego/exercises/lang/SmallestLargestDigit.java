package com.tutego.exercises.lang;

public class SmallestLargestDigit {

  public static void main( String[] args ) {
    //tag::solution[]
    long n = 30;

    long largest  = 0;
    long smallest = n == 0 ? 0 : 9;

    for ( long value = Math.abs( n ); value != 0; value /= 10 ) {
      long remainder = value % 10;
      largest  = Math.max( remainder, largest );
      smallest = Math.min( remainder, smallest );
    }

    System.out.println( smallest + ", "+ largest );
    //end::solution[]
  }
}

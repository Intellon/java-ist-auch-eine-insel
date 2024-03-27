package com.tutego.exercises.array;

import java.util.Arrays;

public class Tetraphobia {
  //tag::solution[]
  private static boolean containsFour( int number ) {
    return String.valueOf( number ).contains( "4" );
  }

  public static int[] fourLast( int... numbers ) {

    if ( numbers == null || numbers.length < 2 )
      return numbers;

    for ( int start = 0; start < numbers.length; start++ ) {
      if ( ! containsFour( numbers[ start ] ) )
        continue;

      // from right to left search the first number without a 4
      for ( int end = numbers.length - 1; end > start; end-- ) {
        if ( containsFour( numbers[ end ] ) )
          continue;
        // swap number[i] (with 4) and number[j] no 4
        int swap = numbers[ start ];
        numbers[ start ] = numbers[ end ];
        numbers[ end ]   = swap;
      }
    }
    return numbers;
  }
  //end::solution[]

  public static void main( String[] args ) {
    int[] numbers1 = { 1, 44, 2, 4, 43 };
    System.out.println( Arrays.toString( fourLast( numbers1 ) ) );
    System.out.println( Arrays.toString( fourLast( 4, 4, 44, 1234 ) ) );
  }
}

package com.tutego.exercises.array;

import java.util.logging.Logger;

public class MuggingFairly {

  //tag::solution[]
  public static int findSplitPoint( int[] cash ) {

    if ( cash.length < 2 )
      return -1;

    int sumLeft = cash[ 0 ];

    int sumRight = 0;
    for ( int i = 1; i < cash.length; i++ )
      sumRight += cash[ i ];

    for ( int splitIndex = 1; splitIndex < cash.length; splitIndex++ ) {
      int relativeDifference = relativeDifference( sumLeft, sumRight );

      Logger.getLogger( "MuggingFairly" ).info( "splitIndex=" + splitIndex +
          ", sum left/right=" + sumLeft + "/" + sumRight + ", difference=" + relativeDifference );

      if ( relativeDifference <= 10 )
        return splitIndex;

      int element = cash[ splitIndex ];
      sumLeft  += element;
      sumRight -= element;
    }
    return -1;
  }

  // https://en.wikipedia.org/wiki/Relative_change_and_difference
  private static int relativeDifference( int a, int b ) {
    int absoluteDifference = Math.abs( a - b );
    return (int) (100. * absoluteDifference / Math.max( a, b ));
  }
  //end::solution[]

  public static void main( String[] args ) {
    int[] cash1 = { 10, 20, 30, 40, 40, 50 };
    System.out.println( findSplitPoint( cash1 ) );
    int[] cash2 = { 0, 0, 0 };
    System.out.println( findSplitPoint( cash2 ) );
    int[] cash3 = { 10, 20, 30, 40, 40, 100 };
    System.out.println( findSplitPoint( cash3 ) );
  }
}

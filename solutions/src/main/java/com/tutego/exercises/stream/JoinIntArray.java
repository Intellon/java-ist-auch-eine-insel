package com.tutego.exercises.stream;

import java.util.Arrays;
import java.util.stream.IntStream;

public class JoinIntArray {
  //tag::solution[]
  public static int[] join( int[] numbers1, int[] numbers2, int maxSize ) {
    return IntStream.concat( IntStream.of( numbers1 ), IntStream.of( numbers2 ) )
                    .limit( maxSize )
                    .toArray();
  }

  public static int[] join( int[] numbers1, int[] numbers2 ) {
    return join( numbers1, numbers2, Math.addExact( numbers1.length, numbers2.length ) );
  }
  //end::solution[]

  public static void main( String[] args ) {
    int[] numbers1 = { 7, 12 };
    int[] numbers2 = { 51, 56, 0, 2 };
    int[] result1 = join( numbers1, numbers2 );
    int[] result2 = join( numbers1, numbers2, 3 );
    System.out.println( Arrays.toString( result1 ) ); // [7, 12, 51, 56, 0, 2]
    System.out.println( Arrays.toString( result2 ) ); // [7, 12, 51]
  }
}

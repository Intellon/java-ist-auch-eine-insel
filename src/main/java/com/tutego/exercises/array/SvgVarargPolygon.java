package com.tutego.exercises.array;

public class SvgVarargPolygon {

  //tag::solution[]
  /**
   * Prints a SVG polygon. Example output:
   * <pre>
   *  <polygon points="200,10 250,190 160,210 " />
   * </pre>
   * @param points
   */
  public static void printSvgPolygon( int... points ) {

    if ( points == null || points.length % 2 == 1 )
      throw new IllegalArgumentException( "Array is either null or has an odd number of arguments" );

    System.out.print( "<polygon points=\"" );

    for ( int i = 0; i < points.length; i += 2 )
      System.out.printf( "%d,%d ", points[ i ], points[ i + 1 ] );

    System.out.println( "\" />" );
  }
  //end::solution[]
}

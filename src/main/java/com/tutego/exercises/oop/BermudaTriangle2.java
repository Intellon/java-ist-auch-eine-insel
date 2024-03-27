package com.tutego.exercises.oop;

import java.awt.Polygon;
import java.util.Random;

public class BermudaTriangle2 {

  //tag::solution[]
  private static final int DIMENSION = 50;

  static Polygon setRandomTriangle( Polygon poly ) {
    poly.reset();

    Random random = new Random();
    poly.addPoint( random.nextInt( DIMENSION ), random.nextInt( DIMENSION ) );
    poly.addPoint( random.nextInt( DIMENSION ), random.nextInt( DIMENSION ) );
    poly.addPoint( random.nextInt( DIMENSION ), random.nextInt( DIMENSION ) );
    
    return poly;
  }

  static Polygon createRandomTriangle() {
    return setRandomTriangle( new Polygon() );
  }
  //end::solution[]

  public static void main( String[] args ) {
//    Polygon polygon = setRandomTriangle( new Polygon() );
    Polygon polygon = createRandomTriangle();

    for ( int y = 0; y < DIMENSION; y++ ) {
      for ( int x = 0; x < DIMENSION; x++ )
        System.out.print( polygon.contains( x, y ) ? "#" : " " );
      System.out.println();
    }
  }
}
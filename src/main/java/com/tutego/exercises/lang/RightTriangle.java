package com.tutego.exercises.lang;

public class RightTriangle {

  //tag::solution[]
  public static boolean isRightTriangle( double a, double b, double c ) {

    // Step 1: propagate the largest value into c

    // If a > c then swap
    if ( a > c ) {
      double swap = a;
      a = c;
      c = swap;
    }

    // If b > c then swap
    if ( b > c ) {
      double tmp = b;
      b = c;
      c = tmp;
    }

    // Step 2: The test

    return a * a + b * b == c * c;
  }
  //end::solution[]

//  public static boolean almostEqual( double a, double b, double eps ) {
//    return Math.abs( a - b ) < eps;
//  }
}

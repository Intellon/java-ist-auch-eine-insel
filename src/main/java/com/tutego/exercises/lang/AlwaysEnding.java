package com.tutego.exercises.lang;

public class AlwaysEnding {

  public static void main( String[] args ) {
    //tag::solution[]
    double t = Math.random() * 10;

    while ( t > 0 ) {
      System.out.println( t );
      if ( t < 1 )
        t *= 2;
      else if ( t >= 1 )
        t--;
    }
    //end::solution[]
  }
}

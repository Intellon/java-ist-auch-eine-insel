package com.tutego.exercises.util;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class MusicalChairs {

  //tag::solution[]
  public static void rotate( List<String> list, int distance ) {
    Collections.rotate( list, distance );
  }

  public static void rotateAndRemoveLast( List<String> list, int distance ) {
    rotate( list, distance );
    list.remove( list.size() - 1 );
  }

  public static void musicalChairs( List<String> list ) {
    while ( list.size() > 1 ) {
      rotateAndRemoveLast( list, ThreadLocalRandom.current().nextInt() );
      System.out.println( list );
    }
  }
  //end::solution[]

  public static void main( String[] args ) {
    List<String> names = new ArrayList<>( Arrays.asList( "Laser", "Milka", "Popo", "Despot" ) );

    // Rotate
    rotate( names, 2 );
    System.out.println( names );

    // rotate and remove last
    rotateAndRemoveLast( names, 2 );
    System.out.println( names );

    // Rotate and Remove last in a loop
    musicalChairs( names );
    System.out.println( "The winner is: " + names.get( 0 ) );
  }
}
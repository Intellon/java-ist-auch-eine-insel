package com.tutego.exercises.util;

import java.util.*;

public class CommonGifts {

  public static void main( String[] args ) {
    Set<String> gombonoGifts = new HashSet<>();
    Collections.addAll( gombonoGifts, "Vodka", "Liebeswürfel", "Knetseife" );

    Set<String> banannaGifts = new HashSet<>();
    Collections.addAll( banannaGifts, "Vodka", "Saufhelm" );

    Set<String> cilimbiGifts = new HashSet<>();
    Collections.addAll( cilimbiGifts, "Saufhelm", "Spardose", "Vodka", "Wasserpistole" );

    List<Set<String>> families = List.of( gombonoGifts, banannaGifts, cilimbiGifts );

    printMultipleGifts( families );
  }

  //tag::solution[]
  private static void printMultipleGifts( List<Set<String>> families ) {

    class Bag extends HashMap<String, Integer> {
      void add( String key ) { merge( key, 1, Integer::sum ); }
      // int getCount( String key ) { return getOrDefault( key, 0 ); }
    }

    Bag giftsToCounter = new Bag();

    for ( Set<String> gifts : families )
      for ( String gift : gifts )
        giftsToCounter.add( gift );

    System.out.println( giftsToCounter );

    giftsToCounter.forEach( (gift, counter) -> {
      if ( counter > 1 )
        System.out.println( gift );
    } );
  }
  //end::solution[]
}

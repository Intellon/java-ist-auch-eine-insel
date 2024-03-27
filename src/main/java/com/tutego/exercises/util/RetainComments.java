package com.tutego.exercises.util;

import java.util.ArrayList;
import java.util.List;

public class RetainComments {
  //tag::solution[]
  public static void reduceToComments( List<String> lines ) {

    if ( lines.isEmpty() )
      return;

    if ( lines.size() % 4 != 0 )
      throw new IllegalArgumentException(
          String.format( "Illegal size %d of list, must be divisible by 4", lines.size() ) );

    for ( int blockStart = lines.size() - 4; blockStart >= 0; blockStart -= 4 ) {
      // retrain element at position blockStart + 3
      lines.remove( blockStart + 2 );
      lines.remove( blockStart + 1 );
      lines.remove( blockStart + 0 );
    }
  }
  //end::solution[]

  public static void main( String[] args ) {
    ArrayList<String> entries = new ArrayList<>(
        List.of( "A1", "A2", "A3", "A4", "B1", "B2", "B3", "B4", "C1", "C2", "C3", "C4" ) );
    reduceToComments( entries );
    System.out.println( entries );
  }
}

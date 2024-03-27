package com.tutego.exercises.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoShuffle {
  
  public static void main( String[] args ) {
    //tag::solution[]
    List<Integer> randomList = new ArrayList<>();

    // Liste füllen
    for ( int i = 1; i <= 49; ++i )
      randomList.add( i );

    // Liste mischen
    Collections.shuffle( randomList );

    // Subliste erzeugen
    List<Integer> lottoList = randomList.subList( 0, 7 );

    // Subliste sortieren
    Collections.sort( lottoList );

    // Subliste ausgeben
    System.out.println( lottoList );
    //end::solution[]
  }
}

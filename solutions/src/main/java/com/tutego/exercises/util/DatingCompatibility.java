package com.tutego.exercises.util;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class DatingCompatibility {

  public static void main( String[] args ) {
    //tag::solution[]
    Set<String> he = new HashSet<>();
    Collections.addAll( he, "Candy making", "Camping", "Billiards", "Fishkeeping", "Eating",
                        "Action figure", "Birdwatching", "Axe throwing" );
    Set<String> she = new HashSet<>();
    Collections.addAll( she, "Axe throwing", "Candy making", "Camping",
                        "Action figure", "Casemodding", "Skiing", "Satellite watching" );

    Set<String> intersection = new HashSet<>( he );
    intersection.retainAll( she );
    System.out.println( intersection );

    System.out.printf( "Liste 'he' stimmt zu %d %% mit der Liste 'she' überein.%n",
                       (intersection.size() * 100) / he.size() );
    System.out.printf( "Liste 'she' stimmt zu %d %% mit der Liste 'he' überein.%n",
                       (intersection.size() * 100) / she.size() );

    //end::solution[]
  }
}

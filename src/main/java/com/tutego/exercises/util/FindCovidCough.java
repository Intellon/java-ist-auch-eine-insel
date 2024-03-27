package com.tutego.exercises.util;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class FindCovidCough {
  static class Ship {
    private List<String> persons = new ArrayList<>();
    void addName( String name ) { persons.add( name ); }
    boolean contains( String name ) { return persons.contains( name ); }
    @Override public String toString() { return persons.toString(); }
  }

  public static void main( String[] args ) {
    final int NUMBER_OF_SHIPS = 100;

    List<Ship> ships = new LinkedList<>();
    for ( int i = 0; i < NUMBER_OF_SHIPS; i++ )
      ships.add( new Ship() );

    int covidShipIndex = ThreadLocalRandom.current().nextInt( ships.size() );
    ships.get( covidShipIndex ).addName( "Covid Cough" );
    System.out.println( "Covid at ship " + covidShipIndex );

    ListIterator<Ship> iterator = ships.listIterator( ThreadLocalRandom.current().nextInt( ships.size() ) );
    System.out.println( "Captain arrived at ship " + iterator.nextIndex() );

    //tag::solution-a[]
    if ( iterator.nextIndex() >= NUMBER_OF_SHIPS / 2 ) {
      if ( lookRight( iterator ) )
        System.out.println( "-> at ship " + iterator.previousIndex() );
      else if ( lookLeft( iterator ) )
        System.out.println( "-> <- at ship " + iterator.nextIndex() );
      else
        System.out.println( "Not found" );
    }
    else {
      if ( lookLeft( iterator ) )
        System.out.println( "<- at ship " + iterator.nextIndex() );
      else if ( lookRight( iterator ) )
        System.out.println( "<- -> at ship " + iterator.previousIndex() );
      else
        System.out.println( "Not found" );
    }
    //end::solution-a[]
  }

  //tag::solution-b[]
  private static boolean lookRight( ListIterator<Ship> iterator ) {
    while ( iterator.hasNext() ) {
      if ( iterator.next().contains( "Covid Cough" ) )
        return true;
    }
    return false;
  }

  private static boolean lookLeft( ListIterator<Ship> iterator ) {
    while ( iterator.hasPrevious() ) {
      if ( iterator.previous().contains( "Covid Cough" ) )
        return true;
    }
    return false;
  }
  //end::solution-b[]
}

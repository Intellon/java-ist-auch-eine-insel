package com.tutego.exercises.util;

import java.util.*;

public class Holidays {
  public static void main( String[] args ) {
    //tag::solution[]
    // Build Set of Saturdays and Sundays

    SortedSet<Date> set = new TreeSet<>();

    Calendar today = Calendar.getInstance();

    for ( int day = 1, maxDay = today.getActualMaximum( Calendar.DAY_OF_YEAR ); 
          day <= maxDay; 
          day++ ) {
      today.set( Calendar.DAY_OF_YEAR, day );

      if (    today.get( Calendar.DAY_OF_WEEK ) == Calendar.SATURDAY
           || today.get( Calendar.DAY_OF_WEEK ) == Calendar.SUNDAY )
        set.add( today.getTime() );
    }

    // Find Saturdays and Sundays in holidays.

    Date start = new GregorianCalendar( 2014, Calendar.DECEMBER, 22 ).getTime();
    Date end   = new GregorianCalendar( 2015, Calendar.JANUARY,   1 ).getTime();
    SortedSet<Date> subSet = set.subSet( start, end );
    System.out.println( subSet.size() );

    for ( Date date : subSet )
      System.out.println( date );
    //end::solution[]
  }
}
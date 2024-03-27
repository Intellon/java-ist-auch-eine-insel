package com.tutego.exercises.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HeroComparators {

  @SuppressWarnings( "unused" )
  public static void main( String[] args ) {
    //tag::solution[]
    // lokale Klasse
    class YearFirstAppearanceComparator implements Comparator<Heroes.Hero> {
      @Override public int compare( Heroes.Hero h1, Heroes.Hero h2 ) {
        return Integer.compare( h1.yearFirstAppearance, h2.yearFirstAppearance );
      }
    }

    // innere anonyme Klasse
    Comparator<Heroes.Hero> innerClassComparator = new Comparator<Heroes.Hero>() {
      @Override public int compare( Heroes.Hero h1, Heroes.Hero h2 ) {
        return Integer.compare( h1.yearFirstAppearance, h2.yearFirstAppearance );
      }
    };

    // Lambda-Ausdruck
    Comparator<Heroes.Hero> lambdaComparator =
        (h1, h2) -> Integer.compare( h1.yearFirstAppearance, h2.yearFirstAppearance );

    // Comparator mit 2 Kriterien
    Comparator<Heroes.Hero> combinedComparator = ( h1, h2 ) -> {
      int yearComparison = Integer.compare( h1.yearFirstAppearance, h2.yearFirstAppearance );
      return (yearComparison != 0) ? yearComparison : h1.name.compareTo( h2.name );
    };

    List<Heroes.Hero> allHeros = new ArrayList<>( Heroes.ALL );
    allHeros.sort( new YearFirstAppearanceComparator() );
    allHeros.sort( innerClassComparator );
    allHeros.sort( lambdaComparator );
    allHeros.sort( combinedComparator );
    //end::solution[]
  }
}

package com.tutego.exercises.util;

import java.util.ArrayList;
import java.util.List;

public class HeroLists {

  //tag::solution[]
  public static void main( String[] args ) {
    List<Heroes.Hero> heroes = new ArrayList<>( Heroes.ALL );
    heroes.removeIf( hero -> hero.sex != Heroes.Hero.Sex.FEMALE );
    heroes.replaceAll( hero -> new Heroes.Hero( hero.name.replaceAll( "\\s*\\(.*\\)$", "" ),
                                                hero.sex, hero.yearFirstAppearance ) );
    heroes.forEach( HeroLists::printAsCsv );
  }

  private static void printAsCsv( Heroes.Hero hero ) {
    System.out.printf( "%s;%s;%s%n", hero.name, hero.sex, hero.yearFirstAppearance );
  }
  //end::solution[]
}

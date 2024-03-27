package com.tutego.exercises.util;

import com.google.common.collect.Sets;

import java.util.*;
import java.util.stream.Collectors;

public class Telephone {
  //tag::solution[]
  private static final List<Set<String>> sets = List.of(
      /* 0 */ Set.of( "0" ),
      /* 1 */ Set.of( "1" ),
      /* 2 */ Set.of( "A", "B", "C" ),
      /* 3 */ Set.of( "D", "E", "F" ),
      /* 4 */ Set.of( "G", "H", "I" ),
      /* 5 */ Set.of( "J", "K", "L" ),
      /* 6 */ Set.of( "N", "M", "O" ),
      /* 7 */ Set.of( "P", "Q", "R", "S" ),
      /* 8 */ Set.of( "T", "U", "V" ),
      /* 9 */ Set.of( "W", "X", "Y", "Z" )
  );

  public static void main( String[] args ) {

    String number = "12343";

    List<Set<String>> collect = number.chars().mapToObj( Character::getNumericValue ).map( sets::get )
        .collect( Collectors.toList() );

    Set<List<String>> permutations = Sets.cartesianProduct( collect );

    List<String> collect1 = permutations.stream()   // -> Stream<List<String>>
        .map( Collection::stream )                  // -> Stream<Stream<String>>
        .map( stringStream -> stringStream.collect( Collectors.joining( "" ) ) )
        .collect( Collectors.toList() );

    System.out.println( collect1 );
  }
  //end::solution[]
}
package com.tutego.exercises.stream;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NameOccurrences {

  public static void main( String[] args ) {
    //tag::solution[]
    String[] names = {
        "Anne", "Captain CiaoCiao", "Balico", "Charles", "Anne", "CiaoCiao",
        "CiaoCiao", "Drake", "Anne", "Balico", "CiaoCiao" };
    Map<String, Long> nameOccurrences =
        Stream.of( names )
              .map( s -> "CiaoCiao".equalsIgnoreCase( s ) ? "Captain CiaoCiao" : s )
              .collect( Collectors.groupingBy( String::toLowerCase, Collectors.counting() ) );
    System.out.println( nameOccurrences );
    //end::solution[]
  }
}

package com.tutego.exercises.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ConvertToMap {

  //tag::solution[]
  public static Map<String, String> convertToMap( String[][] array ) {
    if ( array.length == 0 )
      return Collections.emptyMap();

    Map<String,String> map = new HashMap<>();

    for ( String[] row : array )
      map.put( row[ 0 ], row[ 1 ] );

    return map;
  }
  //end::solution[]

  public static void main( String[] args ) {
    Map<String, String> colorMap = convertToMap( new String[][]{
        { "rot", "#FF0000" },
        { "grün", "#00FF00" },
        { "blau", "#0000FF" }
    } );
    System.out.println( colorMap ); // {blau=#0000FF, grün=...
  }
}
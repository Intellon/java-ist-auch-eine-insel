package com.tutego.exercises.util;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class FamilyNames {

  public static void main( String[] args ) {
    //tag::solution[]
    TreeMap<Integer, List<String>> map = new TreeMap<>();

    InputStream resource = FamilyNames.class.getResourceAsStream( "family-names.txt" );
    try ( Scanner scanner = new Scanner( resource ) ) {
      while ( scanner.hasNextLine() ) {
        String line = scanner.nextLine();
        int index = line.length();
        if ( !map.containsKey( index ) ) {
          // Noch keine Liste
          map.put( index, new ArrayList<>() );
        }
        map.get( index ).add( line );
      }
    }
    
    for ( Integer len : map.keySet() ) {
      System.out.println( map.get( len ) );
    }
    //end::solution[]
  }
}
package com.tutego.exercises.lang;

import java.io.*;
import java.nio.file.Paths;
import java.util.*;

public class FrequenzLeser {
  private static HashMap<String, Double> map = new HashMap<>();

  static {
    try ( Scanner lesen = new Scanner( Paths.get( "freq.txt" ) ) ) {
      String line1, line2;

      while ( true ) {
        line1 = lesen.nextLine();

        if ( line1 == null )
          break;

        line2 = lesen.nextLine();

        if ( line2 == null )
          break;

        String freqString = new StringTokenizer( line2 ).nextToken().replace( ',', '.' );

        double freq = Double.parseDouble( freqString );

        map.put( line1, Double.valueOf( freq ) );

        // System.out.println(zeile1 + " : " + freq);
      }
    }
    catch ( IOException e ) {
      System.err.println( "Fehler beim Dateizugriff" );
    }
  }

  static double stationNameToFrequency( String s ) {
    Object o = map.get( s );

    return ((Double) o).doubleValue();
  }

  public static void main( String[] args ) {
    stationNameToFrequency( "SWR 1" );
  }
}
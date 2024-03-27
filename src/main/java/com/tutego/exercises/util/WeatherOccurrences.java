package com.tutego.exercises.util;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class WeatherOccurrences {

  //tag::solution[]
  public static class WeatherOccurrence {
    public String weather;
    public int occurrences;
    public int startIndex;

    WeatherOccurrence( String weather, int occurrences, int startIndex ) {
      this.weather = weather;
      this.occurrences = occurrences;
      this.startIndex = startIndex;
    }

    @Override public String toString() {
      return "weather='" + weather + '\'' + ", occurrence=" + occurrences + ", startIndex=" + startIndex;
    }
  }

  static WeatherOccurrence longestSequenceOfSameWeather( List<String> array ) {
    String recurringElement = array.get( 0 );

    int localMaxOccurrences = 1;
    int localStartIndex = 0;

    int globalMaxOccurrences = localMaxOccurrences;
    int globalStartIndex = localStartIndex;

    for ( int i = 1; i < array.size(); i++ ) {
      String currentElement = array.get( i );

      if ( Objects.equals( currentElement, recurringElement ) ) {
        localMaxOccurrences++;

        if ( localMaxOccurrences > globalMaxOccurrences ) {
          globalMaxOccurrences = localMaxOccurrences;
          globalStartIndex = localStartIndex;
        }
      }
      else { // currentElement != recurringElement
        localStartIndex = i;
        localMaxOccurrences = 1;
        recurringElement = currentElement;
      }
    }

    return new WeatherOccurrence( recurringElement, globalMaxOccurrences, globalStartIndex );
  }
  //end::solution[]

  public static void main( String[] args ) {
    System.out.println(
        longestSequenceOfSameWeather( Arrays.asList( "1", "2", "3", "4", "5", "5", "2", "2", "2", "1", "1", "2" ) ) );
    System.out.println( longestSequenceOfSameWeather( Arrays.asList( "1", "2", "3", "4", "5", "5", "2", "2", "2" ) ) );
    System.out.println( longestSequenceOfSameWeather( Arrays.asList( "1", "1" ) ) );
    System.out.println( longestSequenceOfSameWeather( Arrays.asList( "1" ) ) );
  }
}

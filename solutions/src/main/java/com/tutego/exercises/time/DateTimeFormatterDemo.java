package com.tutego.exercises.time;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class DateTimeFormatterDemo {
  public static void main( String[] args ) {
    //tag::solution[]
    LocalDate now = LocalDate.now().plusYears( 2 );
    System.out.println( now );

    DateTimeFormatter formatterShort = DateTimeFormatter.ofLocalizedDate( FormatStyle.SHORT );
    DateTimeFormatter formatterMedium = DateTimeFormatter.ofLocalizedDate( FormatStyle.MEDIUM );
    DateTimeFormatter formatterLong = DateTimeFormatter.ofLocalizedDate( FormatStyle.LONG );
    DateTimeFormatter formatterFull = DateTimeFormatter.ofLocalizedDate( FormatStyle.FULL );

    System.out.println( now.format( formatterShort ) );
    System.out.println( now.format( formatterMedium ) );
    System.out.println( now.format( formatterLong ) );
    System.out.println( now.format( formatterFull ) );

    System.out.println( now.format( formatterShort.withLocale( Locale.CANADA_FRENCH ) ) );
    System.out.println( now.format( formatterMedium.withLocale( Locale.CHINESE ) ) );
    System.out.println( now.format( formatterLong.withLocale( Locale.ITALIAN ) ) );
    System.out.println( now.format( formatterFull.withLocale( new Locale( "th" ) ) ) );
    //end::solution[]
  }
}

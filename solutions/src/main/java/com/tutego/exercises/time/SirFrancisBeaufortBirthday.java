package com.tutego.exercises.time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class SirFrancisBeaufortBirthday {
  public static void main( String[] args ) {
    //tag::solution[]
    LocalDate beaufortBirthday = LocalDate.of( 1774, Month.MAY, 27 );
    LocalDate beaufortBirthdayThisYear = beaufortBirthday.withYear( Year.now().getValue() );
    LocalDate beaufortBirthdayThisYear2 = LocalDate.of( LocalDate.now().getYear(),
                                                        beaufortBirthday.getMonth(),
                                                        beaufortBirthday.getDayOfMonth() );

    DayOfWeek dayOfWeek = beaufortBirthdayThisYear.getDayOfWeek();
    String s = dayOfWeek.getDisplayName( TextStyle.FULL, Locale.GERMANY );
    System.out.println( s );

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "EEEE", Locale.GERMAN );
    System.out.println( beaufortBirthdayThisYear.format( formatter ) );
    //end::solution[]
  }
}


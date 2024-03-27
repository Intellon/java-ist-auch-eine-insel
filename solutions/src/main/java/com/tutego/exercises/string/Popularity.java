package com.tutego.exercises.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Popularity {

  public static void main( String[] args ) {
    //tag::solution[]
    String text = "Mach mir ein Baby #CaptainCiaoCiao\n" +
                  "Hey @CaptainCiaoCiao, wo ist der Einstellungstest?\n" +
                  "What is a hackers favorite pop group? The Black IP’s.";

    Pattern pattern = Pattern.compile( "[#@]CaptainCiaoCiao" );
    Matcher matcher = pattern.matcher( text );

    int count = 0;
    while ( matcher.find() )
      count++;

    System.out.println( count );
    //end::solution[]

    System.out.println( pattern.matcher( text ).results().count() );
  }
}

package com.tutego.exercises.net;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class CityDistance {

  // FIXME
  public static void main( String[] args ) throws IOException {
    Document doc = Jsoup.connect( "http://www.postleitzahl.org/entfernung.html" )
            .data( "type", "query" )
            .data( "form[city1]", "44369" )
            .data( "form[city2]", "47665" )
            .data( "submit", "\"Entfernung+berechnen\"" )
            .userAgent( "Mozilla" ).post();
    String kmString = doc.select( "div[style]:contains(km)" ).text();
    System.out.println( kmString );
    @SuppressWarnings( "resource" )
    int km = Math.round( new Scanner( kmString ).useLocale( Locale.US ).nextFloat() );
    System.out.println( km );
  }
}

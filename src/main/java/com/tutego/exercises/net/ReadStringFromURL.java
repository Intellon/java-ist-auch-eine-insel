package com.tutego.exercises.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class ReadStringFromURL {
  public static void main( String[] args ) {
    System.out.println( readFileFromUrl( "http://tutego.de/java/aufgaben/bond.txt" ) );
  }

  static public String readFileFromUrl( String url ) {
    StringBuilder sb = new StringBuilder( 1024 );

    String linesep = System.lineSeparator();

    try ( InputStream is = new URL( url ).openStream();
          BufferedReader data = new BufferedReader( new InputStreamReader( is ) ) ) {
      String line;

      while ( (line = data.readLine()) != null )
        sb.append( line ).append( linesep );
    }
    catch ( MalformedURLException e ) {
      System.out.println( "MalformedURLException" );
      System.out.println( e );
    }
    catch ( IOException e ) {
      System.out.println( "IOException" );
      System.out.println( e );
    }
    catch ( Exception e ) {
      System.out.println( "Anderer Fehler" );
      System.out.println( e );
    }

    return sb.toString();
  }
}
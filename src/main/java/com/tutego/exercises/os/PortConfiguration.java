package com.tutego.exercises.os;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class PortConfiguration {
  //tag::solution[]
  private static final String PORT = "port";

  static OptionalInt parseInt( String value ) {
    try {
      return OptionalInt.of( Integer.parseInt( value ) );
    }
    catch ( NumberFormatException e ) {
      return OptionalInt.empty();
    }
  }

  static int getPort( String[] args ) {

    // Step 1
    for ( String arg : args ) {
      if ( arg.startsWith( "--" + PORT + "=" ) ) {
        OptionalInt maybePort = parseInt( arg.substring( ("--" + PORT + "=").length() ) );
        if ( maybePort.isPresent() )
          return maybePort.getAsInt();
      }
    }

    // Step 2

    OptionalInt maybePortProperty = parseInt( System.getProperty( PORT ) );
    if ( maybePortProperty.isPresent() )
      return maybePortProperty.getAsInt();

    // Step 3

    String filename = "/application.properties";
    try ( InputStream is = PortConfiguration.class.getResourceAsStream( filename ) ) {
      Properties properties = new Properties();
      properties.load( is );
      OptionalInt maybePortApplicationProperty = parseInt( properties.getProperty( PORT ) );
      if ( maybePortApplicationProperty.isPresent() )
        return maybePortApplicationProperty.getAsInt();
    }
    catch ( IOException e ) {
    }

    // Step 4

    return 8080;
  }
  //end::solution[]

  public static void main( String[] args ) {
    System.out.println( getPort( args ) );
  }
}

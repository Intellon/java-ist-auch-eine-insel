package com.tutego.exercises.string;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class GenerateSVGfromCSVcoordinates {

  public static void main( String[] args ) throws IOException {
    //tag::solution[]
    String filename = "coordinates.csv";
    try ( InputStream  is = GenerateSVGfromCSVcoordinates.class.getResourceAsStream( filename );
          Scanner scanner = new Scanner( is, StandardCharsets.ISO_8859_1 ) ) {
      scanner.useDelimiter( ";|\\s+" );

      StringBuilder svg = new StringBuilder( 1024 );
      svg.append( "<svg height=\"210\" width=\"500\">\n<polygon points=\"" );

      while ( scanner.hasNext() ) {
        String x = scanner.next();

        if ( ! scanner.hasNext() )
          throw new IllegalStateException( "Missing second coordinate" );

        String y = scanner.next();
        svg.append( x ).append( "," ).append( y ).append( " " );
      }

      svg.append( "\" style=\"fill:lime;stroke:purple;stroke-width:1\" />\n</svg>" );
      System.out.println( svg );
      //end::solution[]
    }
  }
}

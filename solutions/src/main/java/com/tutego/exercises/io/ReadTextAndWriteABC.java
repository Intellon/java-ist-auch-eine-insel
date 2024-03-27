package com.tutego.exercises.io;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class ReadTextAndWriteABC {

  // System.out.println( Arrays.stream( musicalNote ).map( s -> '"' + s + '"' ).collect( Collectors.joining(", ") ) );
  // "C,", "D,", "E,", "F,", "G,", "A,", "B,", "C", "D", "E", "F", "G", "A", "B", "c", "d", "e", "f", "g", "a", "b", "c'", "d'", "e'", "f'", "g'", "a'", "b'"

  //tag::solution[]
  // Sorted array of musical notes
  private static final String[] MUSICAL_NOTES = {
      "A", "A,", "B", "B,", "C", "C,", "D", "D,", "E", "E,", "F", "F,", "G", "G,",
      "a", "a'", "b", "b'", "c", "c'", "d", "d'", "e", "e'", "f", "f'", "g", "g'"
  };

  public static void readTextAndWriteAsABC( String source, String target ) {
    try ( Scanner in      = new Scanner( Paths.get( source ) );
          PrintWriter out = new PrintWriter( target ) ) {

      out.println( "M:C" );
      out.println( "L:1/4" );
      out.println( "K:C" );

      while ( in.hasNextLine() ) {
        String line = in.nextLine().trim();
        int pos = Arrays.binarySearch( MUSICAL_NOTES, line );
        if ( pos >= 0 ) {
          out.print( line );
          out.print( ' ' );
        }
      }
    }
    catch ( IOException e ) {
      System.err.println( "Cannot convert text file due to an input/output error" );
      e.printStackTrace();
    }
  }
  //end::solution[]

  public static void main( String[] args ) throws IOException, URISyntaxException {
    String filename = "musical-notes.txt";
    String source = Path.of( ReadTextAndWriteABC.class.getResource( filename ).toURI() ).toString();
    String target = Files.createTempFile( "musical-note", ".txt" ).toString();
    System.out.println( source );
    System.out.println( target );
    readTextAndWriteAsABC( source, target );
  }
}
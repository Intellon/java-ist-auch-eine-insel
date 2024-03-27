package com.tutego.exercises.optim;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

public class StopWords {
  public static final String[] ENGLISH_STOP_WORDS = {
      "a", "and", "are", "as", "at", "be", "but", "by", "for", "if", "in", "into", "is", "it",
      "no", "not", "of", "on", "or", "s", "such", "t", "that", "the", "their", "then", "there",
      "these", "they", "this", "to", "was", "will", "with"
  };

  public static void main( String[] args ) {
    try ( Scanner scanner = new Scanner( Paths.get( "The Battle Of The Strong, Gilbert Parker.txt" ) ) ) {

      HashSet<String> set = new HashSet<String>( Arrays.asList( ENGLISH_STOP_WORDS ) );
      int count = 0;

      while ( scanner.hasNextLine() ) {
        String line = scanner.nextLine();
        StringTokenizer st = new StringTokenizer( line, " \t\n\r\"\'.,;?!:+-_" );

        while ( st.hasMoreTokens() ) {
          String tok = st.nextToken().toLowerCase();

          if ( set.contains( tok ) )
            continue;

          // System.out.println( tok );

          count++;
        }
      }
      System.out.println( "count = " + count );
    }
    catch ( IOException e ) {
      e.printStackTrace();
    }
  }
}

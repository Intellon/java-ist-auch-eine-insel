package com.tutego.exercises.optim;

import java.io.BufferedReader;
import java.io.FileReader;

public class StopWords2 {

  public static final String[] ENGLISH_STOP_WORDS = {
      "a", "and", "are", "as", "at", "be", "but", "by", "for", "if", "in", "into", "is", "it",
      "no", "not", "of", "on", "or", "s", "such", "t", "that", "the", "their", "then", "there",
      "these", "they", "this", "to", "was", "will", "with"
  };

  public static void main( String[] args ) {
    String path = "C:/";

    // http://www.gutenberg.org/dirs/6/2/3/6236/6236.txt

    try ( BufferedReader in = new BufferedReader( new FileReader( path + "6236.txt" ) ) ) {

      String line;
      int count = 0;

      while ( (line = in.readLine()) != null ) {
        String[] strings = line.split( "(\\s|\\p{Punct})+" );

        for ( int i = 0; i < strings.length; i++ ) {
          String tok = strings[ i ].toLowerCase();
          System.out.println( tok );
          // wenn kein Stopp-Wort, dann count++;
        }
      }
      System.out.println( "count = " + count );
    }
    catch ( Exception e ) {
      e.printStackTrace();
    }
  }
}
package com.tutego.exercises.util;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class WordSequence {

  //    for ( int start = 0; start < string.length(); start++ ) {
  //      for ( int len = 3; len <= string.length() - start; len++ ) {
  //        String word = string.substring( start, start + len );
  //        System.out.println( word );
  //      }
  //    }

  //tag::solution[]
  private static final String WORD_LIST_URL =
      "https://raw.githubusercontent.com/dwyl/english-words/master/words_alpha.txt";

  private static Collection<String> readWords() throws IOException {
    URL url = new URL( WORD_LIST_URL );
    // 370.000 words
    Collection<String> words = new HashSet<>( 500_000 );
    try ( Scanner scanner = new Scanner( url.openStream() ) ) {
      while ( scanner.hasNextLine() )
        words.add( scanner.nextLine() );
    }
    return words;
  }

  static List<String> wordList( Collection<String> words, String string ) {
    List<String> result = new ArrayList<>();
    for ( int start = 0; start < string.length(); start++ ) {
      for ( int len = 3; len <= string.length() - start; len++ ) {
        String word = string.substring( start, start + len );
        System.out.println( word );
        if ( words.contains( word ) )
          result.add( word );
      }
    }
    return result;
  }
  //end::solution[]

  /*
  //tag::solution2[]
  static class WordSplitter implements Iterator<String> {
    private final String string;
    int start, len = 3;

    public WordSplitter( String string ) {
      this.string = string;
    }

    @Override public boolean hasNext() {
      return start < string.length() && len <= string.length() - start;
    }

    @Override public String next() {
      String result = string.substring( start, start + len );
      len++;
      if ( len > string.length() - start ) {
        len = 3;
        start++;
      }
      return result;
    }
  }

  static List<String> wordList( Set<String> words, String string ) {
    List<String> result = new ArrayList<>();
    Iterator<String> splitter = new WordSplitter( string );
    while ( splitter.hasNext() ) {
      String word = splitter.next();
      if ( words.contains( word ) )
        result.add( word );
    }
    return result;
  }
  //end::solution2[]
  */

  public static void main( String[] args ) throws IOException {
    Collection<String> words = readWords();
    String s = "wristwatches";
    System.out.println( wordList( words, s ) );
  }
}

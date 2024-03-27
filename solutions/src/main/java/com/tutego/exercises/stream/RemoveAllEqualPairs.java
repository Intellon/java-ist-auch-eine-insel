package com.tutego.exercises.stream;

import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RemoveAllEqualPairs {
  public static void main( String[] args ) {
    String lines =
        "Spanien\n" +
            "Kokain\n" +
            "Niederlande\n" +
            "Cannabis\n" +
            "Island\n" +    // <-
            "Cannabis\n" +  // <-
            "USA\n" +
            "Cannabis\n" +
            "Norwegen\n" +
            "Alkohol\n" +
            "Deutschland\n" +
            "Alkohol\n" +
            "Island\n" +   // <-
            "Cannabis";    // <-

    // "(?m)(^.*$\n?){2}
    Pattern pattern = Pattern.compile( "(^.*$\n?)" + // A line
                                           "{2}",        // two lines
                                       Pattern.MULTILINE );
    String s = new Scanner( lines )
        .findAll( pattern )
        .map( MatchResult::group )
        .distinct()
        .collect( Collectors.joining() );
    System.out.println( s );
  }
}

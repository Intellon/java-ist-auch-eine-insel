package com.tutego.exercises.net;

// Based on version from Kathy Lo

import java.util.*;

public class SimpleEliza {
  
  private static Map<String, String> keywords;
  private static Map<String, String> startPhrases;
  private static Random random = new Random();

  String[] unknowns = {"Please elaborate on that a little more.", "Please, do go on.",
                       "I'm not sure I understand what you're getting at.",
                       "Why do you think this is so?"};

  /**
   * Initializes our random number generator and adds keywords to our hashtables
   */
  public SimpleEliza() {
    keywords = new HashMap<String, String>();
    keywords.put( "classes", "school" );
    keywords.put( "apples", "apples" );
    keywords.put( "you", "me" );

    startPhrases = new HashMap<String, String>();
    startPhrases.put( "i hate *KEYWORD*", "Why do you hate *KEYWORD* ?" );
    startPhrases.put( "i have a problem with *KEYWORD*",
                      "Is it because of *KEYWORD* that you came to see me?" );
  }

  /*
   * Processes whatever our patient says.
   */
  public String response( String said ) {
    String answer = "";
    String curr = "";
    String keystring = "";
    String keyword = "";
    Vector<String> vec = new Vector<String>();
    StringTokenizer patient = new StringTokenizer( said );
    StringTokenizer doctor;

    // Build up a search string first

    while ( patient.hasMoreTokens() ) {
      curr = patient.nextToken();
      if ( keywords.containsKey( curr ) ) {
        keyword = keywords.get( curr );
        vec.addElement( "*KEYWORD*" );
      }
      else
        vec.addElement( curr );
    }

    for ( Enumeration<String> e = vec.elements();
          e.hasMoreElements();
          keystring = keystring + e.nextElement() + " " )
      ;

    keystring = keystring.trim();

    if ( startPhrases.containsKey( keystring ) ) {
      doctor = new StringTokenizer( (startPhrases.get( keystring )) );
      while ( doctor.hasMoreTokens() ) {
        curr = doctor.nextToken();
        if ( curr.equals( "*KEYWORD*" ) )
          answer = answer + keyword + " ";
        else
          answer = answer + curr + " ";
      }
    }
    else
      answer = unknowns[ random.nextInt( unknowns.length ) ];

    return answer;
  }

  /**
   * A simple main.
   */
  public static void main( String[] args ) {
    SimpleEliza e = new SimpleEliza();

    System.out.println( e.response( "I have to much money." ) );
    System.out.println( e.response( "Was that not a simple question?" ) );
  }
}

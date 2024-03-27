package com.tutego.exercises.optim;

import java.util.StringTokenizer;

public class SplitPerformance {

  static void splitTest1( String s ) {
    StringTokenizer st = new StringTokenizer( s );

    int len = 0;
    while ( st.hasMoreTokens() )
      len += st.nextToken().length();

    // Use the value in a silly way
    System.getProperties().setProperty( "len", "" + len );
  }

  static void splitTest2( String s ) {
    String[] tokens = s.split( "\\s" );

    int len = 0;
    for ( int i = 0; i < tokens.length; i++ )
      len += tokens[ i ].length();

    // Use the value in a silly way
    System.getProperties().setProperty( "len", "" + len );
  }

  public static void main( String[] args ) {
    StringBuffer sb = new StringBuffer();
    for ( int i = 0; i < 10000; sb.append( "Hallo Welt\n" ).append( i++ ) )
      ;
    String s = sb.toString();
    splitTest1( s );
    splitTest2( s );
  }
}
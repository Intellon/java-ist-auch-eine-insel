package com.tutego.exercises.util;

import java.util.*;
import java.util.Map.Entry;

//tag::solution[]
public class Emails {
  
  private Map<String, String> emails = new HashMap<>();

  public void add( String name, String email ) {
    emails.put( name, email );
  }

  public String lookup( String name ) {
    return emails.get( name );
  }

  public void list() {
    Set<Map.Entry<String, String>> entrySet = emails.entrySet();

    for ( Iterator<Entry<String, String>> iterator = entrySet.iterator(); iterator.hasNext(); ) {
      Map.Entry<String, String> entry = iterator.next();

      System.out.println( entry.getKey() + "=" + entry.getValue() );
    }
  }

  public String containsSearch( String name ) {
    Iterator<String> i = emails.keySet().iterator();

    while ( i.hasNext() ) {
      String s = i.next();

      if ( s.contains( name ) )
        return lookup( s );
    }
    return null;
  }

  public static void main( String[] args ) {
    Emails emails = new Emails();

    emails.add( "Albert", "albert@a.com" );
    emails.add( "Caesar", "cesar@a.com" );
    emails.add( "Berta", "berta@a.com" );

    emails.list();

    System.out.println( emails.containsSearch("aes") );
  }
}
//end::solution[]

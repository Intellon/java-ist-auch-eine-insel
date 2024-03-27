package com.tutego.exercises.string;

import java.util.Scanner;

public class TonyTheDefiant {

  public static void main( String[] args ) {
    //tag::solution[]
    String input = new Scanner( System.in ).nextLine().trim();
    if ( input.equalsIgnoreCase( "Keine Ahnung?" ) )
      System.out.println( "Aye!" );
    else if ( input.endsWith( "?" ) ) {
      System.out.println( input + " Keine Ahnung!" );
    }
    //end::solution[]
  }
}
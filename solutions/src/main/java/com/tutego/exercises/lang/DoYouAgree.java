package com.tutego.exercises.lang;

public class DoYouAgree {

  public static void main( String[] args ) {
    //tag::solution[]
    String input = new java.util.Scanner( System.in ).next();

    switch ( input ) {
      case "Ay":
      case "Ay, ay":
      case "Ein Ei":
      case "yes":
      case "ja":
        System.out.println( "Deine Freundschaft ist wertvoll für mich!" );
        break;

      default :
        System.out.println( "Das wirst du bereuen!" );
    }
    //end::solution[]
  }
}
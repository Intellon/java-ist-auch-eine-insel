package com.tutego.exercises.lang;

public class FairShare {

  public static void main( String[] args ) {
    //tag::solution[]
    int loot = new java.util.Scanner( System.in ).nextInt();

    int captainShare = loot / 2;
    int crewShare = loot - captainShare;

    System.out.println( "Loot for captain: " + captainShare );
    System.out.println( "Loot for all crew members: " + crewShare );

    int crewMembers = new java.util.Scanner( System.in ).nextInt();
    System.out.println( "Fair share without remainder? " + (crewShare % crewMembers == 0) );
    //end::solution[]
  }
}

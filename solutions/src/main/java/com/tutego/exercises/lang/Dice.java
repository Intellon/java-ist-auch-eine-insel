package com.tutego.exercises.lang;

public class Dice {
  //tag::solution[]
  public static void main( String[] args ) {
    long bet = 1000;

    int round = 0;
    do {
      int diceSum = dice() + dice();
      System.out.printf( "Runde %d, Betrag %d, Würfelsumme %d%n", round, bet, diceSum );

      switch ( diceSum ) {
        case 12:
          bet *= 2;
          break;

        case 11:
          bet += 2000;
          break;

        case 10:
          bet += 1000;
          break;

        case 9:
        case 8:
        case 7:
        case 6:
          break;

        default:
          bet = bet - 1000;
      }
      System.out.printf( "Runde %d, Betrag nach Regeln %d%n", round++, bet );

    } while ( bet >= 0 && bet < 1_000_000 );

    System.out.printf( "Gewinn/Verlust für den Spieler: %,.0f", (double) bet );
  }

  static int dice() {
    return new java.util.Random().nextInt( 6 /* 0..5 */ ) + 1 /* 1..6 */;
  }
  //end::solution[]
}
package com.tutego.exercises.array;

public class SaltySnook {
  //tag::solution[]
  public static boolean isProbablyApproaching( String[] signs ) {

    if ( signs == null || signs.length == 0 )
      return false;

    String lastSign = signs[ 0 ];
    int count = 1;

    final int OCCURRENCES = 4;

    for ( int i = 1; i < signs.length; i++ ) {
      String currentSign = signs[ i ];
      if ( currentSign.equals( lastSign ) ) {
        count++;
        if ( count == OCCURRENCES )
          return true;
      }
      else {
        lastSign = currentSign;
        count = 1;
      }
    }

    return false;
  }
  //end::solution[]

  public static void main( String[] args ) {
    String[] signs1 = { "F", "DO", "MOS", "MOS", "MOS", "MOS", "WES" };
    System.out.println( isProbablyApproaching( signs1 ) );   // true

    String[] signs2 = { "F", "DO", "MOS", "MOS", "WES", "MOS", "MOS" };
    System.out.println( isProbablyApproaching( signs2 ) );  // false
  }
}

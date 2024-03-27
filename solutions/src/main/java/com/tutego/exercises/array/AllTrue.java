package com.tutego.exercises.array;

public class AllTrue {

  //tag::solution[]
  private static boolean allTrue( boolean first, boolean... remaining ) {

    if ( first == false )
      return false;

    if ( remaining == null || remaining.length == 0 )
      return true;

    for ( boolean b : remaining )
      if ( b == false )
        return false;

    return true;
  }
  //end::solution[]

  public static void main( String[] args ) {
    System.out.println( allTrue( true, true, true ) );
    System.out.println( allTrue( true ) );
    System.out.println( allTrue( true, false ) );
  }
}

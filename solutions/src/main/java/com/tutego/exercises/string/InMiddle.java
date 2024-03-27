package com.tutego.exercises.string;

public class InMiddle {

  //tag::solution[]
  public static boolean isStringInMiddle( String string, String middle ) {

    if ( middle.length() > string.length() )
      return false;

    int start = string.length() / 2 - middle.length() / 2;
    return string.regionMatches( start, middle, 0 /* middle offset */, middle.length() );
  }

  public static boolean isCaptainCiaoCiaoInMiddle( String string ) {
    return isStringInMiddle( string, "CiaoCiao" );
  }
  //end::solution[]

  public static void main( String[] args ) {
    System.out.println( isCaptainCiaoCiaoInMiddle( "a" ) );
    System.out.println( isCaptainCiaoCiaoInMiddle( "bab" ) );
    System.out.println( isCaptainCiaoCiaoInMiddle( "bba" ) );
    System.out.println( isCaptainCiaoCiaoInMiddle( "CiaoCiao" ) );
    System.out.println( isCaptainCiaoCiaoInMiddle( "!CiaoCiao!" ) );
    System.out.println( isCaptainCiaoCiaoInMiddle( "SupaCiaoCiaoCute" ) );
    System.out.println( isCaptainCiaoCiaoInMiddle( "_CiaoCia" ) );
    System.out.println( isCaptainCiaoCiaoInMiddle( "\t\tCiaoCiao  " ) );
    System.out.println( isCaptainCiaoCiaoInMiddle( "BabyTigerChristine" ) );
  }
}

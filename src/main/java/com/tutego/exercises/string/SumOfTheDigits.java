package com.tutego.exercises.string;

public class SumOfTheDigits {

  //tag::solution[]
  static int sumOfTheDigits( long value ) {
    return sumOfTheDigits( String.valueOf( value ) );
  }

  static int sumOfTheDigits( String value ) {
    int sum = 0;

    for ( int i = 0; i < value.length(); i++ )
      // sum += value.charAt( i ) - '0';
      sum += Character.getNumericValue( value.charAt( i ) );

    return sum;
  }
  //end::solution[]

  public static void main( String[] args ) {
    System.out.println( sumOfTheDigits( "12345" ) ); // 15
    System.out.println( sumOfTheDigits( 12345 ) ); // 15
  }
}
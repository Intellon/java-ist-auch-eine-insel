package com.tutego.exercises.lang;

public class HasCommonDigits {

  public static void main( String[] args ) {

    //tag::solution[]
    System.out.println( "Bitte zwei Zahlen zwischen 0 und 99 eingeben:" );
    int number1 = new java.util.Scanner( System.in ).nextInt() % 100;
    int number2 = new java.util.Scanner( System.in ).nextInt() % 100;

    int number1digit1 = number1 / 10;
    int number1digit2 = number1 % 10;
    int number2digit1 = number2 / 10;
    int number2digit2 = number2 % 10;

    boolean hasCommonDigits =    number1digit1 == number2digit1
                              || number1digit1 == number2digit2
                              || number1digit2 == number2digit1
                              || number1digit2 == number2digit2;
    System.out.println( hasCommonDigits );
    //end::solution[]
  }
}

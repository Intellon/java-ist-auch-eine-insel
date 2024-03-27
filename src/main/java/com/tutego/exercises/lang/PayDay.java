package com.tutego.exercises.lang;

public class PayDay {
  public static void main( String[] args ) {
    //tag::solution[]
    double tortsPayment = new java.util.Scanner( System.in ).nextDouble();

    double minPayment = 1000;
    minPayment -= minPayment * 0.1;
    double maxPayment = 1000;
    maxPayment += maxPayment * 0.2;

    // Lösung 1
    if ( tortsPayment >= minPayment && tortsPayment <= maxPayment )
      System.out.println( "Top!" );
    else
      System.out.println( "Beim Klabautermann!" );

    // Lösung 2
    if ( tortsPayment < minPayment || tortsPayment > maxPayment )
      System.out.println( "Beim Klabautermann!" );
    else
      System.out.println( "Top!" );
    //end::solution[]
  }
}
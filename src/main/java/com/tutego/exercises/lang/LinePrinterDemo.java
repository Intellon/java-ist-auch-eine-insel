package com.tutego.exercises.lang;

public class LinePrinterDemo {

  public static void main( String[] args ) {
    //tag::solution1[]
    LinePrinter.lines();
    //end::solution1[]

    //tag::solution2[]
    int len = new java.util.Scanner( System.in ).nextInt();
    LinePrinter.lines( len );
    System.out.println();

    LinePrinter.lines( 4, '*' );
    System.out.println();

    LinePrinter.lines( "{", 4, '*', "}" );
    System.out.println();
    //end::solution2[]

    LinePrinter.lines( 10, "Oma" );
  }
}


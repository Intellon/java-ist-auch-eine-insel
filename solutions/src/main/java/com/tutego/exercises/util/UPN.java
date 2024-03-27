package com.tutego.exercises.util;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Queue;

public class UPN {
  public static void main( String[] args ) {
    //tag::solution[]
    String input = "160 50 30 + /";
    Queue<Integer> stack = Collections.asLifoQueue( new ArrayDeque<>() );


    for ( String token : input.split( "\\s+" ) ) {
      if ( token.matches( "\\d+" ) )
        stack.add( Integer.parseInt( token ) );
      else if ( token.matches( "[+*/-]" ) ) {
        int operand2 = stack.remove();
        int operand1 = stack.remove();
        switch ( token ) {
          case "+": stack.add( operand1 + operand2 ); break;
          case "-": stack.add( operand1 - operand2 ); break;
          case "*": stack.add( operand1 * operand2 ); break;
          case "/": stack.add( operand1 / operand2 ); break;
        }
      }
      else
        System.out.println( "Unbekannter Typ!" );
    }
    System.out.printf( "Ergebnis: %d", stack.remove() );
    //end::solution[]
  }
}
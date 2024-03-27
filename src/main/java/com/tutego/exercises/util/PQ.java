package com.tutego.exercises.util;

import java.util.PriorityQueue;

public class PQ {
  public static void main( String[] args ) {
    PriorityQueue<Integer> q = new PriorityQueue<>();
    q.add( Integer.valueOf( 1 ) );
    q.add( Integer.valueOf( 9 ) );
    q.add( Integer.valueOf( 3 ) );
    q.add( Integer.valueOf( 10 ) );

    System.out.println( q.remove() );
    System.out.println( q.remove() );
    System.out.println( q.remove() );

    System.out.println();

    q.add( Integer.valueOf( 1 ) );
    q.add( Integer.valueOf( 12 ) );

    System.out.println( q.remove() );
    System.out.println( q.remove() );
    System.out.println( q.remove() );
  }
}
package com.tutego.exercises.oop;

//tag::solution[]
public class Tracer {

  private static boolean tracingIsOn;

  public static void on() {
    tracingIsOn = true;
  }

  public static void off() {
    tracingIsOn = false;
  }

  public static void trace( String msg ) {
    if ( tracingIsOn )
      System.out.println( msg );
  }

  public static void trace( String format, Object... args ) {
    if ( tracingIsOn )
      System.out.printf( format, args );
  }
}
//end::solution[]

class TracerDemo {
  public static void main( String[] args ) {
    Tracer.on();
    Tracer.trace( "Start" );
    int i = 2;
    Tracer.off();
    Tracer.trace( "i = " + i );
    Tracer.on();
    Tracer.trace( "End" );
  }
}
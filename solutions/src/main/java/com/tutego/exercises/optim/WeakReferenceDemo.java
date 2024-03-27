package com.tutego.exercises.optim;

import java.lang.ref.*;

public class WeakReferenceDemo {

  public static void main( String[] args ) {

    refQueue();

    // refTest();
    // memoryTest();
  }

  public static void refQueue() {

    Object o = new StringBuilder( "a" );

    ReferenceQueue<Object> rq = new ReferenceQueue<Object>();
    WeakReference<Object> wr = new WeakReference<Object>( o, rq );

    try {
      while ( true ) {
        Reference<?> r = rq.poll();
        if ( r == wr )
          System.out.println( "nicht mehr referenziert" );
        else
          System.out.println( "referenziert" );
        Thread.sleep( 1000 );
      }
    }
    catch ( InterruptedException ex ) {
      ex.printStackTrace();
    }
  }

  public static void refTest() {

    Reference<StringBuilder> weakRef = new WeakReference<StringBuilder>( new StringBuilder( "a" ) );
    Reference<StringBuilder> softRef = new SoftReference<StringBuilder>( new StringBuilder( "b" ) );

    int max = 25;
    boolean infinite = true;

    String[] mem = new String[max];
    mem[ 0 ] = "        ";

    int i = -1;

    try {
      System.out.println( printMem() );
      for ( i = 1; i < max || infinite; ++i ) {
        mem[ i ] = mem[ i - 1 ] + mem[ i - 1 ];
        if ( weakRef.get() != null )
          System.out.print( i + " weak da, " );
        else
          System.out.print( i + " weak wech, " );

        if ( softRef.get() != null )
          System.out.println( "soft da." );
        else
          System.out.println( "soft wech." );
      }
    }
    catch ( Throwable th ) {
      if ( weakRef.get() != null ) {
        System.out.print( i + " weak da, " );
      }
      else {
        System.out.print( i + " weak wech, " );
      }

      if ( softRef.get() != null ) {
        System.out.println( "soft da.\n" );
      }
      else {
        System.out.println( "soft wech.\n" );
      }

      th.printStackTrace();

      System.out.println( "\niterations " + i + "\n" );
      System.out.println( printMem() );
    }
  }

  public static void memoryTest() {

    int max = 25;
    boolean infinite = true;

    String[] mem = new String[max];
    mem[ 0 ] = "        ";

    int i = -1;

    try {
      System.out.println( printMem() );
      for ( i = 1; i < max || infinite; i++ )
        mem[ i ] = mem[ i - 1 ] + mem[ i - 1 ];
    }
    catch ( Throwable th ) {
      th.printStackTrace();
      System.out.println( "\niterations " + i + "\n" );
      System.out.println( printMem() );
    }
  }

  public static String printMem() {

    Runtime runtime = Runtime.getRuntime();

    long total = runtime.totalMemory() / 1024;
    long max = runtime.maxMemory() / 1024;
    long free = runtime.freeMemory() / 1024;
    long used = total - free;

    return "total: " + total + " KB\nmax: " + max + " KB\nfree: " + free + " KB\nused: " + used + " KB";
  }
}
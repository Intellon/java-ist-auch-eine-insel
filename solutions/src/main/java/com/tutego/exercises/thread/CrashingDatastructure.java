package com.tutego.exercises.thread;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class CrashingDatastructure {

  //tag::solution[]
  public static void main( String[] args ) throws InterruptedException {
    fillMap( new HashMap<>() );
    fillMap( Collections.synchronizedMap( new HashMap<>() ) );
    fillMap( new ConcurrentHashMap<>() );
    fillMap( new Hashtable<>() );
  }

  private static void fillMap( Map<Integer, Integer> map ) throws InterruptedException {
    AtomicInteger counter = new AtomicInteger( 0 );
    Runnable run = () -> {
      for ( int i = 0; i < 1000; i++ )
        map.put( counter.getAndIncrement(), i );
    };

    Thread[] threads = { new Thread( run ), new Thread( run ), new Thread( run ) };
    Arrays.asList( threads ).forEach( Thread::start );
    for ( Thread t : threads ) t.join();

    System.out.printf( "Expected %d elements and got %d%n", threads.length * 1000, map.size() );
  }
  //end::solution[]
}
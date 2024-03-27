package com.tutego.exercises.thread;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.*;

public class LoadingShips {

  public static void main( String[] args ) {
    //tag::solution[]
    class Producer implements Runnable {
      final private BlockingQueue<String> ramp;
      final String[] products = { "Rum", "Wein", "Salami", "Bier", "Käse", "Comics" };

      Producer( BlockingQueue<String> ramp ) {
        this.ramp = ramp;
      }

      @Override
      public void run() {
        try {
          while ( true ) {
            String product = products[ ThreadLocalRandom.current().nextInt( products.length ) ]
                             + ":" + UUID.randomUUID().toString();
            ramp.put( product );
            System.out.printf( "Produkt mit ID %s auf die Rampe gelegt%n", product );
            TimeUnit.MILLISECONDS.sleep( ThreadLocalRandom.current().nextInt( 1000, 2000) );
          }
        }
        catch ( InterruptedException e ) {
          e.printStackTrace();
        }
      }
    }
    class Consumer implements Runnable {
      private final BlockingQueue<String> ramp;

      Consumer( BlockingQueue<String> ramp ) {
        this.ramp = ramp;
      }

      @Override
      public void run() {
        try {
          while ( true ) {
            String product = ramp.take();
            System.out.printf( "Produkt mit ID %s von der Rampe genommen%n", product );
            TimeUnit.MILLISECONDS.sleep( ThreadLocalRandom.current().nextInt( 1000, 2000 ) );
          }
        }
        catch ( InterruptedException e ) {
          e.printStackTrace();
        }
      }
    }

    BlockingQueue<String> ramp = new ArrayBlockingQueue<>( 10 );
    ExecutorService threadPool = Executors.newCachedThreadPool();

    for ( int i = 0; i < 5; i++ ) threadPool.execute( new Consumer( ramp ) );
    for ( int i = 0; i < 10; i++ ) threadPool.execute( new Producer( ramp ) );
    //end::solution[]
  }
}

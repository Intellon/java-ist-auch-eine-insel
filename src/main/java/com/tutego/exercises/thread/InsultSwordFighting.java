package com.tutego.exercises.thread;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class InsultSwordFighting {
  public static void main( String[] args ) {
    //tag::solution[]
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    class Insulter implements Runnable {
      private final String[] insults;

      public Insulter( String[] insults ) {
        this.insults = insults;
      }

      @Override public void run() {
        while ( true ) {
          try {
            lock.lock();
            Thread.sleep( ThreadLocalRandom.current().nextInt( 1000 ) );
            String name = Thread.currentThread().getName();
            String insult = insults[ ThreadLocalRandom.current().nextInt( insults.length ) ];
            System.out.println( name + ": " + insult + '!' );
            condition.signalAll();
            condition.await();
          }
          catch ( InterruptedException e ) { /* Ignore */ }
          finally {
            lock.unlock();
          }
        }
      }
    }

    String[] insults1 = { "You have the manners of a trump", "You fight like a cow cocky" };
    String[] insults2 = { "I've spoken with rats more polite than you",
                          "You make me want to spew" };

    new Thread( new Insulter( insults1 ), "pirate-1" ).start();
    new Thread( new Insulter( insults2 ), "pirate-2" ).start();
    //end::solution[]
  }
}
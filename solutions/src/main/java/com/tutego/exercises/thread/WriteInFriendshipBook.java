package com.tutego.exercises.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class WriteInFriendshipBook {

  public static void main( String[] args ) throws InterruptedException {
    class FriendshipBook {
      private final StringBuilder text = new StringBuilder();

      public void appendChar( char character ) {
        text.append( character );
      }

      public void appendDivider() {
        text.append(
            "\n_,.-'~'-.,__,.-'~'-.,__,.-'~'-.,__,.-'~'-.,__,.-'~'-.,_\n" );
      }

      @Override public String toString() {
        return text.toString();
      }
    }

    //tag::solution[]
    Lock lock = new ReentrantLock( true );

    class Autor implements Runnable {
      private final String text;
      private final FriendshipBook book;

      public Autor( String text, FriendshipBook book ) {
        this.text = text;
        this.book = book;
      }

      @Override public void run() {
        try {
          lock.lock();
          for ( int i = 0; i < text.length(); i++ ) {
            book.appendChar( text.charAt( i ) );
            Thread.sleep( 1 );
          }
          book.appendDivider();
        }
        catch ( InterruptedException e ) { /* Ignore */ }
        finally {
          lock.unlock();
        }
      }
    }
    //end::solution[]

    FriendshipBook book = new FriendshipBook();

    String q1 = "Die Blumen brauchen Sonnenschein " +
        "und ich brauch Capatain CiaoCiao zum Fröhlichsein";
    new Thread( new Autor( q1, book ) ).start();

    String q2 = "Wenn du lachst, lachen sie alle. " +
        "Wenn du weinst, weinst du alleine";
    new Thread( new Autor( q2, book ) ).start();

    TimeUnit.SECONDS.sleep( 1 );

    System.out.println( book );
  }
}
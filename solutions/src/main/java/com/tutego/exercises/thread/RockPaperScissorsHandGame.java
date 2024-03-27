package com.tutego.exercises.thread;

import java.util.*;
import java.util.concurrent.*;

public class RockPaperScissorsHandGame {

  enum HandSign {
    ROCK, PAPER, SCISSORS;
    static HandSign random() { return values()[ (int)(Math.random() * 3 ) ]; }
  }

  public static void main( String[] args ) {

    final Queue<HandSign> handSigns = new ArrayBlockingQueue<>( 2 );

    Runnable barrierAction = () -> {
      HandSign handSign1 = handSigns.poll();
      HandSign handSign2 = handSigns.poll();
      System.out.printf( "Wahl: %s und %s%n", handSign1, handSign2 );
      // Wer gewinnt?
      if ( handSign1 == handSign2 )
        System.out.println( "Unentschieden" );
      else if ( handSign1 == HandSign.ROCK && handSign2 == HandSign.SCISSORS ||
          handSign1 == HandSign.PAPER && handSign2 == HandSign.ROCK )
        System.out.println( "Spieler 1 gewinnt, Spieler 2 verliert" );
      else
        System.out.println( "Spieler 2 gewinnt, Spieler 1 verliert" );
    };
    final CyclicBarrier barrier = new CyclicBarrier( 2, barrierAction );

    Runnable handSignCommand = new Runnable() {
      @Override public void run() {
        try {
          handSigns.add( HandSign.random() );
          barrier.await();
        }
        catch ( InterruptedException | BrokenBarrierException e ) {
          e.printStackTrace();
        }
      }
    };

    ScheduledExecutorService executor = Executors.newScheduledThreadPool( 2 );
    // Zwei (namenlose) Spieler machen jede Sekunde ein Handzeichen
    executor.scheduleAtFixedRate( handSignCommand, 0, 1, TimeUnit.SECONDS );
    executor.scheduleAtFixedRate( handSignCommand, 0, 1, TimeUnit.SECONDS );
  }
}
package com.tutego.exercises.oop.observer;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class _PlayingRadioForListerners {
  //tag::solution[]
  static class Listener implements Observer {
    private final String remark;
    public Listener( String remark ) { this.remark = remark; }

    @Override
    public void update( Observable observable, Object o ) {
      System.out.println( remark + ", sie spielen " + o.toString() );
    }
  }

  static class Radio extends Observable {
    public Radio() {
      Runnable playing = () -> {
        while ( true ) {
          try {
            nextSong( "Alle über Bord" );
            TimeUnit.SECONDS.sleep( 1 );
          }
          catch ( InterruptedException e ) {
          }
        }
      };
      Executors.newCachedThreadPool().submit( playing );
    }

    public void addListener( Listener listener ) {
      addObserver( listener );
    }

    private void nextSong( String title ) {
      setChanged();
      notifyObservers( title );
    }
  }

  public static void main( String[] args ) {
    Radio radio = new Radio();
    Listener listener1 = new Listener( "Yea" );
    Listener listener2 = new Listener( "Geil" );
    Listener listener3 = new Listener( "Cool" );
    radio.addObserver( listener1 );
    radio.addObserver( listener2 );
    radio.addObserver( listener3 );
  }
  //end::solution[]
}
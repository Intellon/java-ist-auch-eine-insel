package com.tutego.exercises.thread;

class Paintbox {

  private int maximumNumberOfPens;
  private int currentNumberOfPens;

  public Paintbox( int maximumNumberOfPens ) {
    this.maximumNumberOfPens = maximumNumberOfPens;
    currentNumberOfPens = this.maximumNumberOfPens;

    System.out.println( "Paintbox has " + currentNumberOfPens + " Pens" );
  }

  public synchronized void takePen( int numberOfPens ) {
    while ( currentNumberOfPens < numberOfPens ) {
      System.out.println( "gewuenscht: " + numberOfPens + ", vorhanden: " + currentNumberOfPens );
      try {
        wait();
      }
      catch ( InterruptedException e ) {
        e.printStackTrace();
      }
    }
    currentNumberOfPens -= numberOfPens;
  }

  public synchronized void returnPen( int anzahl ) {
    currentNumberOfPens += anzahl;

    if ( currentNumberOfPens > maximumNumberOfPens ) {
      System.out.println( "Irgendjemand gibt zu viele Stifte zurueck!" );
      currentNumberOfPens = maximumNumberOfPens;
    }

    notifyAll();
  }
}

class Child implements Runnable {
  private String name;
  private Paintbox paintbox;

  public Child( String name, Paintbox paintbox ) {
    this.name = name;
    this.paintbox = paintbox;
  }

  @Override
  public void run() {
    for ( int i = 1; i < 5; i++ ) {
      int anzahlStifte = (int) (Math.random() * 10 + 1);

      paintbox.takePen( anzahlStifte );

      System.out.println( name + " hat beim " + i + ". Mal " + anzahlStifte + " Stifte geholt." );

      try {
        Thread.sleep( (long) (Math.random() * 3000) );
      }
      catch ( InterruptedException e ) {
        e.printStackTrace();
      }

      paintbox.returnPen( anzahlStifte );

      System.out.println( name + " hat beim " + i + ". Mal " + anzahlStifte
                              + " Stifte zurueckgegeben." );

      try {
        Thread.sleep( (int) (Math.random() * 2000) );
      }
      catch ( InterruptedException e ) {
        e.printStackTrace();
      }
    }
  }
}

public class Kindergarten {

  public static void main( String[] args ) {
    Paintbox paintbox = new Paintbox( 12 );

    Thread mirijam = new Thread( new Child( "Mirijam", paintbox ) );
    Thread susanne = new Thread( new Child( "Susanne", paintbox ) );
    Thread soeren = new Thread( new Child( "Soeren", paintbox ) );
    Thread ylem = new Thread( new Child( "ylem", paintbox ) );

    mirijam.start();
    susanne.start();
    soeren.start();
    ylem.start();
  }
}

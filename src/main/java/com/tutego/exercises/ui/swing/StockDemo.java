package com.tutego.exercises.ui.swing;

import javax.swing.AbstractListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListModel;

public class StockDemo {

  public static void main( String[] args ) {
    JFrame f = new JFrame();
    f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

    ListModel<?> model = new StockModel();
    JList<?> myList = new JList<>( model );

    JScrollPane scrollpane = new JScrollPane( myList );

    f.getContentPane().add( scrollpane );

    f.pack();
    f.setVisible( true );
  }
}

class Stock extends Thread {

  String name;
  double value;

  Stock( String name, double value ) {
    this.name = name;
    this.value = value;
    start();
  }

  @Override
  public void run() {
    while ( true ) {
      value += (int) ((Math.random() - 0.5) * 20);
      try {
        Thread.sleep( 1000 );
      }
      catch ( InterruptedException e ) {
      }

      // System.out.println( toString() );
    }
  }

  @Override
  public String toString() {
    return name + " " + value;
  }
}

class StockModel extends AbstractListModel<Stock> implements Runnable {
  Stock[] stock = {
      new Stock( "IBM", 200 ), new Stock( "Sun", 100 ), new Stock( "Unilog", 20 )
  };

  StockModel() {
    new Thread( this ).start();
  }

  @Override
  public void run() {
    while ( true ) {
      fireContentsChanged( this, 0, stock.length );

      try {
        Thread.sleep( 1000 );
      }
      catch ( InterruptedException e ) {
      }

      // System.out.println( toString() );
    }
  }

  @Override
  public int getSize() {
    return stock.length;
  }

  @Override
  public Stock getElementAt( int pos ) {
    return stock[ pos ];
  }
}
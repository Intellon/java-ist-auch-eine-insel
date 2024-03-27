package com.tutego.exercises.ui;

import java.awt.*;
import java.awt.event.*;

public class MausInTitelleiste2 {

  public static void main( String[] args ) {
    Frame f = new Frame();

    f.addMouseMotionListener( new MyMML2( f ) );
    f.addWindowListener( new MyWL2() );
    f.setSize( 400, 400 );
    f.setVisible( true );
  }
}

class MyMML2 implements MouseMotionListener {
  
  Frame frame;

  public MyMML2( Frame f ) {
    frame = f;
  }

  @Override
  public void mouseDragged( MouseEvent e ) {
  }

  @Override
  public void mouseMoved( MouseEvent e ) {
    frame.setTitle( " X = " + e.getX() + " / Y = " + e.getY() );
  }
}

class MyWL2 extends WindowAdapter {

  @Override
  public void windowClosing( WindowEvent e ) {
    System.exit( 0 );
  }
}
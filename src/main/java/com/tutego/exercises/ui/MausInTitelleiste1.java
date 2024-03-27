package com.tutego.exercises.ui;

import java.awt.*;
import java.awt.event.*;

public class MausInTitelleiste1 extends Frame implements WindowListener, MouseMotionListener {

  private static final long serialVersionUID = -4674769350085614286L;

  MausInTitelleiste1() {
  }

  @Override
  public void windowActivated( WindowEvent e ) {
  }

  @Override
  public void windowClosed( WindowEvent e ) {
  }

  @Override
  public void windowClosing( WindowEvent e ) {
    System.exit( 0 );
  }

  @Override
  public void windowDeactivated( WindowEvent e ) {
  }

  @Override
  public void windowDeiconified( WindowEvent e ) {
  }

  @Override
  public void windowIconified( WindowEvent e ) {
  }

  @Override
  public void windowOpened( WindowEvent e ) {
  }

  @Override
  public void mouseDragged( MouseEvent e ) {
  }

  @Override
  public void mouseMoved( MouseEvent e ) {
    this.setTitle( e.getPoint().toString() );
  }

  public static void main( String[] args ) {
    MausInTitelleiste1 f = new MausInTitelleiste1();
    f.addWindowListener( f );
    f.addMouseMotionListener( f );
    f.setSize( 600, 400 );
    f.setLocation( 100, 100 );
    f.setVisible( true );
  }
}
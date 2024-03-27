package com.tutego.exercises.ui;

import java.awt.*;
import java.awt.event.*;

public class CloseAFrame extends Frame implements WindowListener {

  private static final long serialVersionUID = 4516134741737546337L;

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

  public static void main( String[] args ) {
    CloseAFrame f = new CloseAFrame();
    f.addWindowListener( f );
    f.setSize( 400, 300 );
    f.setLocation( 100, 100 );
    f.setVisible( true );
  }
}
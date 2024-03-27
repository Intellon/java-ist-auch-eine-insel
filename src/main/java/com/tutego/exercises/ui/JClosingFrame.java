package com.tutego.exercises.ui;

import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class JClosingFrame extends JFrame {
  private static final long serialVersionUID = -7771396977825907867L;

  public JClosingFrame() {
    addWindowListener( new ClosingWindowListener() );
    setDefaultCloseOperation( JFrame.DO_NOTHING_ON_CLOSE );
  }
}

class ClosingWindowListener implements WindowListener {
  @Override
  public void windowClosing( WindowEvent we ) {
    int res = JOptionPane.showConfirmDialog( null,
                                             "Soll das Fenster denn wirklich geschlossen werden?",
                                             "Fensterchen schließen", JOptionPane.YES_NO_OPTION );

    if ( res == JOptionPane.YES_OPTION )
      System.exit( 0 );
  }

  @Override
  public void windowActivated( WindowEvent e ) {
  }

  @Override
  public void windowClosed( WindowEvent e ) {
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
}

package com.tutego.exercises.ui.swing;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ProgressMonitorInputStream;

public class ProgressFrame extends JFrame {

  private JButton button;
  private JTextArea text;

  public ProgressFrame() {
    JPanel panel = new JPanel( new BorderLayout( 6, 6 ) );
    panel.setBorder( BorderFactory.createEmptyBorder( 6, 6, 6, 6 ) );

    button = new JButton( "Laden" );
    button.addActionListener( e -> {
      button.setEnabled( false );
      // setCursor( JFrame.WAIT_CURSOR );
      new Thread( () -> ProgressFrame.this.choosedButton() ).start();
    } );

    text = new JTextArea( 20, 80 );
    text.setEditable( false );

    panel.add( button, BorderLayout.NORTH );
    panel.add( new JScrollPane( text ), BorderLayout.CENTER );

    this.getContentPane().add( panel );
    this.pack();
  }

  private void choosedButton() {
    StringBuilder textbuffer = new StringBuilder();
    text.setText( "" );

    try ( InputStream in = new FileInputStream( "readme.html" );
          ProgressMonitorInputStream pmin = new ProgressMonitorInputStream( null, "laden...", in );
          BufferedReader br = new BufferedReader( new InputStreamReader( pmin ) ) ) {
      int nr = 1;

      String line;
      while ( (line = br.readLine()) != null ) {
        textbuffer.append( getLineNr( nr++ ) );
        textbuffer.append( line );
        textbuffer.append( '\n' );
      }
    }
    catch ( Exception e ) {
      if ( e instanceof InterruptedIOException )
        textbuffer.append( "Laden abgebrochen!" );
      else
        e.printStackTrace();
    }
    text.setText( textbuffer.toString() );

    button.setEnabled( true );
    // setCursor( JFrame.DEFAULT_CURSOR );
  }

  private static String getLineNr( int nr ) {
    // TODO: Printf umschreiben
    String res = "00000" + nr + ":";
    return res.substring( res.length() - 6, res.length() );
  }
}
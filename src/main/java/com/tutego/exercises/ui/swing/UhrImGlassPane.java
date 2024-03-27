package com.tutego.exercises.ui.swing;
import java.awt.BorderLayout;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UhrImGlassPane
{
  public static void main( String[] args )
  {
    JFrame f = new JFrame();
    
    f.getContentPane().add( new JButton( "Mitte" ) );
    f.getContentPane().add( new JButton( "Norden" ), BorderLayout.NORTH );

    final JLabel time = new JLabel();
    
    JPanel glass = (JPanel) f.getGlassPane();
    glass.add( time );
    glass.setVisible( true );

    new Thread( new Runnable()
    {
      @Override
      public void run()
      {
        while ( true )
        {
          try
          {
            time.setVisible( true );
            Thread.sleep( 1000 );
            time.setText( new Date().toString() );
            time.setVisible( false );
            Thread.sleep( 1000 );
            
          }
          catch ( InterruptedException e ) { }
        }

      }
    }).start();
    
    f.setSize(200,200);

    f.setVisible( true );
  }
}

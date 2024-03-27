package com.tutego.exercises.ui.swing;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class JCountingButton extends JButton implements MouseListener
{
  private static final long serialVersionUID = 8651850485227077117L;
  
  private int     start;
  private boolean ende;

  public JCountingButton( int start )
  {
    this.start = start;
    
    setText( Integer.toString(start) );

    addMouseListener( this );
  }

  class CountingRunnable implements Runnable
  {
    @Override
    public void run()
    {
      sleep( 500 );

      while ( ! ende )
      {
        ++start;
        setText( "" + start );
        
        sleep( 200 );
      }

      ende = false;
    }
    
    private void sleep( int ms )
    {
      try
      {
        Thread.sleep( ms );
      }
      catch ( InterruptedException e ) { }
    }
  }

  // MouseListener

  @Override
  public void mousePressed( MouseEvent e )
  {
    new Thread( new CountingRunnable() ).start();
  }

  @Override
  public void mouseReleased( MouseEvent e )
  {
    ende = true;
  }

  @Override
  public void mouseClicked( MouseEvent e ) { }

  @Override
  public void mouseEntered( MouseEvent e ) { }

  @Override
  public void mouseExited( MouseEvent e ) { }
}

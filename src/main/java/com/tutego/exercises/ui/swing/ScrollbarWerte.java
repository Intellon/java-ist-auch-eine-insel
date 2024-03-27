package com.tutego.exercises.ui.swing;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JFrame;
import javax.swing.JScrollBar;

public class ScrollbarWerte extends JFrame
{
  ScrollbarWerte()
  {
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    
    JScrollBar scroll = new JScrollBar( JScrollBar.HORIZONTAL );
    getContentPane().add( scroll );
    
    scroll.addAdjustmentListener( new AdjustmentListener() {
          @Override
          public void adjustmentValueChanged( AdjustmentEvent e )
          {
            System.out.println( "Markierung: " + e.getValue() );
          }
        } );
    
    pack();
    setVisible( true );
  }
  
  public static void main( String[] args )
  {
    new ScrollbarWerte();
  }
}






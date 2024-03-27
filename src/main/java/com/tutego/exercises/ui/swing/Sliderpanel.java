package com.tutego.exercises.ui.swing;

import javax.swing.*;
import javax.swing.event.*;

public class Sliderpanel extends JFrame
{
  Sliderpanel()
  {
    JSlider slider = new JSlider( JSlider.HORIZONTAL, 0, 100, 10 );
    slider.addChangeListener( new SliderListener() );
    slider.setMajorTickSpacing( 20 );
    slider.setPaintTicks( true );
    slider.setPaintLabels( true );

    getContentPane().add( slider );
  }

  public static void main( String[] args )
  {
    JFrame info = new Sliderpanel();
    info.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    info.pack();
    info.setVisible( true );
  }
}

class SliderListener implements ChangeListener
{
  @Override
  public void stateChanged( ChangeEvent e )
  {
    JSlider source = (JSlider) e.getSource();
    if ( !source.getValueIsAdjusting() )
    {
      int result = (int) source.getValue();
      System.out.println( result );
    }
  }
}

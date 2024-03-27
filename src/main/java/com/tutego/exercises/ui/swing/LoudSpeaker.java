package com.tutego.exercises.ui.swing;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPopupMenu;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class LoudSpeaker extends JFrame {

  public LoudSpeaker() {

    getContentPane().setLayout( new FlowLayout() );
    JButton jey = new JButton( new ImageIcon( "image/speaker.png" ) );
    getContentPane().add( jey );

    final JPopupMenu popup = new JPopupMenu();
    JSlider jsl = new JSlider();
    jsl.setOrientation( JSlider.VERTICAL );
    jsl.setMajorTickSpacing( 10 );
    jsl.setPaintTicks( true );
    jsl.setPaintLabels( true );
    jsl.setBorder( BorderFactory.createEmptyBorder( 10, 10, 10, 10 ) );

    jsl.addChangeListener( new ChangeListener() {
      @Override
      public void stateChanged( ChangeEvent e ) {
        JSlider source = (JSlider) e.getSource();

        if ( !source.getValueIsAdjusting() ) {
          int volume = (int) source.getValue();

          System.out.println( volume );
        }
      }
    } );

    popup.add( jsl );
    jey.addMouseListener( new MouseAdapter() {
      @Override
      public void mousePressed( MouseEvent e ) {
        if ( e.isPopupTrigger() ) {
          popup.show( e.getComponent(), e.getX(), e.getY() );
        }
      }

      @Override
      public void mouseReleased( MouseEvent e ) {
        mousePressed( e );
      }
    } );

    pack();
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
  }

  public static void main( String[] args ) {
    new LoudSpeaker().setVisible( true );
  }
}
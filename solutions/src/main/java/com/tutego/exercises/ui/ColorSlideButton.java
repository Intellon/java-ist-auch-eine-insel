package com.tutego.exercises.ui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ColorSlideButton extends JFrame {

  private static final long serialVersionUID = -5588265872465629666L;

  public ColorSlideButton() {
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    setSize( 255, 255 );

    JLabel hello = new JLabel( "Beweg deine Maus!", JLabel.CENTER );
    hello.setOpaque( true ); // nicht transparent
    hello.addMouseMotionListener( new FarbMML() );

    getContentPane().add( hello );
  }

  public static void main( String[] args ) {
    new ColorSlideButton().setVisible( true );
  }

  static class FarbMML implements MouseMotionListener {
 
    @Override
    public void mouseDragged( MouseEvent e ) {
    }

    @Override
    public void mouseMoved( MouseEvent e ) {
      JLabel myLabel = (JLabel) e.getSource();
      // myLabel.setText(""+e.getPoint());

      int x = e.getX() * 255 / myLabel.getWidth();
      int y = e.getY() * 255 / myLabel.getHeight();

      Color c1 = new Color( 0, x, y );
      myLabel.setForeground( c1 );

      Color c2 = new Color( 255, 255 - x, 255 - y );
      myLabel.setBackground( c2 );
    }
  }
}
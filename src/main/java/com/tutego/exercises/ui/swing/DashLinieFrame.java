package com.tutego.exercises.ui.swing;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class DashLinieFrame extends JFrame {

  private static final long serialVersionUID = -1476525310356077243L;

  private JToggleButton[] button = new JToggleButton[16];
  private DashLineIcon lineIcon = new DashLineIcon();
  private JLabel iconLabel;

  class MyChangeListener implements ChangeListener {
    @Override
    public void stateChanged( ChangeEvent e ) {
      boolean[] bytes = new boolean[16];

      for ( int i = 0; i < 16; i++ )
        bytes[ i ] = button[ i ].isSelected();

      lineIcon.setArray( bytes );
      iconLabel.repaint();
    }
  }

  public DashLinieFrame() {
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

    getContentPane().setLayout( new BorderLayout() );

    JPanel panel = new JPanel();
    panel.setLayout( new FlowLayout( FlowLayout.CENTER, 0, 0 ) );

    for ( int i = 0; i < 16; i++ ) {
      button[ i ] = new JToggleButton();
      button[ i ].setPreferredSize( new Dimension( 12, 12 ) );
      button[ i ].setBorder( BorderFactory.createEtchedBorder() );
      button[ i ].addChangeListener( new MyChangeListener() );
      panel.add( button[ i ] );
    }

    getContentPane().add( panel, BorderLayout.CENTER );

    iconLabel = new JLabel( lineIcon );
    getContentPane().add( iconLabel, BorderLayout.SOUTH );

    setSize( 300, 100 );
  }

  public static void main( String[] args ) {
    new DashLinieFrame().setVisible( true );
  }
}

class DashLineIcon implements Icon {
  private final static int max = 16;
  private final static int lineLen = 200;

  private boolean[] array = new boolean[max];

  @Override
  public int getIconHeight() {
    return 25;
  }

  @Override
  public int getIconWidth() {
    return lineLen;
  }

  public void setArray( boolean[] dashArray ) {
    array = dashArray;
  }

  @Override
  public void paintIcon( Component c, Graphics g, int x, int y ) {
    Graphics2D g2d = (Graphics2D) g;
    g2d.setStroke( new BasicStroke( 10, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10,
                                    getDashArray( array ), 0 ) );
    g2d.setColor( Color.RED );
    g2d.drawLine( 0, 5, lineLen, 5 );
  }

  private static float[] getDashArray( boolean[] b ) {
    float[] result = new float[max];
    int retPos = 0;
    int position = 1;

    if ( !b[ 0 ] ) {
      result[ 0 ] = 0;
      retPos = 1;
    }

    boolean aktuell = b[ 0 ];
    int count = 1;

    while ( position < b.length ) {
      if ( b[ position++ ] == aktuell )
        count++;
      else {
        result[ retPos++ ] = count;
        count = 1;
        aktuell = !aktuell;
      }
    }
    result[ retPos ] = count;

    return result;
  }
}
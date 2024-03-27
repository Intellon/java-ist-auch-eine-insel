package com.tutego.exercises.ui.swing;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.net.URL;
import javax.swing.ImageIcon;

public class TriImageIcon extends ImageIcon {

  private final static Color TRANSPARENT_GREY = new Color( 0, 0, 0, 0.6f );
  private static final int SIZE = 15;

  private final int[] xp = new int[3];
  private final int[] yp = new int[3];

  public TriImageIcon( String filename ) {
    super( filename );
  }

  public TriImageIcon( URL url ) {
    super( url );
  }

  @Override
  public void paintIcon( Component c, Graphics g, int x, int y ) {
    super.paintIcon( c, g, x, y );

    g.setColor( TRANSPARENT_GREY );

    xp[ 0 ] = getIconWidth() + x;
    yp[ 0 ] = getIconHeight() + y;
    xp[ 1 ] = xp[ 0 ];
    yp[ 1 ] = yp[ 0 ] - SIZE;
    xp[ 2 ] = xp[ 0 ] - SIZE;
    yp[ 2 ] = yp[ 0 ];
    g.fillPolygon( xp, yp, 3 );
  }
}
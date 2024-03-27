package com.tutego.exercises.ui.swing;

import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;

public class SpaceIcon implements Icon {
  public static Icon icon = new SpaceIcon( 16, 1 );

  private int width, height;

  /**
   * @param width
   * @param height
   */
  public SpaceIcon( int width, int height ) {
    this.width = width;
    this.height = height;
  }

  /* (non-Javadoc)
   * @see javax.swing.Icon#getIconHeight()
   */
  @Override
  public int getIconHeight() {
    return height;
  }

  /* (non-Javadoc)
   * @see javax.swing.Icon#getIconWidth()
   */
  @Override
  public int getIconWidth() {
    return width;
  }

  /* (non-Javadoc)
   * @see javax.swing.Icon#paintIcon(java.awt.Component, java.awt.Graphics, int, int)
   */
  @Override
  public void paintIcon( Component c, Graphics g, int x, int y ) {
  }
}

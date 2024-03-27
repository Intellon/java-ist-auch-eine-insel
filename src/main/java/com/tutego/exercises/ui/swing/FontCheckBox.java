package com.tutego.exercises.ui.swing;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FontCheckBox
{
  static JCheckBox cbBold = new JCheckBox( "fett" );
  static JCheckBox cbItalic = new JCheckBox( "kursiv" );
  static JLabel label = new JLabel( "Lorem ipsum dolor ..." );

  public static void main( String[] args )
  {
    JFrame frame = new JFrame();

    StyleItemListener l = new StyleItemListener();
    cbBold.addItemListener( l );
    cbItalic.addItemListener( l );

    label.setFont( new Font( "Verdana", Font.PLAIN, 12 ) );

    frame.getContentPane().add( cbBold, BorderLayout.WEST );
    frame.getContentPane().add( cbItalic, BorderLayout.EAST );
    frame.getContentPane().add( label, BorderLayout.SOUTH );

    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.pack();
    frame.setVisible( true );
  }

  static class StyleItemListener implements ItemListener
  {
    @Override
    public void itemStateChanged( ItemEvent e )
    {
      boolean isBold   = cbBold.isSelected();
      boolean isItalic = cbItalic.isSelected();

      Font font = label.getFont();
      font = font.deriveFont( (isBold ? Font.BOLD : 0)
                            + (isItalic ? Font.ITALIC : 0) );

      label.setFont( font );
    }
  }
}

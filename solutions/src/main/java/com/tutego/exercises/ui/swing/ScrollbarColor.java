package com.tutego.exercises.ui.swing;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Scrollbar;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ScrollbarColor extends Frame
{
  private Scrollbar oben;
  private Canvas center;
  int blauwert;

  ScrollbarColor()
  {
    setLayout( new BorderLayout(5,5) );
    oben = new Scrollbar( Scrollbar.HORIZONTAL, 0, 1, 0, 256 );
    center = new Canvas();
    center.setBackground(new Color (0,0,0));

    oben.addAdjustmentListener( new AdjustmentListener() {
        @Override
        public void adjustmentValueChanged(AdjustmentEvent e)
        {
          blauwert=e.getValue();
          center.setBackground(new Color(0,0,blauwert));
        }
      });

    this.addWindowListener( new WindowAdapter() {
      @Override
      public void windowClosing( WindowEvent e )
      {
        System.out.println("Werde geschlossen (Closing)");
        System.exit(0);
      }
      } );

    add(oben,BorderLayout.NORTH );
    add(center);
    setSize(300,300);
    setVisible(true);
  }

  public static void main(String[] args)
  {
    new ScrollbarColor();
  }
}

package com.tutego.exercises.ui.swing;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;

public class SplitFrameDemo extends JFrame
{
  SplitFrameDemo()
  {
    getContentPane().setLayout(new BorderLayout());

    Splittab st = new Splittab();
    st.add( new ImageIcon("image/hoerer.jpg"), "Telefonh�rer", new JLabel("eins"));
    st.add( new ImageIcon("image/wecker.jpg"), "Wecker", new JLabel("zwei"));
    st.add( new ImageIcon("image/karm.jpg"), "Kalender mit Wecker", new JLabel("Kalender mit Wecker"));
    st.add( new ImageIcon("image/email.jpg"), "email", new JLabel("Email"));
    st.add( new ImageIcon("image/korganizer.jpg"), "Organizer", new JLabel("Organizer"));
    st.add( new ImageIcon("image/kandy.jpg"), "Handy", new JLabel("Handy"));
    st.add( new ImageIcon("image/knotes.jpg"), "Notes", new JLabel("Notes"));
    st.add( new ImageIcon("image/kpilot.jpg"), "Pilot", new JLabel("Pilot"));

    getContentPane().add( st );

    setSize( 700, 600 );
  }

  public static void main( String[] args )
  {
    new SplitFrameDemo().setVisible( true );
  }
}

class Splittab extends JSplitPane
{
  private JPanel left = new JPanel(), right = new JPanel();

  public Splittab()
  {
    super( JSplitPane.HORIZONTAL_SPLIT );

    setLeftComponent(left);
    setRightComponent(right);
    setOneTouchExpandable( true );
    left.setBackground( Color.white );
    left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
  }

  public void add( ImageIcon icon, String text, final JComponent component )
  {
    JButton bt = new JButton(text, icon);
		
    bt.setOpaque( false );
    bt.setBorderPainted(false);
    bt.setAlignmentX(Component.CENTER_ALIGNMENT);
    bt.setVerticalTextPosition( SwingConstants.BOTTOM );
    bt.setHorizontalTextPosition( SwingConstants.CENTER );
    left.add(bt);

    bt.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed( ActionEvent e ) {
        setRightComponent( component );
      }
    });
  }
}

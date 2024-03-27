package com.tutego.exercises.ui.swing;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JInfoFrame extends JFrame
{
  JInfoFrame()
  {
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    
    // Layout

    getContentPane().setLayout( new BorderLayout() );
    
    final JLabel pic = new JLabel( "pic" );
    final JLabel info = new JLabel( "Info" );
    final JButton ok = new JButton( "OK" );

    getContentPane().add( pic, BorderLayout.NORTH );
    getContentPane().add( info, BorderLayout.CENTER );

    JPanel okpanel = new JPanel();
    okpanel.setLayout( new FlowLayout() );
    okpanel.add( ok );

    getContentPane().add( okpanel, BorderLayout.SOUTH );

    pack();
    
    // Ereignisbehandlung
    
    ok.addActionListener( new ActionListener() {
          @Override
          public void actionPerformed( ActionEvent e ) {
            dispose();
            System.exit(0);
          }
        } );
  }
  
  public static void main( String[] args )
  {
    new JInfoFrame().setVisible( true );
  }
}


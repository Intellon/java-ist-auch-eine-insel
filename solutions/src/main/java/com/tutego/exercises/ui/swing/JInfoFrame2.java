package com.tutego.exercises.ui.swing;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

class JInternInfoFrame2 extends JFrame
{
  JInternInfoFrame2()
	{
		// Layout

		getContentPane().setLayout( new BorderLayout() );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		ImageIcon icon = new ImageIcon( "image/kannichhelfen.jpg" );
		ImageIcon icon1 = new ImageIcon( "image/ok.gif" );

		final JLabel pic = new JLabel( icon );
		final JLabel info = new JLabel( "Swing kann auch gut aussehen!" );
		final JButton ok = new JButton( "OK", icon1 );

		ok.setHorizontalTextPosition( JButton.LEFT );

		JPanel okpanel = new JPanel();
		okpanel.setLayout( new FlowLayout() );
		okpanel.add( ok );

		JPanel pane2 = new JPanel();
		pane2.setLayout( new BorderLayout() );
		pane2.add( pic, BorderLayout.CENTER );
		pane2.add( info, BorderLayout.SOUTH );

		getContentPane().add( pane2,BorderLayout.CENTER );
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
}

public class JInfoFrame2
{
	public static void main( String[] args )
	{
	  try
	  {
	    UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName() );
	  } catch( Exception e ) {
	    e.printStackTrace();
	  }

		JFrame info = new JInternInfoFrame2();
		info.setVisible( true );
	}
}

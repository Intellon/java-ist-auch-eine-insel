package com.tutego.exercises.ui.swing;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

class FilofaxText extends JPanel
{
  private static final long serialVersionUID = -83571217946888201L;
  
  private JTextArea taL = new JTextArea();
	private JTextArea taR = new JTextArea();
	
	private ImageIcon icon = new ImageIcon( "C:/Dokumente und Einstellungen/Hans Hodenheber/Desktop/filofax.gif" );
	
	public FilofaxText()
	{
		
		taL.setLineWrap( true );
		taR.setLineWrap( true );
		taL.setWrapStyleWord( true );
		taR.setWrapStyleWord( true );
		
		setLayout( new GridLayout(1, 0, 50, 0) );
		
		setBorder( new EmptyBorder(new Insets(30, 30, 30, 30)) );
		
		add( taL );
		add( taR );
		
		setPreferredSize( new Dimension(icon.getIconWidth()*2, icon.getIconHeight()*2) );
	}
	
	@Override
  public void paintComponent( Graphics g )
	{
		super.paintComponent( g );
		
		if ( icon != null )
			g.drawImage( icon.getImage(), 0, 0, icon.getIconWidth()*2, icon.getIconHeight()*2, this );
	}
}

public class FilofaxTextDemo
{
	public static void main( String[] args )
	{
		JFrame f = new JFrame();
		f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		f.getContentPane().add( new FilofaxText() );
		f.pack();
		f.setVisible( true );
	}
}


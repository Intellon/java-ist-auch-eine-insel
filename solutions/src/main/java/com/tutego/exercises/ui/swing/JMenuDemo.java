package com.tutego.exercises.ui.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.MalformedURLException;
import java.net.URL;

class InternSpaceIcon implements Icon {
  static InternSpaceIcon icon = new InternSpaceIcon();

  @Override
  public int getIconHeight() { return 1; }

  @Override
  public int getIconWidth() { return 16; }

  @Override
  public void paintIcon( Component c, Graphics g, int x, int y ) {
  }
}

public class JMenuDemo {
  public static void main( String[] args ) {
    JFrame f = new JFrame();

    Container container = f.getContentPane();
    container.add( new JLabel( "Hallo Menüs!" ) );

    JMenuBar menuBar = new JMenuBar();

    JMenu menuDatei = new JMenu( "File" );
    menuDatei.setMnemonic( KeyEvent.VK_F );

    ImageIcon imageIcon = null;

    try {
      // TODO
      URL url = new URL( "http://tutego.de/java/aufgaben/insel/images/fileopen_16.png" );
      imageIcon = new ImageIcon( url );
    }
    catch ( MalformedURLException e ) {
      e.printStackTrace();
    }

    JMenuItem menuItemOpen = new JMenuItem( "Open...", imageIcon );
    JMenuItem menuItemClose = new JMenuItem( "Close", InternSpaceIcon.icon );
    JMenuItem menuItemExit = new JMenuItem( "Exit", InternSpaceIcon.icon );

    menuItemOpen.setMnemonic( KeyEvent.VK_O );
    menuItemOpen.setAccelerator(
      KeyStroke.getKeyStroke( 'O', Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx(), false ) );
    menuDatei.add( menuItemOpen );

    menuDatei.add( menuItemClose );

    menuItemExit.setMnemonic( KeyEvent.VK_X );
    menuDatei.add( menuItemExit );

    menuBar.add( menuDatei );

    JMenu menuOptionen = new JMenu( "Options" );
    menuOptionen.setMnemonic( KeyEvent.VK_T );

    menuOptionen.add( new JMenuItem( "Preferences" ) );
    menuBar.add( menuOptionen );

    JMenu menuLookAndFeel = new JMenu( "Look & Feel" );
    menuLookAndFeel.setMnemonic( KeyEvent.VK_K );
    menuBar.add( menuLookAndFeel );

    JMenu menuHilfe = new JMenu( "Help" );
    menuHilfe.setMnemonic( KeyEvent.VK_H );
    menuBar.add( menuHilfe );

    menuHilfe.add( new JMenuItem( "About" ) );

    f.setJMenuBar( menuBar );

    f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    f.setSize( 300, 300 );
    f.setVisible( true );
  }
}

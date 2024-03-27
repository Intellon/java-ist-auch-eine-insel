package com.tutego.exercises.ui.swing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;

public class EditorWithInternalFrames {

  private static final String IMAGE_FILEOPEN_22 = "/image/fileopen_22.png";
  private static final String IMAGE_FILEOPEN_16 = "/image/fileopen_16.png";
  private JFrame frame;
  private JDesktopPane desktopPane;

  EditorWithInternalFrames() {
    initGui();
  }

  /**
   * Method initGui.
   */
  private void initGui() {
    frame = new JFrame();
    desktopPane = new JDesktopPane();

    JMenuBar menuBar;
    JMenu menu; // , submenu;
    JMenuItem menuItem;

    menuBar = new JMenuBar();
    frame.setJMenuBar( menuBar );

    menu = new JMenu( "File" );
    menu.setMnemonic( KeyEvent.VK_F );
    menuBar.add( menu );

    menuItem = new JMenuItem( "Open", KeyEvent.VK_O );

    ActionListener fileOpenActionListener = e -> {
      JFileChooser fc = new JFileChooser();
      fc.setCurrentDirectory( new File( "C://" ) );
      fc.setFileFilter( new TextFileFilter() );
      fc.setAccessory( new PreviewLabel( fc ) );
      int returnVal = fc.showOpenDialog( null );

      if ( returnVal == JFileChooser.APPROVE_OPTION ) {
        File file = fc.getSelectedFile();
        desktopPane.add( createInternalFrame( file ) );
      }
    };

    frame.getContentPane().setLayout( new BorderLayout() );

    JToolBar toolBar = new JToolBar();
    // TODO: classpath
    JButton jey = new JButton( new ImageIcon( IMAGE_FILEOPEN_22 ) );
    jey.addActionListener( fileOpenActionListener );

    toolBar.add( jey );

    frame.getContentPane().add( toolBar, BorderLayout.NORTH );
    frame.getContentPane().add( desktopPane, BorderLayout.CENTER );

    menuItem.addActionListener( fileOpenActionListener );
    menuItem.setIcon( new ImageIcon( IMAGE_FILEOPEN_16 ) );

    menuItem.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_O, ActionEvent.ALT_MASK ) );
    menu.add( menuItem );

    menuItem = new JMenuItem( "Save", SpaceIcon.icon );
    menuItem.setMnemonic( KeyEvent.VK_S );
    menu.add( menuItem );
    menuItem = new JMenuItem( "Close", SpaceIcon.icon );

    menuItem.setMnemonic( KeyEvent.VK_C );
    menu.add( menuItem );
    menuItem = new JMenuItem( "Exit", SpaceIcon.icon );
    menuItem.setMnemonic( KeyEvent.VK_E );
    menu.add( menuItem );

    menuItem.addActionListener( e -> {
      if ( JOptionPane.YES_OPTION ==
          JOptionPane.showConfirmDialog( frame,
                                         "Wirklich Beenden", "hihi",
                                         JOptionPane.YES_NO_OPTION ) ) {
        frame.dispose();
        System.exit( 0 );
      }
    } );

    menu = new JMenu( "More" );
    menu.setMnemonic( KeyEvent.VK_N );
    menuBar.add( menu );

    menuItem = new JMenuItem( "Hilfe" );
    menuItem.addActionListener( e -> {
      JOptionPane.showMessageDialog( frame, "Jetzt haste verspielt" );
      frame.dispose();
      System.exit( 0 );
    } );
    menu.add( menuItem );

    frame.setSize( 400, 400 );
    frame.setVisible( true );

  }

  public static JInternalFrame createInternalFrame( File file ) {
    JInternalFrame jit = new JInternalFrame( file.getName(), true, true, true );
    JTextArea j = new JTextArea();

    jit.setVisible( true );

    jit.setSize( 200, 200 );
    try {
      j.read( new FileReader( file ), null );
    }
    catch ( IOException e ) {
      System.err.println( e );
    }

    JScrollPane jsp = new JScrollPane( j );
    jsp.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
    jit.getContentPane().add( jsp );

    return jit;
  }

  public static void main( String[] args ) {
    try {
      UIManager.setLookAndFeel( "net.sourceforge.mlf.metouia.MetouiaLookAndFeel" );
    }
    catch ( Exception e ) {
    }

    // EditorWithInternalFrames ifo =
    new EditorWithInternalFrames();
  }
}

class TextFileFilter extends FileFilter {
  /**
   * @see javax.swing.filechooser.FileFilter#accept(java.io.File)
   */
  @Override
  public boolean accept( File f ) {
    return f.getName().endsWith( ".txt" ) || f.getName().endsWith( ".java" ) || f.isDirectory();
  }

  /**
   * @see javax.swing.filechooser.FileFilter#getDescription()
   */
  @Override
  public String getDescription() {
    return "Text- und Javadateien";
  }
}

class PreviewLabel extends JLabel implements PropertyChangeListener {
  private static final long serialVersionUID = 1707111350007542432L;
  // private JFileChooser jfc;

  PreviewLabel( JFileChooser fc ) {
    fc.addPropertyChangeListener( this );
  }

  @Override
  public void propertyChange( PropertyChangeEvent e ) {
    String prop = e.getPropertyName();

    if ( JFileChooser.SELECTED_FILE_CHANGED_PROPERTY.equals( prop ) ) {
      File file = (File) e.getNewValue();
      if ( file != null )
        setText( "" + file.length() );
    }
  }
}

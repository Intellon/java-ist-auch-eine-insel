package com.tutego.exercises.ui.swing;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.ListModel;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class DateiVorschau {

  static JTextArea ta = new JTextArea();
  static JFrame frame = new JFrame();

  public static JList<?> liste( String path ) {
    File file = new File( path );
    File[] files = file.listFiles();

    return new JList<>( files );
  }

  public static void main( String[] args ) {
    try {
      UIManager.setLookAndFeel( "com.sun.java.swing.plaf.windows.WindowsLookAndFeel" );
    }
    catch ( Exception ex ) {
      System.out.println( ex );
    }

    MySelectionListener MySL = new MySelectionListener();
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

    ListModel<?> model = new FileListModel( "c:/" );
    JList<?> myList = new JList<>( model );
    myList.addListSelectionListener( MySL );

    JScrollPane scrollpane = new JScrollPane( myList );
    JSplitPane splitpane = new JSplitPane( JSplitPane.HORIZONTAL_SPLIT, scrollpane,
                                           new JScrollPane( ta ) );

    frame.getContentPane().add( splitpane );
    frame.pack();
    frame.setVisible( true );
  }

  static class MySelectionListener implements ListSelectionListener {

    @Override
    public void valueChanged( ListSelectionEvent e ) {
      if ( !e.getValueIsAdjusting() ) {
        JList<?> l = (JList<?>) e.getSource();
        ListModel<?> m = l.getModel();
        File f = (File) m.getElementAt( l.getSelectedIndex() );

        frame.setTitle( f.toString() );

        if ( f.isFile() ) {
          try ( Reader reader = new FileReader( f ) ) {
            ta.read( reader, null );
          }
          catch ( IOException ex ) {
            ex.printStackTrace();
          }
        }
        else
          ta.setText( "Verzeichnis" );
      }
    }
  }
}
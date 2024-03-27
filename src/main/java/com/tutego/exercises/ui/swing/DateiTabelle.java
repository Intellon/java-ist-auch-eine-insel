package com.tutego.exercises.ui.swing;

import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

class SimpleFileTableModel extends AbstractTableModel {

  private static final long serialVersionUID = -8735224753821253688L;

  private final File[] filelist;

  public SimpleFileTableModel( File fstart ) {
    filelist = fstart.listFiles();
  }

  @Override
  public int getRowCount() {
    return filelist.length;
  }

  @Override
  public int getColumnCount() {
    return 3;
  }

  private Icon[] fileIcons = {
      new ImageIcon( getClass().getResource( "/image/file.gif" ) ),
      new ImageIcon( getClass().getResource( "/image/dir.gif" ) )
  };

  @Override
  public Object getValueAt( int row, int column ) {
    switch ( column ) {
      case 0:
        return fileIcons[ filelist[ row ].isFile() ? 0 : 1 ];
      case 1:
        return filelist[ row ].getName();
      case 2:
        return Long.valueOf( filelist[ row ].length() );
    }

    return "ERROR";
  }

  private String[] columnName = {
      "Typ", "Name", "Länge"
  };

  @Override
  public String getColumnName( int col ) {
    return columnName[ col ];
  }

  private Class<?>[] columnTypes = {
      ImageIcon.class, String.class, Long.class
  };

  @Override
  public Class<?> getColumnClass( int col ) {
    return columnTypes[ col ];
  }
}

public class DateiTabelle {

  public static void main( String[] args ) {
    JFrame f = new JFrame();
    f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

    TableModel mtm = new SimpleFileTableModel( new File( "c:/" ) );

    JTable tabelle = new JTable( mtm );

    f.getContentPane().add( new JScrollPane( tabelle ) );
    f.pack();

    f.setVisible( true );
  }
}
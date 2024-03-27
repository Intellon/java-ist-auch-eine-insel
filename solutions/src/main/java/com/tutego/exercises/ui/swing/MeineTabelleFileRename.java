package com.tutego.exercises.ui.swing;

import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

class FileRenameTableModel extends AbstractTableModel {

  private final File[] dateiliste;
  private final long[] fileLength;

  public FileRenameTableModel( File fstart ) {
    dateiliste = fstart.listFiles();
    fileLength = new long[dateiliste.length];
  }

  @Override
  public int getRowCount() {
    return dateiliste.length;
  }

  @Override
  public int getColumnCount() {
    return 3;
  }

  private Icon[] fileIcons = {
      new ImageIcon( getClass().getResource( "image/file.gif" ) ),
      new ImageIcon( getClass().getResource( "image/dir.gif" ) )
  };

  @Override
  public Object getValueAt( int row, int column ) {
    switch ( column ) {
      case 0:
        return fileIcons[ dateiliste[ row ].isFile() ? 0 : 1 ];

      case 1:
        return dateiliste[ row ].getName();

      case 2:
        long len = fileLength[ row ];
        if ( len == 0 )
          len = fileLength[ row ] = dateiliste[ row ].length();
        return Long.valueOf( len );
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

  @Override
  public boolean isCellEditable( int rowIndex, int columnIndex ) {
    return columnIndex == 1;
  }

  @Override
  public void setValueAt( Object aValue, int rowIndex, int columnIndex ) {
    String path = dateiliste[ rowIndex ].getParentFile().getAbsolutePath();

    File newFile = new File( path, aValue.toString() );

    dateiliste[ rowIndex ].renameTo( newFile );
    dateiliste[ rowIndex ] = newFile;

    fireTableCellUpdated( rowIndex, columnIndex );
  }
}

public class MeineTabelleFileRename {

  public static void main( String[] args ) {
    JFrame f = new JFrame();
    f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

    TableModel mtm = new FileRenameTableModel( new File( "c:/" ) );

    JTable tabelle = new JTable( mtm );

    f.getContentPane().add( new JScrollPane( tabelle ) );
    f.pack();

    f.setVisible( true );
  }
}
package com.tutego.exercises.ui.swing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

public class DataBaseTableModel extends AbstractTableModel implements TableModelListener {
  private static final long serialVersionUID = 8169188027150640692L;

  private List<Object[]> cache = new ArrayList<>();

  private String[] headers;

  int colCount;

  public DataBaseTableModel() {
    this.addTableModelListener( this );
    // Add a listener to the list that's notified each time a change to the data
    // model occurs
    this.removeTableModelListener( this );
    // Remove a listener from the list that's notified each time a change to the
    // data model occurs

    try {
      Class.forName( "sun.jdbc.odbc.JdbcOdbcDriver" ); // load JDBC:ODBC bridge
    }
    catch ( ClassNotFoundException e ) {
      e.printStackTrace();
    }
    try ( Connection con = DriverManager.getConnection( "jdbc:odbc:Regenit", "", "" );
          Statement stmt = con.createStatement();
          ResultSet rs = stmt.executeQuery( "SELECT * FROM options" ) ) {
      ResultSetMetaData meta = rs.getMetaData();
      colCount = meta.getColumnCount();
      headers = new String[colCount];

      for ( int i = 0; i < colCount; i++ )
        headers[ i ] = meta.getColumnName( i + 1 );

      while ( rs.next() ) {
        Object[] record = new Object[colCount];

        for ( int i = 0; i < colCount; i++ )
          record[ i ] = rs.getObject( i + 1 );

        cache.add( record );
      }
    }
    catch ( SQLException e ) {
      e.printStackTrace();
    }

    fireTableChanged( null );
    // Forward the given notification event to all TableModelListeners that
    // registered themselves as listeners for this table model
  }

  @Override
  public int getRowCount() {
    return cache.size();
  }

  @Override
  public int getColumnCount() {
    return colCount;
  }

  @Override
  public Object getValueAt( int row, int col ) {
    return cache.get( row )[ col ];
  }

  @Override
  public String getColumnName( int col ) {
    return headers[ col ];
  }

  @Override
  public void tableChanged( TableModelEvent e ) {
  }

  @Override
  public void setValueAt( Object aValue, int rowIndex, int columnIndex ) {
    Object[] record = cache.get( rowIndex );

    record[ columnIndex ] = aValue;
    cache.set( rowIndex, record );

    fireTableCellUpdated( rowIndex, columnIndex );

    // Notify all listeners that the value of the cell at (row, column) has been
    // updated
  }

  @Override
  public boolean isCellEditable( int rowIndex, int columnIndex ) {
    return true;
  }

  @Override
  public Class<? extends Object> getColumnClass( int col ) {
    return getValueAt( 0, col ).getClass();
  }
  /*
   * protected EventListenerList listenerList // List of listeners int findColumn(String columnName); //
   * Convenience method for locating columns by name void fireTableDataChanged(); // Notify all listeners that
   * all cell values in the table's rows may have changed void fireTableRowsDeleted(int firstRow, int
   * lastRow); // Notify all listeners that rows in the (inclusive) range [firstRow, lastRow] have been
   * deleted void fireTableRowsInserted(int firstRow, int lastRow); // Notify all listeners that rows in the
   * (inclusive) range [firstRow, lastRow] have been inserted void fireTableRowsUpdated(int firstRow, int
   * lastRow); // Notify all listeners that rows in the (inclusive) range [firstRow, lastRow] have been
   * updated void fireTableStructureChanged(); // Notify all listeners that the table's structure has changed
   * Class getColumnClass(int columnIndex); // Returns Object.class by default
   */
}

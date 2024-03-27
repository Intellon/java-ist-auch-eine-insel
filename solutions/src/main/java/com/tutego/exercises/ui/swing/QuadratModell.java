package com.tutego.exercises.ui.swing;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class QuadratModell {
  public static void main( String[] args ) {
    JFrame f = new JFrame();

    TableModel mtm = new QuadratTableModel();

    JTable tabelle = new JTable( mtm );

    f.getContentPane().add( new JScrollPane( tabelle ) );
    f.pack();

    f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

    f.setVisible( true );
  }
}

class QuadratTableModel extends AbstractTableModel {
  @Override
  public int getRowCount() {
    return 50;
  }

  @Override
  public int getColumnCount() {
    return 3;
  }

  @Override
  public Object getValueAt( int row, int column ) {
    int wert = row;
    for ( int i = 0; i < column; i++ ) {
      wert = wert * row;
    }
    return Integer.valueOf( wert );
  }

  @Override
  public String getColumnName( int col ) {
    switch ( col ) {
      case 0:
        return "Zahl";
      case 1:
        return "Quadrat";
      default :
        return "Kubik";
    }

  }
}

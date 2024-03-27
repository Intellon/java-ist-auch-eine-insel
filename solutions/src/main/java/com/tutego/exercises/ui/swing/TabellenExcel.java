package com.tutego.exercises.ui.swing;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class TabellenExcel extends JFrame {

  TabellenExcel() {
    final JTable table = new JTable( new DefaultTableModel( 7, 8 ) );
    getContentPane().add( new JScrollPane( table ) );
    setTitle( "Tabelle" );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    setSize( 200, 300 );

    addWindowListener( new WindowAdapter() {
      @Override
      public void windowClosing( WindowEvent e ) {
        // saveTableToExcelSheet(table.getModel(), "c:/tabelle.html");
        String s = saveTableToHtmlString( table.getModel() );
        System.out.println( s );
      }
    } );
  }

  public static void main( String[] args ) {
    new TabellenExcel().setVisible( true );
  }

  public static void saveTableToExcelSheet( TableModel model, String filename ) {
    try ( PrintStream ps = new PrintStream( new FileOutputStream( filename ) ) ) {

      ps.println( "<table>" );

      for ( int i = 0; i < model.getRowCount(); i++ ) {
        ps.println( "<tr>" );

        for ( int j = 0; j < model.getColumnCount(); j++ ) {
          Object o = model.getValueAt( i, j );

          ps.println( "<td>" );
          ps.println( o == null ? "" : o );
          ps.println( "</td>" );
        }

        ps.println( "</tr>" );
      }

      ps.println( "</table>" );
    }
    catch ( FileNotFoundException e ) {
      e.printStackTrace();
    }
  }

  // TODO: Gemeinsamen Programmcode in Methode auslagern
  public static String saveTableToHtmlString( TableModel model ) {
    Writer sw = new StringWriter();

    try ( PrintWriter ps = new PrintWriter( sw ) ) {
      ps.println( "<table>" );

      for ( int i = 0; i < model.getRowCount(); i++ ) {
        ps.println( "<tr>" );

        for ( int j = 0; j < model.getColumnCount(); j++ ) {
          Object o = model.getValueAt( i, j );

          ps.println( "<td>" );
          ps.println( o == null ? "" : o );
          ps.println( "</td>" );
        }
        ps.println( "</tr>" );
      }
      ps.println( "</table>" );
    }

    return sw.toString();
  }
}
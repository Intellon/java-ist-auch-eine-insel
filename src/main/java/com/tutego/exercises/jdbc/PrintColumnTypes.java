package com.tutego.exercises.jdbc;

import java.sql.*;

public class PrintColumnTypes {

  public static void main( String[] args ) throws SQLException {

    DatabaseUtility db = new DatabaseUtility();

    try ( Statement stmt = db.getStatement();
          ResultSet rSet = stmt.executeQuery( "SELECT * FROM geodb_adm1" ) ) {

      ResultSetMetaData rsmd = rSet.getMetaData();

      int columns = rsmd.getColumnCount();

      for ( int i = 1; i <= columns; i++ ) {
        String columnName = rsmd.getColumnName( i );
        int jdbcType = rsmd.getColumnType( i );
        String name = rsmd.getColumnTypeName( i );
        boolean caseSen = rsmd.isCaseSensitive( i );
        boolean writable = rsmd.isWritable( i );

        System.out.println( "Spalte " + columnName + " (" + i + ") ist vom Typ " + name
                            + ", JDBC-Typ " + jdbcType + ", caseSen=" + caseSen + ", writable="
                            + writable );
      }
    }
  }
}

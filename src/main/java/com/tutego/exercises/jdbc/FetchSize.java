package com.tutego.exercises.jdbc;

import java.sql.*;

public class FetchSize {
  public static void main( String[] args ) throws SQLException {
    DatabaseUtility db = new DatabaseUtility();

    try ( Statement stmt = db.getStatement() ) {

      int fetchSize = stmt.getFetchSize();
      System.out.println( fetchSize );

      stmt.setFetchSize( 100 );

      try ( ResultSet rs = stmt.executeQuery( "SELECT * FROM geodb_adm0" ) ) {
        while ( rs.next() ) {
          System.out.print( rs.getString( "adm0" ) + ", " );
          System.out.println( rs.getString( "name" ) );
        }
      }
    }
  }
}

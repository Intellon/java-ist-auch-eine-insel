package com.tutego.exercises.jdbc;

import java.sql.*;

public class Select {
  public static void main( String... args ) throws SQLException {
    DatabaseUtility db = new DatabaseUtility();
    try ( Statement stmt = db.getStatement();
          ResultSet rs = stmt.executeQuery( "SELECT * FROM geodb_adm0" ) ) {
      while ( rs.next() ) {
        System.out.print( rs.getString( "adm0" ) + ", " );
        System.out.println( rs.getString( "name" ) );
      }
    }
  }
}

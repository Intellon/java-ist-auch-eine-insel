package com.tutego.exercises.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UseDatabaseUtility {
  public static void main( String[] args ) throws SQLException {
    DatabaseUtility db = new DatabaseUtility();

    String s = "SELECT * FROM geodb_adm0";
    try ( Statement stmt = db.getStatement();
          ResultSet rSet = stmt.executeQuery( s ) ) {

      while ( rSet.next() )
        System.out.println( rSet.getString( 1 ) + "\t" + rSet.getString( 2 ) );
    }
  }
}
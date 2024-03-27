package com.tutego.exercises.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SimplePostgreSQLAccess {
  public static void main( String[] args ) {
    try {
      Class.forName( "org.postgresql.Driver" );
    }
    catch ( ClassNotFoundException e ) {
      e.printStackTrace();
    }

    try {
      // String URL = "jdbc:mysql://localhost/GeoDaten";
      String url = "jdbc:postgresql://localhost/GeoDaten";
      String sql = "select * from geodb_adm0";
      try ( Connection dbConn = DriverManager.getConnection( url, "postgres", "admin" );
            Statement sqlStmt = dbConn.createStatement(); ResultSet rSet = sqlStmt.executeQuery( sql ) ) {
        while ( rSet.next() ) {
          System.out.println( rSet.getString( 1 ) + "\t" + rSet.getString( 2 ) );
        }
      }
    }
    catch ( Exception e ) {
      System.out.println( "Fehler bei Tabellenabfrage" );
      e.printStackTrace();
    }
  }
}

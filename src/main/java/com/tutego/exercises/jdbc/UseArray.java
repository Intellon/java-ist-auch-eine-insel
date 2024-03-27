package com.tutego.exercises.jdbc;

import java.sql.*;

public class UseArray {
  public static void main( String[] args ) throws SQLException {
    DatabaseUtility db = new DatabaseUtility();

    try ( Statement stmt = db.getStatement();
          ResultSet rs = stmt.executeQuery( "SELECT vector FROM Feld" ) ) {

      // stmt.executeUpdate( "CREATE TABLE Feld ( vector int[] )" );
      // stmt.executeUpdate( "INSERT INTO Feld VALUES ( '{1, 10, 100, 1000, 10000}' ) " );

      rs.next();

      Array array = rs.getArray( 1 );

      System.out.println( array );
      System.out.println( array.getArray().getClass().getName() );

      if ( array.getArray().getClass().isAssignableFrom( int[].class ) ) {
        int[] feld = (int[]) array.getArray();

        for ( int i = 0; i < feld.length; i++ )
          System.out.println( feld[ i ] );
      }
    }
  }
}

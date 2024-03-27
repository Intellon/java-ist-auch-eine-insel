package com.tutego.exercises.jdbc;

import java.sql.*;

public class CallableStatementDemo {
  public static void main( String[] args ) throws SQLException {
    DatabaseUtility db = new DatabaseUtility();

    try ( Connection con = db.getConnection() ) {

      con.setAutoCommit( false );

      try ( CallableStatement stmt = con.prepareCall( "{ ? = call upper( ? ) }" ) ) {
        stmt.registerOutParameter( 1, Types.VARCHAR );
        stmt.setString( 2, "lowercase to uppercase" );
        stmt.execute();

        System.out.println( stmt.getString( 1 ) );
      }
    }
  }
}

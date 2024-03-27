package com.tutego.exercises.jdbc;

import java.sql.*;

public class PreparedInsert {
  public static void main( String[] args ) throws SQLException {
    DatabaseUtility db = new DatabaseUtility();

    String prepString = "INSERT INTO geodb_adm1 VALUES ( ?, ?, ?, ? )";

    try ( Connection con = db.getConnection();
          // PreparedStatement aufbauen und absenden
          PreparedStatement preparedStatement = con.prepareStatement( prepString ) ) {

      con.setAutoCommit( false );

      String[][] data = {
                         { "DE", "SL", "10", "Saarland" },
                         { "DE", "SN", "14", "Sachsen" },
                         { "DE", "ST", "15", "Sachsen-Anhalt" },
                         { "DE", "SH", "01", "Schleswig-Holstein" },
                   };

      for ( int i = 0; i < data.length; i++ ) {
        String[] line = data[ i ];

        preparedStatement.setString( 1, line[ 0 ] );
        preparedStatement.setString( 2, line[ 1 ] );
        preparedStatement.setString( 3, line[ 2 ] );
        preparedStatement.setString( 4, line[ 3 ] );

        preparedStatement.executeUpdate();
      }

      con.commit();
      con.setAutoCommit( true );
    }

    Select.main();
  }
}
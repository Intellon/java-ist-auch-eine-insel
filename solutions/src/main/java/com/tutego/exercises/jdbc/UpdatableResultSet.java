package com.tutego.exercises.jdbc;

import java.sql.*;

public class UpdatableResultSet {
  public static void main( String[] args ) throws SQLException {

    DatabaseUtility db = new DatabaseUtility();
    
    try ( Connection con = db.getConnection();
          Statement stmt = con.createStatement( ResultSet.TYPE_SCROLL_SENSITIVE,
                                                ResultSet.CONCUR_UPDATABLE );
          ResultSet uprs = stmt.executeQuery( "SELECT * FROM geodb_adm1" ) ) {

      // CREATE TABLE geodb_adm1 (
      // adm0 char(2) NOT NULL,
      // adm1 char(2) NOT NULL,
      // gs char(2) NOT NULL,
      // name varchar(50) NOT NULL,
      // PRIMARY KEY (adm0,adm1)
      // );

      // INSERT INTO geodb_adm1 VALUES ('DE','NI','03','Niedersachsen');

      uprs.moveToInsertRow();

      uprs.updateString( "adm0", "DE" );
      uprs.updateString( "adm1", "NI" );
      uprs.updateString( "gs", "03" );
      uprs.updateString( "name", "Niedersachsen" );

      uprs.insertRow();

      // INSERT INTO geodb_adm1 VALUES ('DE','NW','05','Nordrhein-Westfalen');

      uprs.moveToInsertRow();

      uprs.updateString( "adm0", "DE" );
      uprs.updateString( "adm1", "NW" );
      uprs.updateString( "gs", "05" );
      uprs.updateString( "name", "Nordrhein-Westfalen" );

      uprs.insertRow();

      // Abschluss

      uprs.beforeFirst();
    }

    Select.main();
  }
}
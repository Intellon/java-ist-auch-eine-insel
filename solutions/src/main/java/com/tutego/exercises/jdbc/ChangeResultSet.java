package com.tutego.exercises.jdbc;

import java.sql.*;

public class ChangeResultSet {
  public static void main( String[] args ) {
    DatabaseUtility dbUtil = new DatabaseUtility();
    String query = "SELECT * FROM geodb_adm1 where adm0 = 'DE'";

    try ( Connection con = dbUtil.getConnection();
          Statement statement = con.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE,
                                                     ResultSet.CONCUR_UPDATABLE );
          ResultSet rs = statement.executeQuery( query ) ) {

      while ( rs.next() ) {
        rs.updateString( "adm0", "de" );
        rs.updateRow();
      }
    }
    catch ( SQLException e ) {
      e.printStackTrace();
    }
  }
}

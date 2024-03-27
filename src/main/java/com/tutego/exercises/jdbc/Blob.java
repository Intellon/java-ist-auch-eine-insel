package com.tutego.exercises.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

public class Blob {
  public static void main( String[] args ) throws SQLException {

    DatabaseUtility db = new DatabaseUtility();

    try ( Statement stmt = db.getStatement() ) {
      // Tabelle aufbauen, dieAt eine Grafik aufnimmt

      stmt.executeUpdate( "DROP TABLE images" );

      String createTableString = "CREATE TABLE images (imgname TEXT, img BLOB );";
      stmt.executeUpdate( createTableString );
    }

    // Einfügen in dieAt Tabelle über PreparedStatement

    try ( Connection con = db.getConnection();
          InputStream in = Blob.class.getResourceAsStream( "Blob.class" );
          PreparedStatement pstmt = con.prepareStatement( "INSERT INTO images VALUES (?, ?)" ) ) {
      pstmt.setString( 1, "Blob.class" );
      pstmt.setBinaryStream( 2, in, in.available() );
      pstmt.executeUpdate();
    }
    catch ( IOException e ) {
      e.printStackTrace();
    }

    // Erfragen über getBytes()

    try ( Statement stmt = db.getStatement();
          ResultSet rs = stmt.executeQuery( "SELECT * FROM images" ) ) {
      rs.next();

      byte[] bytes = rs.getBytes( 2 );
      System.out.println( new String( bytes ) );
    }
  }
}
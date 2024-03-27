package com.tutego.exercises.jdbc;

import java.sql.*;

public class ScrollableResultSet {
  public static void main( String[] args ) throws SQLException {
    DatabaseUtility db = new DatabaseUtility();
    try ( Connection con = db.getConnection();
          Statement stmt = con.createStatement( ResultSet.TYPE_SCROLL_SENSITIVE,
                                                ResultSet.CONCUR_READ_ONLY );
          ResultSet srs = stmt.executeQuery( "SELECT * FROM geodb_adm1" ) ) {

      srs.absolute( 4 );
      int rowNum = srs.getRow(); // rowNum = 4
      System.out.println( "4 == " + rowNum );

      srs.relative( -3 );
      rowNum = srs.getRow(); // rowNum = 1
      System.out.println( "1 == " + rowNum );

      srs.relative( 2 );
      rowNum = srs.getRow(); // rowNum = 3
      System.out.println( "rowNum == 3 " + rowNum );

      srs.absolute( 1 );
      System.out.println( "isAfterLast? " + srs.isAfterLast() );

      if ( !srs.isAfterLast() ) {
        System.out.print( srs.getString( "adm0" ) + ", " );
        System.out.print( srs.getString( "adm1" ) + ", " );
        System.out.print( srs.getString( "gs" ) + ", " );
        System.out.println( srs.getString( "name" ) );
      }

      srs.afterLast();

      System.out.println();

      while ( srs.previous() ) {
        System.out.print( srs.getString( "adm0" ) + ", " );
        System.out.print( srs.getString( "adm1" ) + ", " );
        System.out.print( srs.getString( "gs" ) + ", " );
        System.out.println( srs.getString( "name" ) );
      }
    }
  }
}
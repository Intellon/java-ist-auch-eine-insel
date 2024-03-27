package com.tutego.exercises.jdbc;

import java.sql.*;
import java.util.Enumeration;

public class DriverInfo
{
  public static void main( String[] args ) throws SQLException
  {
    listDrivers();

    try
    {
//      Class.forName( "sun.jdbc.odbc.JdbcOdbcDriver" );
//      Class.forName( "com.mysql.jdbc.Driver" );
      Class.forName( "org.postgresql.Driver" );
    }
    catch ( ClassNotFoundException e )
    {
      e.printStackTrace();
    }

    listDrivers();

    Driver d = (Driver) DriverManager.getDrivers().nextElement();
    DriverPropertyInfo[] infos = d.getPropertyInfo( "jdbc:postgresql:GeoDaten", null );

    for ( int i = 0; infos != null && i < infos.length; i++ )
    {
      System.out.println( infos[i].name );
    }
  }

  private static void listDrivers()
  {
    for ( Enumeration<?> e = DriverManager.getDrivers();
          e.hasMoreElements(); )
    {
      Driver element = (Driver) e.nextElement();
      System.out.println( element );
    }
  }
}

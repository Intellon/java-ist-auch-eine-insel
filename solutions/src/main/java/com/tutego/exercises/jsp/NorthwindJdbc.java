package com.tutego.exercises.jsp;
import java.sql.*;

public class NorthwindJdbc
{
  public static void main(String[] args) throws Exception
  {
    Class.forName( "sun.jdbc.odbc.JdbcOdbcDriver" );
    String query = "SELECT firstname, lastname FROM employees";
    try ( Connection con = DriverManager.getConnection( "jdbc:odbc:Northwind" );
          Statement statement = con.createStatement();
          ResultSet set = statement.executeQuery( query ) )
    {
      while ( set.next() )
        System.out.print( set.getString(1) + " " +
                          set.getString(2) );
    }
  }
}
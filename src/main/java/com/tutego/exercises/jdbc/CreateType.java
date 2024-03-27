package com.tutego.exercises.jdbc;

import java.sql.SQLException;
import java.sql.Statement;

public class CreateType
{
  public static void main( String[] args ) throws SQLException
  {
    DatabaseUtility db = new DatabaseUtility();

    try ( Statement stmt = db.getStatement() ) {

      String createAddress = "CREATE TYPE ADDRESS AS (" +
                              "ID INT," +
                              "STREET VARCHAR(40)," +
                               "CITY VARCHAR(40), " +
                              "STATE CHAR(2)," +
                               "ZIP CHAR(5)" +
                             ")";
  
      stmt.executeUpdate( createAddress );
  
      String createTable = "CREATE TABLE PERSON (" +
                              "ID INT," +
                              "NAME VARCHAR(25)," +
                              "COL_ADDRESS ADDRESS" +
                            ")";
  
      stmt.executeUpdate( createTable );
    }
  }
}
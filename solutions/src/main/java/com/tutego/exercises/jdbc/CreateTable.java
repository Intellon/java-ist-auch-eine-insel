package com.tutego.exercises.jdbc;

import java.sql.*;

public class CreateTable
{
  public static void main( String[] args ) throws SQLException
  {
    DatabaseUtility db = new DatabaseUtility();

    try ( Statement stmt = db.getStatement() ) {
  
  //    CREATE TABLE geodb_adm1 (
  //      adm0 char(2) NOT NULL default '',
  //      adm1 char(2) NOT NULL default '',
  //      gs char(2) NOT NULL default '',
  //      name varchar(50) NOT NULL default '',
  //      PRIMARY KEY  (adm0,adm1),
  //    );
  
      String tableName = "geodb_adm1";
  
      String createTableString = "create table " + tableName + " (";
      createTableString += "adm0 char(2) NOT NULL default '',";
      createTableString += "adm1 char(2) NOT NULL default '',";
      createTableString += "gs char(2) NOT NULL default '',";
      createTableString += "name varchar(50) NOT NULL default '',";
      createTableString += "PRIMARY KEY  (adm0,adm1)";
      createTableString += ")";
  
      stmt.executeUpdate( createTableString );
    }
  }
}

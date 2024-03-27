package com.tutego.exercises.jdbc;

import java.sql.*;

public class InsertData
{
  public static void main( String[] args ) throws SQLException
  {
    DatabaseUtility db = new DatabaseUtility();

    try ( Statement stmt = db.getStatement() ) {
      stmt.executeUpdate( "INSERT INTO geodb_adm1 VALUES ('DE','BY','09','Bayern')" );
      stmt.executeUpdate( "INSERT INTO geodb_adm1 VALUES ('DE','BB','12','Brandenburg')" );
      stmt.executeUpdate( "INSERT INTO geodb_adm1 VALUES ('DE','BE','11','Berlin')" );
      stmt.executeUpdate( "INSERT INTO geodb_adm1 VALUES ('DE','HB','04','Bremen')" );
      stmt.executeUpdate( "INSERT INTO geodb_adm1 VALUES ('DE','BW','08','Baden-W�rttemberg')" );
    }

    Select.main();
  }
}
package com.tutego.exercises.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

public class UseAddress
{
  public static void main(String[] args) throws SQLException
  {
    DatabaseUtility db = new DatabaseUtility();
    try ( Connection con = db.getConnection() ) {
      Map<String, Class<?>> map = con.getTypeMap();
      map.put( "ADDRESS", Address.class );
      con.setTypeMap( map );
    }
  }
}
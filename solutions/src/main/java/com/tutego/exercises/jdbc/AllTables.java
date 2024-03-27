package com.tutego.exercises.jdbc;

import java.sql.*;

public class AllTables
{
  public static void main( String[] args ) throws SQLException
  {
    DatabaseUtility db = new DatabaseUtility();
    String[] types = { "TABLE" };

    try ( Connection con = db.getConnection() )
    {
      try ( ResultSet rsTables = con.getMetaData().getTables( null, null, null, types ) )
      {
        while ( rsTables.next() )
        {
          String tableCatalog = rsTables.getString( 1 );
          String tableSchema = rsTables.getString( 2 );
          String tableName = rsTables.getString( 3 );
        
          System.out.println( tableName );
          System.out.println( tableCatalog );
          System.out.println( tableSchema );

          // Spaltennamen holen

          try ( ResultSet rsColumns = con.getMetaData().getColumns( null,null,tableName,null ) )
          {
            while ( rsColumns.next() )
            {
              System.out.println( rsColumns.getString(4) );
            }
    
            rsColumns.close();
          }
        }
      }
    }
  }
}

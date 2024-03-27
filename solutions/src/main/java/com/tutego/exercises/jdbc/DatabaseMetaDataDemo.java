package com.tutego.exercises.jdbc;

import java.sql.*;

@SuppressWarnings( "unused" )
public class DatabaseMetaDataDemo {

  public static void main( String[] args ) throws SQLException {
    DatabaseUtility db = new DatabaseUtility();

    DatabaseMetaData dbmd = db.getConnection().getMetaData();

    // // Typen
    //
    // tableTypes( dbmd );
    //
    // // Type-Info
    //
    // typeInfo( dbmd );
    //
    // // Primary Keys
    //
    // primaryKeys( dbmd );
    //
    // // Imported Keys
    //
    // importedKeys( dbmd );

    // if (dbmd.supportsTransactions())
    // {
    // System.out.println("Ja");
    // }
    // else
    // {
    // System.out.println("Nein");
    // }

    // System.out.println( dbmd.supportsBatchUpdates() );

    // if ( dbmd.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE) )
    // {
    // System.out.println( "Insensitive scrollable result sets are supported" );
    // }
    // if ( dbmd.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE) )
    // {
    // System.out.println( "Sensitive scrollable result sets are supported" );
    // }
    // if ( !dbmd.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)
    // && !dbmd.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE) )
    // {
    // System.out.println( "Updatable result sets are not supported" );
    // }

    // System.out.println( dbmd.supportsResultSetConcurrency(
    // ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE) );

    // DatabaseMetaData dbmd = con.getMetaData();

    try ( ResultSet resultSet = dbmd.getProcedures( null, null, "%" ) ) {
      while ( resultSet.next() ) {
        String procName = resultSet.getString( 3 );
        System.out.println( procName );
      }
    }
  }

  private static void importedKeys( DatabaseMetaData dbmd ) throws SQLException {
    try ( ResultSet rs = dbmd.getImportedKeys( null, null, "geodb_adm1" ) ) {

      while ( rs.next() ) {
        String pkTable = rs.getString( "PKTABLE_NAME" );
        String pkColName = rs.getString( "PKCOLUMN_NAME" );
        String fkTable = rs.getString( "FKTABLE_NAME" );
        String fkColName = rs.getString( "FKCOLUMN_NAME" );
        short updateRule = rs.getShort( "UPDATE_RULE" );
        short deleteRule = rs.getShort( "DELETE_RULE" );
        System.out.println( "primary key table name :  " + pkTable );
        System.out.print( "primary key column name :  " );
        System.out.println( pkColName );
        System.out.println( "foreign key table name :  " + fkTable );
        System.out.print( "foreign key column name :  " );
        System.out.println( fkColName );
        System.out.println( "update rule:  " + updateRule );
        System.out.println( "delete rule:  " + deleteRule );
        System.out.println( "" );
      }
    }
  }

  private static void primaryKeys( DatabaseMetaData dbmd ) throws SQLException {
    try ( ResultSet rs = dbmd.getPrimaryKeys( null, null, "geodb_adm1" ) ) {

      while ( rs.next() ) {
        String name = rs.getString( "TABLE_NAME" );
        String columnName = rs.getString( "COLUMN_NAME" );
        String keySeq = rs.getString( "KEY_SEQ" );
        String pkName = rs.getString( "PK_NAME" );
        System.out.println( "table name :  " + name );
        System.out.println( "column name:  " + columnName );
        System.out.println( "sequence in key:  " + keySeq );
        System.out.println( "primary key name:  " + pkName );
        System.out.println( "" );
      }
    }
  }

  private static void typeInfo( DatabaseMetaData dbmd ) throws SQLException {
    try ( ResultSet rs = dbmd.getTypeInfo() ) {

      while ( rs.next() ) {
        String typeName = rs.getString( "TYPE_NAME" );
        short dataType = rs.getShort( "DATA_TYPE" );
        String createParams = rs.getString( "CREATE_PARAMS" );
        int nullable = rs.getInt( "NULLABLE" );
        boolean caseSensitive = rs.getBoolean( "CASE_SENSITIVE" );

        System.out.println( "DBMS type " + typeName + ":" );
        System.out.println( "     java.sql.Types:  " + dataType );
        System.out.print( "     parameters used to create: " );
        System.out.println( createParams );
        System.out.println( "     nullable?:  " + nullable );
        System.out.print( "     case sensitive?:  " );
        System.out.println( caseSensitive );
        System.out.println( "" );
      }
    }
  }

  private static void tableTypes( DatabaseMetaData dbmd ) throws SQLException {
    String dbmsName = dbmd.getDatabaseProductName();

    System.out.println( "Die Datenbank " + dbmsName + " beinhaltet dieAt Typen  " );

    try ( ResultSet rs = dbmd.getTableTypes() ) {
      while ( rs.next() ) {
        String tableType = rs.getString( "TABLE_TYPE" );
        System.out.println( "    " + tableType );
      }
    }
  }
}

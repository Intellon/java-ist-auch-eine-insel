package com.tutego.exercises.jdbc;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MoveTheResultSet
{
  public static void main( String[] args )
  {
	  DatabaseUtility dbUtil = new DatabaseUtility();

    try ( Connection con = dbUtil.getConnection();
         Statement stmt = con.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, 
	                                          ResultSet.CONCUR_READ_ONLY );
          ResultSet set = stmt.executeQuery( "SELECT * FROM geodb_typ" ) ) {

	    int noRows = getNumberOfRows( set );

	    System.out.println( noRows );
	    System.out.println();

	    selectStartEnd( set, 2, 2, 5 );

	    System.out.println();
	    System.out.println();

	    printFormatedData( set, 2, 2 );
	  }
	  catch ( SQLException e )
	  {
	    e.printStackTrace();
	  }
  }

  /**
   * Gets the number of rows for the given ResultSet.
   * 
   * @param set  ResultSet.
   * @return     Number of rows or 0 if there are no rows.
   *  
   * @throws SQLException
   */
  public static int getNumberOfRows( ResultSet set ) throws SQLException
  {
	  if ( set.last() )
	    return set.getRow();
	
	  return 0;
  }
  
  /** 
   * Prints the content of the rows from start to end of the specified ResultSet.
   * 
   * @param set     The Result Set.
   * @param columns Number of columns to print.
   * @param start   Start. Start at postion 1.
   * @param end     End.
   * @throws SQLException
   */
  private static void selectStartEnd( ResultSet set, int columns,
                                      int start, int end ) throws SQLException
  {
  set.absolute( start );

  for ( int i = start; i <= end; i++ )
  {
    set.absolute( i );

    for ( int j = 1; j <= columns; j++ )
      System.out.print( set.getString(j) + " " );

    System.out.println();
  }
  }

  /**
   * Prints from the given ResultSet a number of group rows separated by a newline. 
   * 
   * @param set     ResultSet.
   * @param colums  Number of rows to print.
   * @param group   Number of lines befor a newline is printed.  
   * 
   * @throws SQLException
   */
  public static void printFormatedData( ResultSet set, int colums, int group )
    throws SQLException
  {
	  int max = getNumberOfRows( set );

    for ( int i = 1; i <= max; i += group )
    {
      selectStartEnd( set, 2, i, i - 1 + group );
      System.out.println();
    }
  }
}

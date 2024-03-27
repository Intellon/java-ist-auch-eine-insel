package com.tutego.exercises.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtility
{
  /**
   * Classname of jdbc driver
   */
//  private String JDBC_CLASSNAME = "com.mysql.jdbc.Driver";
    private String JDBC_CLASSNAME = "org.postgresql.Driver";

  /**
   * Database URL
   */
//    private String url = "jdbc:mysql://localhost/GeoDaten";
  private String url = "jdbc:postgresql://localhost/GeoDaten";

  /**
   * Username for the database
   */
  private String username = "postgres";
//  private String username = "root";
  
  /**
   * Password for the database
   */
  private String password = "admin";
//  private String password = "";

  /**
   * Connection to the database
   */
  private Connection connection;

  //
  
  /**
   * Gets a connection to the database. Loads the driver.
   * If this is not possible the application ends.
   * Do not forget to close the connection later.
   * 
   * @return
   * @throws SQLException
   */
  public Connection getConnection() throws SQLException
  {
    if ( connection != null )
      return connection; 

    try
    {
      Class.forName( JDBC_CLASSNAME );
    }
    catch ( ClassNotFoundException e )
    {
      e.printStackTrace();
      System.exit( 0 );
    }

    return connection = DriverManager.getConnection( url, username, password );
  }
  
  /**
   * Gets an new Statement. Do not forget to close it.
   * 
   * @return
   * @throws SQLException
   */
  public Statement getStatement() throws SQLException
  {
    if ( connection == null )
      getConnection();

    return connection.createStatement();
  }

  /**
   * Gets the password for the database connection.
   * 
   * @return Returns the password.
   */
  public String getPassword()
  {
    return password;
  }

  /**
   * Sets a password for the database connection.
   *  
   * @param password The password to set.
   */
  public void setPassword( String password )
  {
    this.password = password;
  }

  /**
   * Gets the current jdbc url.
   * 
   * @return Returns the url.
   */
  public String getUrl()
  {
    return url;
  }

  /**
   * Sets the jdbc url.
   * 
   * @param url The url to set.
   */
  public void setUrl( String url )
  {
    this.url = url;
  }

  /**
   * Returns the current username.
   * 
   * @return Returns the username.
   */
  public String getUsername()
  {
    return username;
  }

  /**
   * Sets a username for the connection.
   * 
   * @param username The username to set.
   */
  public void setUsername( String username )
  {
    this.username = username;
  }
}

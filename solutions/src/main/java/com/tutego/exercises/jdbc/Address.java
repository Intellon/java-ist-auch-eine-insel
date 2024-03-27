package com.tutego.exercises.jdbc;

import java.sql.*;

public class Address implements SQLData
{
  public int num;
  public String street;
  public String city;
  public String state;
  public String zip;
  private String sql_type;

  @Override
  public String getSQLTypeName()
  {
    return sql_type;
  }

  @Override
  public void readSQL( SQLInput stream, String type ) throws SQLException
  {
    sql_type = type;
    num = stream.readInt();
    street = stream.readString();
    city = stream.readString();
    state = stream.readString();
    zip = stream.readString();
  }

  @Override
  public void writeSQL( SQLOutput stream ) throws SQLException
  {
    stream.writeInt(num);
    stream.writeString(street);
    stream.writeString(city);
    stream.writeString(state);
    stream.writeString(zip);
  }
}
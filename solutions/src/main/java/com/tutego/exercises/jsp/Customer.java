package com.tutego.exercises.jsp;

import java.io.Serializable;
import java.util.Date;

public class Customer implements Serializable
{
  private static final long serialVersionUID = 6594199660416149733L;
  
  private String name;
  private String address;
  private Date birthday;

  /**
   * @param name
   * @param address
   * @param date
   */
  public Customer( String name, String address, Date date )
  {
    this.name = name;
    this.address = address;
    this.birthday = date;
  }

  /**
   * @return Returns the adress.
   */
  public String getAddress()
  {
    return address;
  }

  /**
   * @param address The adress to set.
   */
  public void setAddress( String address )
  {
    this.address = address;
  }

  /**
   * @return Returns the name.
   */
  public String getName()
  {
    return name;
  }

  /**
   * @param name The name to set.
   */
  public void setName( String name )
  {
    this.name = name;
  }

  /**
   * @return Returns the birthday.
   */
  public Date getBirthday()
  {
    return birthday;
  }

  /**
   * @param birthday The birthday to set.
   */
  public void setBirthday( Date birthday )
  {
    this.birthday = birthday;
  }

}

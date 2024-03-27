package com.tutego.exercises.jsp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

public class Customers implements Serializable
{
  private static final long serialVersionUID = -3687588554461157575L;
  
  private Collection<Customer> customerList = new ArrayList<>();
  
  Customers()
  {
    customerList.add( new Customer( "name1", "Adresse1", new Date() ) );
    customerList.add( new Customer( "name2", "Adresse2", new Date() ) );
    customerList.add( new Customer( "name3", "Adresse3", new Date() ) );
    customerList.add( new Customer( "name4", "Adresse4", new Date() ) );
    customerList.add( new Customer( "name5", "Adresse5", new Date() ) );
    customerList.add( new Customer( "name6", "Adresse6", new Date() ) );
    customerList.add( new Customer( "name7", "Adresse7", new Date() ) );
  }

  /**
   * @return Returns the cList.
   */
  public Collection<Customer> getCustomerList()
  {
    return Collections.unmodifiableCollection( customerList );
  }
}

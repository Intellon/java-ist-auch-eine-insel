package com.tutego.exercises.device.nswigu;

public class ElectronicDevice {

  private double watt;

  //tag::solution[]
  public void setWatt( double watt ) {
    if ( watt <= 0 )
      throw new IllegalWattException( "Watt cannot be 0 or negative, but was %f", watt );
    this.watt = watt;
  }
  //end::solution[]
}

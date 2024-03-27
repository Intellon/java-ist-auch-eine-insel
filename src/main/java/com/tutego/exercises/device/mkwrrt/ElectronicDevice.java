package com.tutego.exercises.device.mkwrrt;

public class ElectronicDevice {

  boolean isOn;
  private double watt;

  public double getWatt() {
    return watt;
  }

  public void setWatt( double watt ) {
    this.watt = watt;
  }

  void on() {
    isOn = true;
  }

  void off() {
    isOn = false;
  }

  boolean isOn() {
    return isOn;
  }

  // Aufruf:
  // Radio r1 = new ...
  // ElectronicDevice r2 = new ...
  // ElectronicDevice dvd = new ...
  // int i = ElectronicDevice.numberOfActiveElectronicDevices( r1, dvd, r2 ); // i = 2
  //tag::solution[]
  public static int numberOfActiveElectronicDevices( ElectronicDevice... devices ) {
    int result = 0;

    for ( ElectronicDevice device : devices )
      if ( device.isOn )
        result++;
    
    return result;
  }
  //end::solution[]
}
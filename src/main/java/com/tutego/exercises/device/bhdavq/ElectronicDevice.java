package com.tutego.exercises.device.bhdavq;

//tag::solution[]
public class ElectronicDevice {

  private double watt;

  public double getWatt() {
    return watt;
  }

  public void setWatt( double watt ) {
    this.watt = watt;
  }

  @Override public String toString() {
    return "ElectronicDevice[watt=" + watt + ']';
  }
}
//end::solution[]

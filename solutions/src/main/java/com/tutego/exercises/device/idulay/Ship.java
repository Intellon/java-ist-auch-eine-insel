package com.tutego.exercises.device.idulay;

import java.util.ArrayList;

public class Ship {

  private final ArrayList<ElectronicDevice> devices = new ArrayList<>();

  //tag::solution[]
  private final static ElectronicDeviceWattComparator ELECTRONIC_DEVICE_WATT_COMPARATOR =
      new ElectronicDeviceWattComparator();

  public void addDevice( ElectronicDevice device ) {
    devices.add( device );
    devices.sort( ELECTRONIC_DEVICE_WATT_COMPARATOR );
  }
  //end::solution[]
}
package com.tutego.exercises.device.idulay;

import java.util.Comparator;

public class ElectronicDeviceWattComparator implements Comparator<ElectronicDevice> {

  @Override
  public int compare( ElectronicDevice ea1, ElectronicDevice ea2 ) {
    return Double.compare( ea1.getWatt(), ea2.getWatt() );
  }
}

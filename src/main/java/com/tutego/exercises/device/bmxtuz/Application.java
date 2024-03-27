package com.tutego.exercises.device.bmxtuz;

//tag::solution[]
public class Application {

  public static void main( String[] args ) {
    Radio grandmasOldRadio = new Radio();

    grandmasOldRadio.isOn = true;
    grandmasOldRadio.volume = 12;

    System.out.println( "So laut: " + grandmasOldRadio.volume );
  }
}
//end::solution[]

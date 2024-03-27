package com.tutego.exercises.device.mkwrrt;

public class Application {
  public static void main( String[] args ) {
    Radio bedroomRadio = new Radio();
    Radio cabooseRadio = new Radio();
    TV mainTv = new TV();
    Radio crRadio = new Radio();
    Firebox alarm = new Firebox();
    Ship ship = new Ship();
    ship.addDevice( bedroomRadio );
    ship.addDevice( cabooseRadio );
    ship.addDevice( mainTv );
    ship.addDevice( crRadio );
    ship.addDevice( alarm );
    ship.holiday();
  }
}

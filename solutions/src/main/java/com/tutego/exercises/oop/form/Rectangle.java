package com.tutego.exercises.oop.form;

public class Rectangle extends Form {

  double breite, höhe;

  public Rectangle( double x, double y, double breite, double höhe ) {
    setX( x );
    setY( y );
    setBreite( breite );
    setHöhe( höhe );
  }

  public void setHöhe( double höhe ) {
    this.höhe = höhe;
  }

  public void setBreite( double breite ) {
    this.breite = breite;
  }

  public double getHöhe() {
    return höhe;
  }

  public double getBreite() {
    return breite;
  }

  @Override
  public double area() {
    return breite * höhe;
  }

  @Override
  public String toString() {
    return "Rectangle[x = " + x + ",y = " + y + ", Breite = " + breite + ", Hoehe = " + höhe + ",  Flaeche = " + area() + "]";
  }
}
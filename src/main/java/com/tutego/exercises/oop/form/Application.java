package com.tutego.exercises.oop.form;

public class Application {

  public static void main( String[] args ) {
    Rectangle re = new Rectangle( 0, 0, 4, 5 );
    Circle kr = new Circle( 0, 0, 5 );
    Group g = new Group();

    System.out.println( kr );
    System.out.println( re );

    g.add( kr );
    g.add( re );

    System.out.println( "\nDie Summe aller Flaechen betraegt: " + g.area() );
  }
}

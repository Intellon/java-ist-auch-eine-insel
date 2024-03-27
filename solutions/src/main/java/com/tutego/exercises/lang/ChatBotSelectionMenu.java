package com.tutego.exercises.lang;

public class ChatBotSelectionMenu {

  public static void main( String[] args ) {
    //tag::solution[]
    System.out.println( "Hi, ich bin der CiaoCiao-Bot! Wie kann ich dir helfen?" );

    while ( true ) {
      System.out.println( "* Wähle 1 für Warenverfügbarkeit " );
      System.out.println( "* Wähle 2 für Telefonnummer für Eilbestellung" );
      System.out.println( "* Wähle 3 für Produktinformationen " );
      System.out.println( "* Eine andere Auswahl beendet das Programm " );
      switch ( new java.util.Scanner( System.in ).next() ) {
        case "1":
          System.out.println( "Rum, Falschgeld und Schnellbeton verfügbar" );
          break;
        case "2":
          System.out.println( "0800-CIAO#CIAO" );
          break;
        case "3":
          exit:
          while ( true ) {
            System.out.println( "* Wähle 1 für Rum" );
            System.out.println( "* Wähle 2 für Falschgeld" );
            System.out.println( "* Wähle 3 für Schnellbeton" );
            System.out.println( "* Eine andere Auswahl führt zurück ins Hauptmenü" );
            switch ( new java.util.Scanner( System.in ).next() ) {
              case "1":
                System.out.println(
                  "The Famous Ciao: malziger Geschmack, abgerundet von einem vollmundigen Aroma" );
                break;
              case "2":
                System.out.println( "Feinste Blüten, jetzt auch mit Porträtfenster!" );
                break;
              case "3":
                System.out.println( "Beste Qualität, silbergrau, ohne Streckmittel" );
                break;
              default:
                break exit;
            }
          }
          break;
        default:
          System.exit( 0 );
      }
    }
    //end::solution[]
  }
}

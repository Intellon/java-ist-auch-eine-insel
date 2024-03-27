package com.tutego.exercises.lang;

public class RandomCandy {
  //tag::solution[]
  enum CandyType {
    CARAMELS,
    CHOCOLATE,
    GUMMIES,
    LICORICE,
    LOLLIPOPS,
    CHEWING_GUMS,
    COTTON_CANDY;

    public static CandyType fromName( String input ) {
      try {
        input = input.trim().toUpperCase().replace( ' ', '_' );
        return valueOf( input );
      }
      catch ( IllegalArgumentException e ) {
        System.err.println( "Unknown type" );
        return null;
      }
    }

    public static CandyType random() {
      return values()[ (int) (Math.random() * values().length) ];
    }

    //    private static CandyType[] VALUES = values();
    //    public static CandyType random() {
    //      return VALUES[ (int) (Math.random() * VALUES.length) ];
    //    }
  }
  //end::solution[]

  public static void main( String[] args ) {
    //    String input = JOptionPane.showInputDialog( null, "Name einer Süßigkeit" );
    //    if ( input != null )
    //      System.out.println( CandyType.fromName( input ) );
    System.out.println( CandyType.random() );
    System.out.println( CandyType.random() );
    System.out.println( CandyType.random() );
    System.out.println( CandyType.random() );
    System.out.println( CandyType.random() );
    System.out.println( CandyType.random() );
    System.out.println( CandyType.random() );
    System.out.println( CandyType.random() );
    System.out.println( CandyType.random() );
    System.out.println( CandyType.random() );
  }
}
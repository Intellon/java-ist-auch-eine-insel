package com.tutego.exercises.optim;

@SuppressWarnings( "unused" )
public class KontoHaupt
{
  public static void testClone( Konto konto, int max )
  {
    Object obj;
        
    for ( int i = 0; i < max; i++ )
      obj = konto.clone();
  }

  public static void testClone2( Konto konto, int max )
  {
    Object obj;
    
    for ( int i = 0; i < max; i++ )
      obj = konto.cloneWithConstructor();
  }

  public static void testClone3( Konto konto, int max )
  {
    Object obj;

    for ( int i = 0; i < max; i++ )
      obj = konto.cloneWithDefaultConstructor();
  }

    public static void main( String[] args )
    {
      Konto konto = new Konto( "A", "B", "C" );

      int max = 1000000;
      testClone(konto, max);
      testClone2(konto, max);
      testClone3(konto, max);
    }
}

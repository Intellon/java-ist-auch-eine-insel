package com.tutego.exercises.optim;
public class Speicherverbrauch
{
  public static void main( String[] args )
  {
    int max = 22;
    
    String[] mem = new String[max];
    mem[0] = "        ";

    for ( int i = 1; i < max; ++i )
    {
      mem[i] = mem[i - 1] + mem[i - 1];

      long total = Runtime.getRuntime().totalMemory();
      long maxM   = Runtime.getRuntime().maxMemory();
      long free  = Runtime.getRuntime().freeMemory();

      System.err.println( "Anzahl     = " + i);
      System.err.println( " total     = " + toMb(total) );
      System.err.println( " max       = " + toMb(maxM) );
      System.err.println( " free      = " + toMb(free) );
      System.err.println( " differenz = " + toMb(total-free));
    }
  }

  static String toMb( long mem )
  {
    return ""+(mem /1024)+" KB";

  }
}

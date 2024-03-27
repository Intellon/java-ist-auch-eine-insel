package com.tutego.exercises.optim;

import java.lang.ref.Reference;
import java.lang.ref.SoftReference;

public class WeakReferenceDemo2 {

  public static void main( String[] args ) {
    CharSequence s = /* new StringBuffer */("Hallo, dies ist ein Test");

    Reference<CharSequence> sRef = new SoftReference<CharSequence>( s );
    s = null;

    System.out.println( "Vor OofMemError: " + sRef.get() );

    try {
      String t = "    ";

      while ( true )
        t += t;
    }
    catch ( OutOfMemoryError e ) {
      e.printStackTrace();
    }

    System.out.println( "Nach OofMemError: " + sRef.get() );
  }
}
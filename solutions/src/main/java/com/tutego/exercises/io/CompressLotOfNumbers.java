package com.tutego.exercises.io;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.GZIPOutputStream;

public class CompressLotOfNumbers {

  public static void main( String[] args ) throws IOException {

    //tag::solution[]
    Path tempFile = Files.createTempFile( "numbers", "bin.Z" );

    int n = 4;

    try ( OutputStream     fos = Files.newOutputStream( tempFile );
          OutputStream     gos = new GZIPOutputStream( fos );
          DataOutputStream out = new DataOutputStream( gos ) ) {
      for ( int i = 0; i < n; i++ )
        out.writeLong( i );
    }

    System.out.println( "Unkomprimiert: " + n * Long.BYTES );
    System.out.println( "Komprimiert:   " + Files.size( tempFile ) );

    Files.delete( tempFile );
    //end::solution[]
  }
}

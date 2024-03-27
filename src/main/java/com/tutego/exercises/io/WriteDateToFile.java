package com.tutego.exercises.io;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

public class WriteDateToFile {

  public static void main( String[] args ) {
    //tag::solution[]
    String fileName = "current-date.txt";
    try ( PrintWriter writer = new PrintWriter( fileName ) ) {
      writer.write( LocalDateTime.now().toString() );
    }
    catch ( FileNotFoundException e ) {
      System.err.println( "Cant't create file " + fileName );
    }
    //end::solution[]
  }
}

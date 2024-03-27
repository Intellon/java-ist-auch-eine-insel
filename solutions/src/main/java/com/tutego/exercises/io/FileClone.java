package com.tutego.exercises.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileClone {

  public static void main( String[] args ) {
    try {
      cloneFile( Paths.get( "c:/test.txt" ) );
    }
    catch ( IOException e ) {
      e.printStackTrace();
    }
  }

  //tag::solution[]
  public static void cloneFile( Path path ) throws IOException {

    if ( Files.isDirectory( path ) )
      throw new IllegalArgumentException( "Path has to be a file but was a directory" );

    Path parent   = path.getParent();
    Path filename = path.getFileName();

    Path copyPath = parent.resolve( "Kopie von " + filename );

    for ( int i = 2; Files.exists( copyPath ); i++ )
      copyPath = parent.resolve( "Kopie (" + i + ") von " + filename );

    Files.copy( path, copyPath );
  }
  //end::solution[]
}

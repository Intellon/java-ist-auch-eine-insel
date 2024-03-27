package com.tutego.exercises.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class MergeFiles {

  //tag::solution[]
  public static void mergeFiles( Path main, Path... temp ) throws IOException {

    List<Path> files = new ArrayList<>( 1 + temp.length );
    files.add( main );
    Collections.addAll( files, temp );

    Collection<String> words = new LinkedHashSet<>();

    for ( Path file : files ) {
      try ( Scanner input = new Scanner( file ) ) {
        while ( input.hasNextLine() )
          words.add( input.nextLine() );
      }
    }

    Files.write( main, words );
  }
  //end::solution[]

  public static void main( String[] args ) throws IOException {
    Path master = Paths.get( System.getProperty( "user.dir" ), "master.txt" );
    Path temp1  = Paths.get( System.getProperty( "user.dir" ), "temp1.txt" );
    Path temp2  = Paths.get( System.getProperty( "user.dir" ), "temp2.txt" );
    mergeFiles( master, temp1, temp2 );
  }
}

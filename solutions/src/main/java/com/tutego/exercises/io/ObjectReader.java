package com.tutego.exercises.io;

import java.io.*;
import java.util.*;
import java.util.zip.*;

public class ObjectReader {

  public static void main( String[] args ) throws Exception {
    //tag::solution[]
    Map<String, Integer> map1 = new HashMap<>();
    map1.put( "datei.php", 1 );
    map1.put( "Zwei", 2 );
    map1.put( "Drei", 3 );

    try ( OutputStream fos = new FileOutputStream( "hash.ser" );
          OutputStream bos = new BufferedOutputStream( fos );
          OutputStream gzos = new GZIPOutputStream( bos );
          ObjectOutputStream oos = new ObjectOutputStream( gzos ) ) {
      oos.writeObject( map1 );
    }

    // *************************************************

    try ( InputStream fis = new FileInputStream( "hash.ser" );
          InputStream bis = new BufferedInputStream( fis );
          InputStream gzis = new GZIPInputStream( bis );
          ObjectInputStream ois = new ObjectInputStream( gzis ) ) {
  
      @SuppressWarnings( "unchecked" )
      Map<String, Integer> map2 = (Map<String, Integer>) ois.readObject();

      System.out.println( map1 );
      System.out.println( map2 );
    }
    //end::solution[]
  }
}
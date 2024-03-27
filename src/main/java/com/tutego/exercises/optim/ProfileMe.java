package com.tutego.exercises.optim;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ProfileMe {

  public static String compress1( String filename ) throws IOException {
    String s = "";

    try ( RandomAccessFile raf = new RandomAccessFile( filename, "r" ) ) {

      boolean compressing = false;

      for ( int c; (c = raf.read()) != -1; ) {
        if ( c == ' ' || c == '\n' || c == '\t' || c == '\r' ) {
          if ( compressing )
            continue;
          else
            compressing = true;
        }
        else
          compressing = false;

        s += (char) c;
      }
    }
    return s;
  }

  public static String compress2( String filename ) throws IOException {
    String s = "";

    File file = new File( filename );

    try ( RandomAccessFile raf = new RandomAccessFile( file, "r" ) ) {
      boolean compressing = false;

      StringBuilder sb = new StringBuilder();

      for ( int c; (c = raf.read()) != -1; ) {
        if ( c == ' ' || c == '\n' || c == '\t' || c == '\r' ) {
          if ( compressing ) {
            continue;
          }
          else
            compressing = true;
        }
        else
          compressing = false;

        sb.append( (char) c );
      }
      s = sb.toString();
    }

    return s;
  }

  public static String compress3( String filename ) throws IOException {
    String s = "";

    File file = new File( filename );

    long length = file.length();

    try ( BufferedInputStream in = new BufferedInputStream( new FileInputStream( file ) ) ) {

      boolean compressing = false;

      StringBuilder sb = new StringBuilder( (int) length );

      for ( int c; (c = in.read()) != -1; ) {
        if ( c == ' ' || c == '\n' || c == '\t' || c == '\r' ) {
          if ( compressing )
            continue;
          else
            compressing = true;
        }
        else
          compressing = false;

        sb.append( (char) c );

        s = sb.toString();
      }
    }
    return s;
  }

  public static OutputStream compress4( InputStream in, OutputStream out ) throws IOException {

    if ( !(in instanceof BufferedInputStream) )
      in = new BufferedInputStream( in );

    if ( !(out instanceof OutputStream) )
      out = new BufferedOutputStream( out );

    boolean compressing = false;

    for ( int c; (c = in.read()) != -1; ) {
      if ( c == ' ' || c == '\n' || c == '\t' || c == '\r' ) {
        if ( compressing )
          continue;
        else
          compressing = true;
      }
      else
        compressing = false;

      out.write( (char) c );
    }

    in.close();

    return out;
  }

  public static String compress5( String filename ) throws IOException {
    File f = new File( filename );

    StringBuffer sb = new StringBuffer( (int) f.length() );

    try ( RandomAccessFile raf = new RandomAccessFile( f, "r" );
          FileChannel roChannel = raf.getChannel() ) {
      ByteBuffer roBuf = roChannel.map( FileChannel.MapMode.READ_ONLY, 0, (int) roChannel.size() );

      boolean compressing = false;

      while ( roBuf.hasRemaining() ) {
        byte c = roBuf.get();

        if ( c == ' ' || c == '\n' || c == '\t' || c == '\r' )
          if ( compressing )
            continue;
          else
            compressing = true;
        else
          compressing = false;

        sb.append( (char) c );
      }
    }
    return sb.toString();
  }

  public static void main( String[] args ) {

    try {
      // compress3("c:/test.htm");
      // compress4(new FileInputStream("c:/test.htm"), new FileOutputStream("c:/test2.htm"));
      compress5( "c:/test.htm" );
    }
    catch ( IOException ex ) {
      ex.printStackTrace();
    }
  }
}

package com.tutego.exercises.io;

import com.tutego.exercises.io.FileFilters.AbstractFilter;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static com.tutego.exercises.io.FileFilters.*;

//tag::solution[]
class FileFilters {

  public interface AbstractFilter extends DirectoryStream.Filter<Path> {
    default AbstractFilter and( AbstractFilter other ) {
      return path -> accept( path ) && other.accept( path );
    }

    default AbstractFilter negate() {
      return path -> !accept( path );
    }

    static AbstractFilter not( AbstractFilter target ) {
      return target.negate();
    }
  }

  /**
   * Tests if a {@code Path} is readable.
   */
  public static AbstractFilter isReadable = Files::isReadable;

  /**
   * Tests if a {@code Path} is writable.
   */
  public static AbstractFilter isWritable = Files::isWritable;

  /**
   * Tests if a {@code Path} is a regular file.
   */
  public static AbstractFilter isDirectory = Files::isDirectory;

  /**
   * Tests if a {@code Path} is a regular file.
   */
  public static AbstractFilter isRegularFile = Files::isRegularFile;

  /**
   * Tests if a {@code Path} is hidden.
   */
  public static AbstractFilter isHidden = Files::isHidden;

  /**
   * Tests if the file size of a {@code Path} is zero.
   */
  public static AbstractFilter isEmpty = path -> Files.size( path ) == 0L;

  /**
   * Tests if the file size of a {@code Path} is larger than the specified size.
   */
  public static AbstractFilter largerThan( long size ) {
    return path -> Files.size( path ) > size;
  }

  /**
   * Tests if the file size of a {@code Path} is smaller than the specified size.
   */
  public static AbstractFilter smallerThan( long size ) {
    return path -> Files.size( path ) < size;
  }

  /**
   * Tests if a {@code Path} is older than the specified {@code FileTime}.
   */
  public static AbstractFilter olderThan( FileTime other ) {
    return path -> Files.getLastModifiedTime( path ).compareTo( other ) > 0;
  }

  /**
   * Tests if a {@code Path} has a specified suffix, ignoring case, e.g. ".TXT".
   */
  public static AbstractFilter hasSuffix( String suffix, String... more ) {
    return path ->
        Stream.concat( Stream.of( suffix ), Stream.of( more ) )
              .anyMatch( aSuffix -> {
                  String filename = path.toString();
                  int suffixLen = aSuffix.length();
                  int suffixOffset = filename.length() - suffixLen;
                  return filename.regionMatches( /* ignore case */ true, suffixOffset,
                                                                   suffix, 0, suffixLen );
              } );
  }

  /**
   * Tests if the content of a {@code Path} starts with a specified sequence of bytes.
   */
  public static AbstractFilter magicNumber( byte... bytes ) {
    return path -> {
      try ( InputStream in = Files.newInputStream( path ) ) {
        byte[] buffer = new byte[ bytes.length ];
        in.read( buffer );
        return Arrays.equals( bytes, buffer );
      }
    };
  }

  /**
   * Tests if a {@code Path} matches a specified regex.
   */
  public static AbstractFilter match( String regex ) {
    return path -> Pattern.compile( regex ).matcher( path.toString() ).find();
  }
  //end::solution[]
}

public class FileFiltersDemo {
  public static void main( String[] args ) throws IOException {

    Path dir = Paths.get( System.getProperty( "user.home" ) );
    AbstractFilter filter =
        isRegularFile.and( isReadable ).and( magicNumber( (byte) 'G', (byte) 'a' ) );

    try ( DirectoryStream<Path> entries = Files.newDirectoryStream( dir, filter ) ) {
      for ( Path p : entries )
        System.out.println( p );
    }
  }
}
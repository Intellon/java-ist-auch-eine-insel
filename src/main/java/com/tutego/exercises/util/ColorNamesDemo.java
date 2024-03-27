package com.tutego.exercises.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

//tag::solution[]
class ColorNames {
  static class Color {
    String name;
    int rgb;

    static int decodeHexRgb( String value ) {
      String hexRgb = value.length() == 7 ?
          value :
          "#" + value.charAt( 1 ) + value.charAt( 1 ) + value.charAt( 2 ) +
                value.charAt( 2 ) + value.charAt( 3 ) + value.charAt( 3 );
      return Integer.decode( hexRgb );
    }

    @Override public String toString() {
      return "Color{name='" + name + '\'' + ", rgb=#" + Integer.toHexString( rgb ) + '}';
    }
  }

  private final HashMap<Integer, Color> colorMap = new HashMap<>();

  public ColorNames( String filename ) throws IOException {
    List<String> lines = Files.readAllLines( Paths.get( filename ) );
    for ( String line : lines ) {
      String[] tokens = line.split( "([\",])+" );
      Color color = new Color();
      color.name = tokens[ 1 ];
      color.rgb = Color.decodeHexRgb( tokens[ 2 ] );
      colorMap.put( color.rgb, color );
    }
  }

  public Optional<Color> decode( int rgb ) {
    return Optional.ofNullable( colorMap.get( rgb ) );
  }

  public String decodeNames( String string ) {
    StringBuilder sb = new StringBuilder( string );
    for ( int pos = 0; (pos = sb.indexOf( "#", pos )) > 0; pos++ ) {
      String rgbHex = sb.substring( pos, pos + 7 ); // TODO: 7?
      String name = decode( Color.decodeHexRgb( rgbHex ) )
                        .map( color -> color.name ).orElse( rgbHex );
      sb.replace( pos, pos + 7, name );
    }
    return sb.toString();
  }
}
//end::solution[]

public class ColorNamesDemo {

  public static void main( String[] args ) throws Exception {
    ColorNames mapper = new ColorNames( "C:\\Users\\Christian\\Desktop\\colors.csv" );
    // System.out.println( mapper.decode( 7483191 ) );

    String s = mapper.decodeNames( "Hallo #00ff00, das ist schöner als #ffddf4" );
    System.out.println( s );
  }
}

package com.tutego.exercises.optim;

import java.awt.Font;
import java.util.HashMap;
import java.util.Map;

public class FontCache {

  static private Map<FontKey, Font> usedFonts = new HashMap<>();

  public static Font getFont( String name, int style, int size ) {
    FontKey fontKey = new FontKey( name, style, size );

    Font f = usedFonts.get( fontKey );

    if ( f == null ) {
      f = new Font( name, style, size );
      usedFonts.put( fontKey, f );
    }

    return f;
  }
}

class FontKey {
  private final String name;
  private final int style;
  private final int size;
  private final int hashCode;

  FontKey( String name, int style, int size ) {
    this.name = name;
    this.style = style;
    this.size = size;

    long bits = name.hashCode() ^
                Double.doubleToLongBits( style ) ^
                Double.doubleToLongBits( size );

    hashCode = ((int) bits) ^ ((int) (bits >> 32));
  }

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#equals(java.lang.Object)
   */
  public boolean equals( Object obj ) {
    if ( obj instanceof FontKey ) {
      FontKey fk = (FontKey) obj;

      return style == fk.style && size == fk.size && name.equals( fk.name );
    }
    return false;
  }

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#hashCode()
   */
  public int hashCode() {
    return hashCode;
  }
}

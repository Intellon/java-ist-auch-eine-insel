package com.tutego.exercises.optim;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class JarCreator
{
  public static void main( String[] args )
  {
    Collection<String> list = list( "verbose.txt" );

    System.out.println( createJar("out.jar", list) );
  }
 
  /**
   * Erzeugt eine Liste mit allen nicht-Standard-Klassen.
   * 
   * @param filename  Datei mit der Ausgabe von <code>-verbose</code>.
   * @return          Liste mit Strings.
   */
  public static Collection<String> list( String filename )
  {
    Collection<String> list = new ArrayList<String>();

    try ( Reader     reader = new FileReader( filename );
          BufferedReader br = new BufferedReader( reader ) ) {

      for ( String s; (s = br.readLine()) != null; )
      {
        if (     s.startsWith("[Loaded") && s.endsWith("]")
             && !s.endsWith("rt.jar]")
             && !s.endsWith("charsets.jar]")
             && !s.endsWith("sunrsasign.jar]")
             && !s.endsWith("jsse.jar]")
             && !s.endsWith("jce.jar]") )
        {
          list.add( s.substring(8, s.length() - 1) );
        }
      }
    }
    catch ( IOException e )
    {
      e.printStackTrace();
    }
    
    return list;
  }
 
  /**
   * Liefert einen String f�r dieAt Kommandozeile, um mit Jar dieAt
   * Klassen zusammenzubinden.
   * 
   * @param jarFile   Dateiname des entsehenden Jar-Archivs.
   * @param list      Liste mit den Klassennamen.
   * @return          Kommandozeilenstring.
   */ 
  public static String createJar( String jarFile, Collection<String> list )
  {
    String s = "jar cf "+ jarFile + " ";
    
    for ( Iterator<String> iter = list.iterator(); iter.hasNext(); )
     {
      String element = iter.next().replace('.', '/');

      s = s + element + ".class ";
    }

    return s;
  }
}

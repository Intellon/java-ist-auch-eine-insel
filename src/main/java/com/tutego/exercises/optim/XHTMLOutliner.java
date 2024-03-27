package com.tutego.exercises.optim;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

public class XHTMLOutliner {

  public static void main( String[] args ) {
    String input = "http://www.cafeconleche.org";

    try {
      URL u = new URL( input );
      InputStream in = u.openStream();
      XMLInputFactory factory = XMLInputFactory.newInstance();
      XMLStreamReader parser = factory.createXMLStreamReader( in );

      int inHeader = 0;
      for ( int event = parser.next(); event != XMLStreamConstants.END_DOCUMENT; event = parser
              .next() ) {
        switch ( event ) {
          case XMLStreamConstants.START_ELEMENT:
            if ( isHeader( parser.getLocalName() ) ) {
              inHeader++;
            }
            break;
          case XMLStreamConstants.END_ELEMENT:
            if ( isHeader( parser.getLocalName() ) ) {
              inHeader--;
              if ( inHeader == 0 )
                System.out.println();
            }
            break;
          case XMLStreamConstants.CHARACTERS:
            if ( inHeader > 0 )
              System.out.print( parser.getText() );
            break;
          case XMLStreamConstants.CDATA:
            if ( inHeader > 0 )
              System.out.print( parser.getText() );
            break;
        } // end switch
      } // end while
      parser.close();
    }
    catch ( XMLStreamException ex ) {
      System.out.println( ex );
    }
    catch ( IOException ex ) {
      System.out.println( "IOException while parsing " + input );
    }

    try ( OutputStream out = new FileOutputStream( "C:\\data.xml" ) ) {
      XMLOutputFactory factory = XMLOutputFactory.newInstance();
      XMLStreamWriter writer = factory.createXMLStreamWriter( out );

      writer.writeStartDocument( "ISO-8859-1", "1.0" );
      writer.writeStartElement( "greeting" );
      writer.writeAttribute( "id", "g1" );
      writer.writeCharacters( "Hello StAX" );
      writer.writeEndDocument();

      writer.flush();
      writer.close();  // Eigentlich writer, close, doch der ist nicht Closeable, hier wäre der Lambda-Trick möglich
    }
    catch ( Exception ex1 ) {
      ex1.printStackTrace();
    }
  }

  /**
   * Determine if this is an XHTML heading element or not
   * 
   * @param name tag name
   * @return boolean true if this is h1, h2, h3, h4, h5, or h6; false otherwise
   */
  private static boolean isHeader( String name ) {
    if ( name.equals( "h1" ) )
      return true;
    if ( name.equals( "h2" ) )
      return true;
    if ( name.equals( "h3" ) )
      return true;
    if ( name.equals( "h4" ) )
      return true;
    if ( name.equals( "h5" ) )
      return true;
    if ( name.equals( "h6" ) )
      return true;
    return false;
  }

}
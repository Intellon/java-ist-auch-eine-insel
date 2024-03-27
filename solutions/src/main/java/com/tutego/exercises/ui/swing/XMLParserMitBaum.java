package com.tutego.exercises.ui.swing;

import java.io.InputStream;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class XMLParserMitBaum extends DefaultHandler {

  public static void main( String[] args ) throws Exception {
    SAXParserFactory spf = SAXParserFactory.newInstance();
    SAXParser saxParser = spf.newSAXParser();
    XMLReader xr = saxParser.getXMLReader();
    
    XMLParserMitBaum handler = new XMLParserMitBaum();
    xr.setContentHandler( handler );
    xr.setErrorHandler( handler );

    try ( InputStream in = XMLParserMitBaum.class.getResourceAsStream( "secure.xml" ) ) {
      JFrame jf = new JFrame( "Titelübersicht" );
      jf.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

      top = new DefaultMutableTreeNode( "Titel" );
      xr.parse( new InputSource( in ) );

      JTree tree = new JTree( top );

      jf.getContentPane().add( new JScrollPane( tree ) );
      jf.setSize( 200, 500 );
      jf.setVisible( true );
    }
  }

  static DefaultMutableTreeNode top = null;
  DefaultMutableTreeNode sect0 = null;
  DefaultMutableTreeNode sect1 = null;
  DefaultMutableTreeNode sect2 = null;
  DefaultMutableTreeNode sect3 = null;

  private boolean istitle = false;
  private int currentSect = 0;

  @Override
  public void startElement( String uri, String name, String qName, Attributes atts ) {
    if ( "title".equals( qName ) )
      istitle = true;
    if ( "sect1".equals( qName ) )
      currentSect = 1;
    if ( "sect2".equals( qName ) )
      currentSect = 2;
    if ( "sect3".equals( qName ) )
      currentSect = 3;

    // ü�r andere Textdateien mit anderem Aufbau

    if ( "section".equals( qName ) )
      currentSect++;
  }

  @Override
  public void endElement( String uri, String name, String qName ) {
    if ( "section".equals( qName ) )
      currentSect--;
  }

  @Override
  public void characters( char ch[], int start, int length ) {
    String titel;

    if ( istitle ) {
      istitle = false;
      titel = new String( ch, start, length );

      if ( titel.length() > 1 && titel.indexOf( "   " ) == -1 ) {
        System.out.println( currentSect + ":   " + titel );

        DefaultMutableTreeNode node = new DefaultMutableTreeNode( titel );

        switch ( currentSect ) {
          case 0:
            top.add( sect0 = node );
            break;

          case 1:
            sect0.add( sect1 = node );
            break;

          case 2:
            sect1.add( sect2 = node );
            break;

          case 3:
            sect2.add( sect3 = node );
            break;
        }
      }
    }
  }
}
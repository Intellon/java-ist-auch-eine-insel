package com.tutego.exercises.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class WikipediaImageLoader {
  public static void main( String[] args ) throws IOException {
    String url = "https://de.wikipedia.org/wiki/Wikipedia:Hauptseite";

    Document doc = Jsoup.parse( new URL( url ), 1000 );
    for ( Element img : doc.select( "img[src~=\\.(png|gif|jpg)]" ) ) {
      String imgUrl = img.absUrl( "src" );
      try ( InputStream imgStream = new URL( imgUrl ).openStream() ) {
        String filename = imgUrl.replaceAll( "[/:]+", "_" );
        Files.copy( imgStream, Paths.get( filename ),
                    StandardCopyOption.REPLACE_EXISTING );
      }
    }
  }
}

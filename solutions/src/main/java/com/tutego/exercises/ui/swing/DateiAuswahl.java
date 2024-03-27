package com.tutego.exercises.ui.swing;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFileChooser;

public class DateiAuswahl
{
  public static void main( String[] args )
  {
    JFileChooser fc = new JFileChooser();

    DateiAuswahlFilter dAF2 = new DateiAuswahlFilter( "Word-Dokumente", "doc" );
    fc.addChoosableFileFilter( dAF2 );

    List<String> list = Arrays.asList( new String[]{ "doc", "rtf", "txt" } );
    DateiAuswahlFilter dAF1 = new DateiAuswahlFilter( "Alle Word-Dokumente", list );
    fc.addChoosableFileFilter( dAF1 );

    int returnVal = fc.showOpenDialog( null );

    if ( returnVal == JFileChooser.APPROVE_OPTION )
    {
      File file = fc.getSelectedFile();
      System.out.println( "Selektierte Datei : "+ file.getName() );
    }
  }
}

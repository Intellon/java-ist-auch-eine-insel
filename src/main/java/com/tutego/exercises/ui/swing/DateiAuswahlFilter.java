package com.tutego.exercises.ui.swing;
import java.io.File;
import java.util.Arrays;
import java.util.List;

import javax.swing.filechooser.FileFilter;

public class DateiAuswahlFilter extends FileFilter
{
  private List<String> suffixList;
  private String       description;

  public DateiAuswahlFilter( String description, List<String> suffixList )
  {
    this.suffixList = suffixList;

    description += " (";

    description += "*." + suffixList.get( 0 );

    if ( suffixList.size() > 1 )
      for ( int i = 1; i < suffixList.size(); i++ )
        description += ", *." + suffixList.get( i );

    description += ")";
    
    this.description = description;
  }

  public DateiAuswahlFilter( String description, String suffix )
  {
    this( description, Arrays.asList(new String[]{ suffix }) );
  }

  @Override
  public boolean accept( File f )
  {
    String filename = f.getName().toLowerCase();

    if ( f.isDirectory() )
      return true;

    for ( int i = 0; i < suffixList.size(); i++)
    {
      if ( filename.endsWith( (String) suffixList.get(i) ) )
        return true;
    }

    return false;
  }

  @Override
  public String getDescription()
  {
    return description;
  }
}

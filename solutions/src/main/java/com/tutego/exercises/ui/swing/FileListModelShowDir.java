package com.tutego.exercises.ui.swing;

import java.io.File;

import javax.swing.*;

@SuppressWarnings("all")
public class FileListModelShowDir
{
  static class SimpleFileListModel extends AbstractListModel
  {
    private static final long serialVersionUID = 5589912841043048118L;

    private File[] files;

    public SimpleFileListModel( String path )
    {
      File file = new File( path );

      if ( !file.isDirectory() )
        throw new IllegalArgumentException( "Path is not a directory." );

      files = file.listFiles();
    }

    @Override
    public int getSize()
    {
      return files.length;
    }

    @Override
    public Object getElementAt( int index )
    {
      File theFile = files[index];

      if ( theFile.isFile() )
      {
        String erg = "<html>" + theFile.getName() + "  " + "<font color=green>"
                     + "<small>" + theFile.length() + "</small>" + "</font>"
                     + "</html>";

        return erg;
      }

      return theFile.getName();
    }
  }

  public static void main( String[] args )
  {
    JFrame f = new JFrame();
    f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

    ListModel model = new SimpleFileListModel( "C:/" );

    f.getContentPane().add( new JScrollPane( new JList( model ) ) );

    f.pack();
    f.setVisible( true );
  }
}

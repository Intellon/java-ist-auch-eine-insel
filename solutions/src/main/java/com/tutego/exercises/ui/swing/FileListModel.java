package com.tutego.exercises.ui.swing;

import java.io.File;

import javax.swing.AbstractListModel;

public class FileListModel extends AbstractListModel<File>
{
  private static final long serialVersionUID = 4093757728653535566L;

  private File files[];

  public FileListModel( String path )
  {
    files = new File( path ).listFiles();
  }

  @Override
  public File getElementAt( int index )
  {
    return files[index];
  }

  @Override
  public int getSize()
  {
    return files.length;
  }
}

package com.tutego.exercises.optim;

import java.awt.Point;
import java.io.*;
import java.util.*;

public class PunkteSerialisierer
{
  public static void main( String[] args )
  {
    try
    {
      write();
      read();
    }
    catch ( IOException e )
    {
      e.printStackTrace();
    }
  }

  static void write() throws IOException
  {
    PointList punkte = new PointList();
    
    for ( int i = 0; i < 100; i++ )
      punkte.addPoint( new Point(i, i*i) );

    try ( OutputStream fos = new FileOutputStream( "c:/pointlist.ser" );
          ObjectOutputStream oos = new ObjectOutputStream( fos ) )  {
      oos.writeObject( punkte );
    }
  }
  
  static void read() throws IOException
  {
    try ( InputStream fis = new FileInputStream( "c:/pointlist.ser" );
          ObjectInputStream ois = new ObjectInputStream( fis ) ) {
      System.out.println( ois.readObject() );
    }
    catch ( ClassNotFoundException e ) { e.printStackTrace(); }
  }
}

class PointList implements Serializable
{
  private transient List<Point> list = new ArrayList<Point>();

  public void addPoint( Point p ) { list.add( p ); }
  public void add( int x, int y ) { addPoint( new Point(x,y) ); }
  public int size()               { return list.size(); }
  public Point get( int index )   { return (Point) list.get(index); }
  public String toString()        { return list.toString(); }

  /**
   * Saves the state of the <tt>PointList</tt> instance to a stream (that
   * is, serialize it).
   *
   * @serialData The length of the array backing the <tt>ArrayList</tt>
   *             instance is emitted (int), followed by all of its elements
   *             coordinates in the proper order.
   */
  private void writeObject( ObjectOutputStream s ) throws IOException
  {
    int size = list.size();

    //  Write out array length
    
    s.writeInt( size );

    // Write out all elements in the proper order.

    for ( int i = 0; i < size; i++ )
    {
      Point p = (Point) list.get( i );

      s.writeInt( p.x );
      s.writeInt( p.y );
    }
  }

  /**
   * Reconstitute the <tt>PointList</tt> instance from a stream (that is,
   * deserialize it).
   */
  private void readObject( ObjectInputStream s ) throws IOException
  {
    int size = s.readInt();

    list = new ArrayList<Point>( size );

    for ( int i = 0; i < size; i++ )
      list.add( new Point(s.readInt(), s.readInt()) );
  }
}

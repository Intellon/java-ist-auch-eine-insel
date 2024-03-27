package com.tutego.exercises.ui.swing;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.*;

public class JHyperLinkLabel extends JLabel
{
  private static final long serialVersionUID = -8802042069910416075L;

  private String pureText;
  private String url;

  public JHyperLinkLabel( String url )
  {
    this( url, url );
  }

  public JHyperLinkLabel( String name, String url )
  {
    super( name );

    pureText = getText();

    setUrl( url );

    addMouseListener( new MouseAdapter()
    {
      @Override
      public void mouseEntered( MouseEvent e )
      {
        setForeground( Color.BLUE );
        setText( "<html><u>" + pureText + "</u></html>" );
      }

      @Override
      public void mouseExited( MouseEvent e )
      {
        setForeground( Color.BLACK );
        setText( pureText );
      }

      @Override
      public void mouseClicked( MouseEvent e )
      {
        String cmd = "rundll32 url.dll,FileProtocolHandler " + getUrl();

        try
        {
          Runtime.getRuntime().exec( cmd );
        }
        catch ( IOException e1 )
        {
          e1.printStackTrace();
        }
      }
    } );
  }

  public void setUrl( String url )
  {
    this.url = url;
  }

  public String getUrl()
  {
    return url;
  }
}

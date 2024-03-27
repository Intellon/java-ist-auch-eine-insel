package com.tutego.exercises.optim;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.WeakHashMap;

public class WebCache
{
  static class WebObject
  {
      public String type;
      public byte[] content;
  }

  private WeakHashMap<String, WebObject> cache = new WeakHashMap<String, WebObject>();
  
   public WebObject get( String spec ) throws MalformedURLException, IOException
   {
    Object result = cache.get( spec );
  
    if ( result != null )
      return((WebObject)result);
    
    URL url = new URL( spec );
    WebObject obj = new WebObject();
    URLConnection conn = url.openConnection();
    obj.type = conn.getContentType();
    obj.content = new byte[conn.getContentLength()];
    conn.getInputStream().read(obj.content);
    conn.getInputStream().close();
    
    cache.put( spec, obj );
    
    return obj;
   }
}
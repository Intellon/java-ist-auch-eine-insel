package com.tutego.exercises.string;

public class HtmlBuilder {

  //tag::solution[]
  public static String htmlElement( String tag, String body ) {
    if ( tag == null )
      return "";
    if ( body == null )
      body = "";
    return "<" + tag + ">" + body + "</" + tag + ">";
  }

  public static String bold( String body ) {
    return htmlElement( "b", body );
  }

  public static String italic( String body ) {
    return htmlElement( "i", body );
  }
  //end::solution[]

  public static void main( String[] args ) {
    System.out.println( htmlElement( "b", "Bold ist fett." ) );
    System.out.println( bold( italic( "bold und italic" ) ) );
  }
}

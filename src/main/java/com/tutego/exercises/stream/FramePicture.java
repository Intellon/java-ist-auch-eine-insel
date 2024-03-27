package com.tutego.exercises.stream;

import java.util.stream.Collectors;

public class FramePicture {

  //tag::solution[]
  private static String frame( String string ) {
    int max = string.lines().mapToInt( String::length ).max().getAsInt();
    String topBottomBorder = "+" + "-".repeat( max + 4 ) + "+\n";
    String emptyRow = "|  " + " ".repeat( max ) + "  |\n";

    return string.lines()
        .map( s -> "|  " + s + " ".repeat( max - s.length() ) + "  |" )
        .collect( Collectors.joining( "\n",
                                      topBottomBorder + emptyRow,
                                      "\n" + emptyRow + topBottomBorder ) );
  }
  //end::solution[]

  public static void main( String[] args ) {

    String string = "" +
        "     ______\n" +
        "_.-':::::::`.\n" +
        "\\::::::::::::`.-._\n" +
        " \\:::''   `::::`-.`.\n" +
        "  \\         `:::::`.\\\n" +
        "   \\          `-::::`:\n" +
        "    \\______       `:::`.\n" +
        "    .|_.-'__`._     `:::\\\n" +
        "   ,'`|:::|  )/`.     \\:::\n" +
        "  /. -.`--'  : /.\\     ::|\n" +
        "  `-,-'  _,'/| \\|\\\\    |:|\n" +
        "   ,'`::.    |/>`;'\\   |:|\n" +
        "   (_\\ \\:.:.:`((_));`. ;:|\n" +
        "   \\.:\\ ::_:_:_`-','  `-:|\n" +
        "    `:\\\\|     SSt:\n" +
        "       )`__...---'";

    System.out.println( frame( string ) );
  }
}

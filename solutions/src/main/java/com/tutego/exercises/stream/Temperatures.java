package com.tutego.exercises.stream;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.Math.*;
import static java.time.Month.*;
import static java.util.Locale.ENGLISH;
import static java.util.stream.Collectors.toMap;

public class Temperatures {
  //tag::solution[]
  private static int[] randomTemperaturesForYear( Year year ) {
    int daysInYear = year.length();
    return IntStream.range( 0, daysInYear )
        .mapToDouble( value -> sin( value * PI / daysInYear ) ) // 0..1
        .map( value -> value * 20 ) // 0..20
        .map( value -> value + 10 ) // 10..30
        .mapToInt( value -> (int) (value + 3 * (random() - 0.5)) )
        .toArray();
  }

  private static Map<Year, int[]> createRandomTemperatureMap() {
    return Stream.iterate( Year.now(), year -> year.minusYears( 1 ) )
        .limit( 5 )
        .collect( toMap( Function.identity(), Temperatures::randomTemperaturesForYear ) );
  }

  private static void printTemperatureTable( Map<Year, int[]> yearToTemperatures ) {
    yearToTemperatures.forEach( ( year, temperatures ) -> {
      String temperatureCells =
          Arrays.stream( temperatures ).boxed()
                .map( temperature -> String.format( "%2d", temperature ) )
                .collect( Collectors.joining( " | ", "|", " | " ) );
      System.out.printf( "| %s %s%n", year, temperatureCells );
    } );
  }

  private static IntSummaryStatistics getStatistics( YearMonth yearMonth, int... temperatures ) {
    int start = yearMonth.atDay( 1 ).getDayOfYear() - 1;
    int end   = yearMonth.atEndOfMonth().getDayOfYear();  // not -1 because end is exclusive
    return Arrays.stream( temperatures, start, end ).summaryStatistics();
  }

  private static String generateTemperatureHtml( Year year, Map<Year, int[]> yearToTemperatures ) {
    String template = "<!DOCTYPE html>\n" +
        "<html lang=\"en\">\n" +
        "<body>\n" +
        "<canvas id=\"chart\" width=\"500\" height=\"200\"></canvas>\n" +
        "<script src=\"https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.bundle.min.js\"></script>\n" +
        "<script>\n" +
        "const cfg = {\n" +
        "    type: 'bar',\n" +
        "    data: {\n" +
        "        labels: [\"Jan\", \"Feb\", \"Mrz\", \"Apr\", \"Mai\", \"Jun\", " +
        "                 \"Jul\", \"Aug\", \"Sep\", \"Okt\", \"Nov\", \"Dez\"],\n" +
        "        datasets: [ {\n" +
        "            label: \"Durchschnittswerte\", fill: false,\n" +
        "            data: [%s],\n" +
        "        } ]\n" +
        "    },\n" +
        "    options: {\n" +
        "        responsive: true,\n" +
        "        title: { display:true, text:'Temperaturverlauf' },\n" +
        "        tooltips: { mode: 'index', intersect: false },\n" +
        "        hover: { mode: 'nearest', intersect: true },\n" +
        "        scales: {\n" +
        "            xAxes: [ { display: true, scaleLabel: { display: true, labelString: 'Monat' } } ],\n" +
        "            yAxes: [ { display: true, scaleLabel: { display: true, labelString: 'Temperatur' } } ]\n" +
        "        }\n" +
        "    }\n" +
        "};\n" +
        "window.onload = () => new Chart(document.getElementById(\"chart\").getContext(\"2d\"), cfg);\n" +
        "</script>\n" +
        "\n" +
        "</body>\n" +
        "</html>";

    String formattedTemperatures = IntStream.rangeClosed( JANUARY.getValue(), DECEMBER.getValue() )
        .mapToObj( Month::of )
        .map( month -> year.atMonth( month ) )
        .map( yearMonth -> getStatistics( yearMonth, yearToTemperatures.get( year ) ) )
        .map( IntSummaryStatistics::getAverage )
        .map( avgTemperature -> String.format( ENGLISH, "%.1f", avgTemperature ) )
        .collect( Collectors.joining( "," ) );
    return String.format( template, formattedTemperatures );
  }

  public static void main( String[] args ) {

    Map<Year, int[]> yearToTemperatures = createRandomTemperatureMap();

    printTemperatureTable( yearToTemperatures );

    IntSummaryStatistics yearStatistics =
        Arrays.stream( yearToTemperatures.get( Year.now() ) ).summaryStatistics();
    System.out.printf( "%s Max: %d%n%s Min: %d%n",
                       yearStatistics.getMax(), yearStatistics.getMin() );

    IntSummaryStatistics monthStatistics =
        getStatistics( YearMonth.of( 2020, SEPTEMBER ), yearToTemperatures.get( Year.now() ) );
    System.out.printf( "Max: %d%nMin: %d%nAvg: %.2f%n", monthStatistics.getMax(),
                       monthStatistics.getMin(), monthStatistics.getAverage() );

    try {
      Path tempFile = Files.createTempFile( "temperatures", ".html" );
      String html = generateTemperatureHtml( Year.now(), yearToTemperatures );
      Files.writeString( tempFile, html );
      Desktop.getDesktop().browse( tempFile.toUri() );
    }
    catch ( IOException e ) {
      e.printStackTrace();
    }
  }
  //end::solution[]
}

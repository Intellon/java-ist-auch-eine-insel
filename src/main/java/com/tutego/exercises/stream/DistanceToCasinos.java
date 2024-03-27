package com.tutego.exercises.stream;

import java.awt.*;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DistanceToCasinos {
  public static void main( String[] args ) {
    Point.Double[] targets = { // Latitude, Longitude
                               new Point.Double( 44.7226698, 1.6716612 ),
                               new Point.Double( 50.4677807, -1.5833018 ),
                               new Point.Double( 44.7226698, 1.6716612 )
    };
    Function<Point.Double, Integer> distanceToDon =
        coordinate -> distance( coordinate.x, coordinate.y, 40.2390577, 3.7138939 );
    Map<Point.Double, Integer> map1 = Arrays.stream( targets )
        .distinct()
        .collect( Collectors.toMap( Function.identity(), distanceToDon ) );
    Map<Point.Double, Integer> map2 = Arrays.stream( targets ).collect(
        Collectors.toMap( Function.identity(), distanceToDon, ( d1, d2 ) -> d1 ) );

    System.out.println( map1 );
    System.out.println( map2 );
  }

  // Haversine formula
  private static int distance( double lat1, double lng1, double lat2, double lng2 ) {
    double earthRadius = 6371; // km
    double dLat = Math.toRadians( lat2 - lat1 );
    double dLng = Math.toRadians( lng2 - lng1 );
    double a = Math.sin( dLat / 2 ) * Math.sin( dLat / 2 ) +
        Math.cos( Math.toRadians( lat1 ) ) * Math.cos( Math.toRadians( lat2 ) ) *
            Math.sin( dLng / 2 ) * Math.sin( dLng / 2 );
    double d = 2 * Math.atan2( Math.sqrt( a ), Math.sqrt( 1 - a ) );
    return (int) (earthRadius * d);
  }
}

import java.time.LocalDateTime;
import java.util.Objects;

public class T {

  public static void main( String[] args ) {

    //    Object rnd = new Random();
    //    System.out.println( rnd.getClass() == Random.class );
    //    System.out.println( rnd.getClass().equals( Random.class ) );
    //    System.out.println( rnd.getClass().equals( Objects.class ) );
    //    System.out.println( rnd.getClass().isInstance( Random.class ) );
    //    System.out.println( rnd.getClass().isInstance( Objects.class ) );
    //    System.out.println( Random.class.isInstance( rnd ) );
    //    System.out.println( Object.class.isInstance( rnd ) );
    //    System.out.println( Random.class.isAssignableFrom( Random.class ) );
    //    System.out.println( Random.class.isAssignableFrom( Objects.class ) );
    //    System.out.println( rnd instanceof Random );
    //    System.out.println( rnd instanceof Object );
    //

    //    Class<?> state = Thread.State.class;
    //    System.out.println( state.getName() );
    //    System.out.println( state.getSimpleName() );
    //    System.out.println( state.toGenericString() );
    //
    //    //---------------
    //

    // polygone überlagen

    //    //    String string = "eclectic";
    //    //    String collect = string.chars()
    //    //        .mapToObj( c -> Character.toString( c ) + string.chars().filter( d -> d == c ).count() )
    //    //        .collect( Collectors.joining( "/" ) );
    //    //    System.out.println( collect ); // e2c3l1e2c3t1i1c3
    //
    //    // https://icanhazdadjoke.com/api#fetch-a-random-dad-joke
    //    //    https://docs.postman-echo.com/?version=latest
    //    //            .uri( new URI( "https://postman-echo.com/get" ) )
    //
    //    //    https://icanhazdadjoke.com/
    //    HttpRequest request = HttpRequest.newBuilder()
    //        .uri( new URI( "https://icanhazdadjoke.com/" ) )
    //        .header( "Accept", "text/plain" )
    //        .GET()
    //        .build();
    //
    //    //    GET https://icanhazdadjoke.com/j/<joke_id>
    //
    //    HttpClient httpClient = HttpClient.newBuilder().build();
    //    HttpResponse<String> response =
    //        httpClient.send( request, HttpResponse.BodyHandlers.ofString() );
    //    System.out.println( response.body() );
  }
}

// https://codegolf.stackexchange.com/questions/205834/special-string-reformatting

//    https://practice.geeksforgeeks.org/problems/design-a-tiny-url-or-url-shortener/0
//    String s = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789@$-~_.";
//
//    long l = Math.abs( new Random().nextLong() );
//    System.out.println( l );
//    while ( l > 0 ) {
//      System.out.print( s.charAt( (int) (l % s.length()) ) );
//      l = l / s.length();
//    }
  /*
//  https://www.reddit.com/r/dailyprogrammer/comments/99d24u/20180822_challenge_366_intermediate_word_funnel_2/
  private static void funnel( String word, Set<String> words ) {
    //

    //    String word = "gnash";
    //
    //    String filename = "C:\\Users\\Christian\\Downloads\\enable1.txt";
    //    Set<String> words = new HashSet<>( Files.readAllLines( Paths.get( filename ) ) );
    //    funnel( word, words );

    System.out.println( word );
    IntStream.range( 0, word.length() )
        .mapToObj( index -> new StringBuilder( word ).deleteCharAt( index ).toString() )
        .filter( words::contains )
        .forEach( newWord -> funnel( newWord, words ) );
  }
}
*/

class ThreadCreationTime {

  private static final ThreadLocal<LocalDateTime> threadCreationTime =
      ThreadLocal.withInitial( LocalDateTime::now );

  public static LocalDateTime creationTime() {
    return threadCreationTime.get();
  }
}

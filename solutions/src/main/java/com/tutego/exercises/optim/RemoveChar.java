package com.tutego.exercises.optim;
public class RemoveChar
{
	public static String removeChar( String s, char c )
	{
     if ( s == null )
     	return null;

	 int pos = s.indexOf( c );
	 
	 if ( pos == -1 )
	 	return s;

	 int len = s.length();

	 StringBuffer sb = new StringBuffer( len - 1 );
	 sb.append( s.substring(0, pos) );

	 for ( int i = pos; i < len; i++ )
	 {
	 	char t = s.charAt(i);

	 	if ( t != c )
	 		sb.append( t );
	 }

	 return sb.toString();
	}

	public static void main( String[] args )
	{
		System.out.println( removeChar("hallo huhulo", 'l') );
		System.out.println( removeChar("hallo huhulo", 'x') );
		System.out.println( removeChar("", 'x') );
		System.out.println( removeChar(null, 'x') );
	}
}

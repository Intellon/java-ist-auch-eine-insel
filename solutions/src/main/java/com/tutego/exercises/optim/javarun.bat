Zum Testen am Besten zwei Shells öffnen:

Übersetzen:

C:\Programme\j2sdk1.5.0\src>javac -source 1.5 java\lang\AbstractStringBuilder.java

--------------
    /**
     * This implements the expansion semantics of ensureCapacity with no
     * size check or synchronization.
     */
    void expandCapacity(int minimumCapacity) {
	int newCapacity = (value.length + 1) * 2;
        if (newCapacity < 0) {
            newCapacity = Integer.MAX_VALUE;
        } else if (minimumCapacity > newCapacity) {
	    newCapacity = minimumCapacity;
	}	
	char newValue[] = new char[newCapacity];

        l.add( new Integer(newCapacity) );

        if ( l.size() > 50 )
        {
            // Syso ruft ja wieder rekursiv append() auf!
            
            for ( int i = 0; i < l.size(); i++ )
            {
                System.err.println( l.get(i) );
            }
            l.clear();
        }
        
	System.arraycopy(value, 0, newValue, 0, count);
	value = newValue;
    }

    private static java.util.ArrayList<Integer> l = new java.util.ArrayList<Integer>();
 --------------

Jar-Archiv bauen:

C:\Programme\j2sdk1.5.0\src>jar cfv fix.jar java/lang/AbstractStringBuilder.class


Zum Starten ein Bat:

SET J2SDK=C:\Programme\j2sdk1.5.0
SET NEWCLASSES=fix.jar
%J2SDK%\bin\java -Xbootclasspath/p:%J2SDK%\src\%NEWCLASSES% A


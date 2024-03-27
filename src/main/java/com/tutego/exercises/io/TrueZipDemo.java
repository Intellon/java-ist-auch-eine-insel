package com.tutego.exercises.io;

import de.schlichtherle.truezip.nio.file.TPath;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class TrueZipDemo {
  public static void main( String[] args )
      throws IOException, LineUnavailableException, UnsupportedAudioFileException, InterruptedException {
    //tag::solution[]
    URI uri = Paths.get( "C:\\Users\\Christian\\Desktop\\InsectSounds_2.zip" ).toUri();
    Path path = new TPath( uri );

    List<Path> wavFiles = new ArrayList<>();
    try ( DirectoryStream<Path> entries = Files.newDirectoryStream( path ) ) {
      entries.forEach( wavFiles::add );
    }

    while ( true ) {
      Path randomWavFile = wavFiles.get( ThreadLocalRandom.current().nextInt( wavFiles.size() ) );
      try ( InputStream fis = Files.newInputStream( randomWavFile );
            BufferedInputStream bis = new BufferedInputStream( fis ); // for mark/reset support
            AudioInputStream ais = AudioSystem.getAudioInputStream( bis ) ) {
        Clip clip = AudioSystem.getClip();
        clip.open( ais );
        clip.start();
        TimeUnit.MICROSECONDS.sleep( clip.getMicrosecondLength() + 50 );
        clip.close();
      }
    }
    //end::solution[]
  }
}

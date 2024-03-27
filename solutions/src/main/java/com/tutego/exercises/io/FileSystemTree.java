package com.tutego.exercises.io;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;

public class FileSystemTree {

  public static void main( String[] args ) {
    //tag::solution[]
    class PrintingFileVisitor implements FileVisitor<Path> {

      int increment = 0;

      private String spacer() {
        char[] chars = new char[ increment * 2 ];
        Arrays.fill( chars, ' ' );
        return new String( chars );
      }

      @Override
      public FileVisitResult preVisitDirectory( Path dir, BasicFileAttributes attrs ) {
        System.out.println( spacer() + "\uD83D\uDDC0 " + dir.getFileName() );
        increment++;
        return FileVisitResult.CONTINUE;
      }

      @Override public FileVisitResult postVisitDirectory( Path dir, IOException exc ) {
        increment--;
        return FileVisitResult.CONTINUE;
      }

      @Override
      public FileVisitResult visitFile( Path visitedFile, BasicFileAttributes fileAttributes ) {
        System.out.println( spacer() + visitedFile.getFileName() );
        return FileVisitResult.CONTINUE;
      }

      @Override public FileVisitResult visitFileFailed( Path file, IOException exc ) {
        return FileVisitResult.CONTINUE;
      }
    }

    String directory = "D:\\Dropbox\\Öffentliche Bilder";
    try {
      Files.walkFileTree( Paths.get( directory ), new PrintingFileVisitor() );
    }
    catch ( IOException e ) {
      e.printStackTrace();
    }
    //end::solution[]
  }
}

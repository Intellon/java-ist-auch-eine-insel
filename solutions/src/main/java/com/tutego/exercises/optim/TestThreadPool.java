package com.tutego.exercises.optim;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThreadPool
{
  static class MyRunnable implements Runnable
  {
    public void run()
    {
      System.out.println( Thread.currentThread() );

      try {
        Thread.sleep( 1000 );
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

    }
  }

  public static void main(String[] args)
  {
    ExecutorService s = Executors.newCachedThreadPool();

    Runnable run = new MyRunnable();

    s.execute( run );
    s.execute( run );
    s.execute( run );
    s.execute( run );
    s.execute( run );
    s.execute( run );
    s.execute( run );
    s.execute( run );
    s.execute( run );
    s.execute( run );
    s.execute( run );
    s.execute( run );
  }
}

/*
 Mit auskommentierten Programmblock:

  Thread[pool-1-thread-1,5,main]
  Thread[pool-1-thread-2,5,main]
  Thread[pool-1-thread-3,5,main]
  Thread[pool-1-thread-4,5,main]
  Thread[pool-1-thread-1,5,main]
  Thread[pool-1-thread-5,5,main]

 Ohne auskommentierten Programmblock:

  Thread[pool-1-thread-1,5,main]
  Thread[pool-1-thread-2,5,main]
  Thread[pool-1-thread-3,5,main]
  Thread[pool-1-thread-4,5,main]
  Thread[pool-1-thread-5,5,main]
  Thread[pool-1-thread-6,5,main]
*/

package com.sdacademy.httpdemo.thrA;

public class Threads5DemoGood {
  private static boolean stopRequested = false;

  private static synchronized void requestStop() {
    stopRequested = true;
  }

  private static synchronized boolean isStopRequested() {
    return stopRequested;
  }

  public static void main(String[] args) throws Exception {
    Thread t = new Thread(() -> {
      int i = 0;
      while (!stopRequested) {
        i++;
        if (i % 15000 == 0) {
          System.out.println(i);
        }
      }
    });
    t.start();
    Thread.sleep(1000);
    requestStop();
  }
}

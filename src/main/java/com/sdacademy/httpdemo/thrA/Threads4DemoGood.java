package com.sdacademy.httpdemo.thrA;

public class Threads4DemoGood {

  private static volatile boolean stopRequested = false;

  public static void main(String[] args) throws Exception {
    Thread t = new Thread(() -> {
      int i = 0;
      while (!stopRequested) {
        i++;
        if (i % 10000 == 0) {
          System.out.println(i);
        }
      }
    });
    t.start();
    Thread.sleep(1000);
    stopRequested = true;
  }
}

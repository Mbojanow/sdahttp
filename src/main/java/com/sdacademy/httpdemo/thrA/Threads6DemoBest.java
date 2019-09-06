package com.sdacademy.httpdemo.thrA;

public class Threads6DemoBest {
  public static void main(String[] args) throws Exception {
    Thread t = new Thread(() -> {
      int i = 0;
      while (!Thread.currentThread().isInterrupted())  {
        i++;
        if (i % 20000 == 1) {
          System.out.println(i);
        }
      }
    });
    t.start();
    Thread.sleep(1000);
    t.interrupt();
    t.join();
  }
}

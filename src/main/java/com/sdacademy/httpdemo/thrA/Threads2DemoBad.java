package com.sdacademy.httpdemo.thrA;

public class Threads2DemoBad {

  public static void main(String[] args) throws InterruptedException {
    Thread t = new Thread(() -> { int i = 0;
      while (true) {
        i++;
        if (i % 10 == 0) {
          System.out.println(i);
        }
      }
    });
    t.start();
    Thread.sleep(1000);
    t.stop();
    t.join();
  }
}

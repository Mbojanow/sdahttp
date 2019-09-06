package com.sdacademy.httpdemo.thrA;

public class Threads1Demo {

  public static void main(String[] args) throws InterruptedException {
    Thread ta = new Thread(new MyGoodRunnable());
    ta.start();
    System.out.println("TA started!");
    ta.join();

    Thread tb = new Thread(new MyBadThread());
    tb.start();
    System.out.println("TB started");
    tb.join();
  }
}

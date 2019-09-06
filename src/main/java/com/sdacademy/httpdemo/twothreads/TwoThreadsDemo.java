package com.sdacademy.httpdemo.twothreads;

public class TwoThreadsDemo {

  public static void main(String[] args) throws InterruptedException {
    Runnable r1 = new PersonAThread("Andrzej");
    Runnable r2 = new PersonBThread("Krzysztof");

    Thread t1 = new Thread(r1);
    Thread t2 = new Thread(r2);
    t1.start();
    t2.start();
    t1.join();
    t2.join();
  }
}

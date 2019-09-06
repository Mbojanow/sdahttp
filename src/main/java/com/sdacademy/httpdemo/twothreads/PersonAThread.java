package com.sdacademy.httpdemo.twothreads;

public class PersonAThread implements Runnable {

  public PersonAThread(final String name) {
    this.name = name;
  }

  private final String name;

  @Override
  public void run() {
    try {
      Thread.sleep(1000);
      System.out.println(name + " is waking up");
      Thread.sleep(2000);
      System.out.println(name + " is preparing breakfast");
      Thread.sleep(5000);
      System.out.println(name + " finished his day");
    } catch (InterruptedException e) {
      System.out.println("Thread interrupted");
    }
  }
}

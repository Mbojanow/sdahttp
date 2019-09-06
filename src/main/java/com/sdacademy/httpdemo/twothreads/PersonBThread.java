package com.sdacademy.httpdemo.twothreads;

public class PersonBThread implements Runnable {

  private final String name;

  public PersonBThread(final String name) {
    this.name = name;
  }

  @Override
  public void run() {
    try {
      Thread.sleep(500);
      System.out.println(name + " eating breakfast");
      Thread.sleep(4000);
      System.out.println(name + " is eating dinner");
      Thread.sleep(1000);
      System.out.println(name + " went to sleep");
    } catch (InterruptedException e) {
      System.out.println("PersonBThread interrupted");
    }
  }
}

package com.sdacademy.httpdemo.thrA;

public class MyBadThread extends Thread {
  @Override
  public void run() {
    System.out.println("I should not be created this way");
  }
}

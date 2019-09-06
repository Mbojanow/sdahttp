package com.sdacademy.httpdemo.thrA;

public class MyGoodRunnable implements Runnable {
  @Override
  public void run() {
    System.out.println("I am a separate thread " + Thread.currentThread().getId() + " " + Thread.currentThread().getName());
  }
}

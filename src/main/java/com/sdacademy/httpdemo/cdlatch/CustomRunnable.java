package com.sdacademy.httpdemo.cdlatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class CustomRunnable implements Runnable {

  private static volatile int counter = 0;

  private CountDownLatch countDownLatch;

  public CustomRunnable(CountDownLatch countDownLatch) {
    this.countDownLatch = countDownLatch;
    counter = 0;
  }

  @Override
  public void run() {
    try {
      Thread.sleep(Math.abs(new Random().nextInt() % 1000));
      System.out.println("Doing some work");
      counter++;

    } catch (InterruptedException e) {
      System.out.println("Interrupted");
    }
    countDownLatch.countDown();

    if (counter == 5) {
      System.out.println("Job done");
    }
  }
}

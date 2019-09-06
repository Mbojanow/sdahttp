package com.sdacademy.httpdemo.cdlatch;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountDownLatchDemo {


  public static void main(String[] args) throws InterruptedException {
    CountDownLatch cdl = new CountDownLatch(5);

    List<Thread> threads = Stream.generate(() -> new Thread(new CustomRunnable(cdl))).limit(5)
        .collect(Collectors.toList());

    threads.forEach(Thread::start);
    for (Thread thread : threads) {
      thread.join();
    }
  }
}

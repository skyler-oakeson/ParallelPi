package org.example;

import java.util.ArrayList;

public class App {
  public static void main(String[] args) {
    long start = System.currentTimeMillis();
    TaskQueue tq = new TaskQueue();
    ResultTable rt = new ResultTable();
    Bpp bpp = new Bpp();

    ArrayList<Integer> tasks = new ArrayList<Integer>();
    for (int digit = 1; digit <= 1000; digit++) {
      tasks.add(digit);
    }
    java.util.Collections.shuffle(tasks);
    tq.add(tasks);

    Thread[] threads = new Thread[Runtime.getRuntime().availableProcessors()];
    for (int id = 0; id < Runtime.getRuntime().availableProcessors(); id++) {
      threads[id] = new DigitWorker(tq, rt, bpp);
      threads[id].start();
    }

    for (Thread thread: threads) {
      try {
        thread.join();
      } catch (InterruptedException e) {
        thread.interrupt();
        System.out.println("Failed to calculate pi.");
      }
    }

    long end = System.currentTimeMillis();

    System.out.println(rt);
    System.out.printf("Elapsed Time: %d Milliseconds", (end - start));
  }
}

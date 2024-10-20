package org.example;

public class App {
  public static void main(String[] args) {
    final long INCREMENT = 1_000;
    try {
      Thread[] threads = new Thread[Runtime.getRuntime().availableProcessors()];
      long start = 1;
      long end = INCREMENT;

      long timeStart = System.currentTimeMillis();
      for (int thread = 0; thread < Runtime.getRuntime().availableProcessors(); thread++) {
        threads[thread] = new Thread(); // insert pi function here
        threads[thread].start();
        start += INCREMENT;
        end += INCREMENT;
      }

      for (Thread t : threads) {
        t.join();
      }
        long timeEnd = System.currentTimeMillis();
        System.out.printf("The execution time in seconds was: %.3f\n", (timeEnd - timeStart) / 1000.0);
    } catch (Exception ex) {
      System.out.println("Something bad happened");
    }
  }
}

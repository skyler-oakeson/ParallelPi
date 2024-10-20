package org.example;

public class DigitWorker extends Thread {
  private TaskQueue tq;
  private ResultTable rt;
  private Bpp bpp;

  public DigitWorker(TaskQueue tq, ResultTable rt, Bpp bpp) {
    this.tq = tq;
    this.rt = rt;
    this.bpp = bpp;
  }

  @Override
  public void run() {
    Integer digit;
    while ((digit = tq.pop()) != null) {
      Integer decimal = bpp.getDecimal(digit);
      rt.addResult(digit, decimal);

      synchronized(System.out) {
        if (tq.size() % 10 == 0) {
          System.out.print("\033[1F\33[K");
          System.out.printf("Progress: %d%%\n", 100 - (tq.size() / 10));
          System.out.flush();
        }
      }
    }
  }
}

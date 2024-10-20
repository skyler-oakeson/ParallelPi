package org.example;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

public class ResultTable {
  private HashMap<Integer, Integer> table = new HashMap<Integer, Integer>();
  private ReentrantLock rl = new ReentrantLock();

  public void addResult(Integer key, Integer val) {
    rl.lock();
    try {
      this.table.putIfAbsent(key, val);
    } finally {
      rl.unlock();
    }
  }

  public String toString() {
    String res = "\n3.";
    for (int key = 1; key <= table.size(); key++) {
      res += table.get(key);
    }
    res += "\n";
    return res;
  }
}

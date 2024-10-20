package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;

public class TaskQueue {
  private LinkedList<Integer> queue = new LinkedList<Integer>();
  private ReentrantLock rl = new ReentrantLock();

  public void add(Integer task) {
    rl.lock();
    try {
      queue.add(task);
    } finally {
      rl.unlock();
    }
  }

  public void add(ArrayList<Integer> tasks) {
    rl.lock();
    try {
      for (Integer task : tasks) {
        queue.add(task);
      }
    } finally {
      rl.unlock();
    }
  }


  public Integer pop() {
    rl.lock();
    try {
      return queue.isEmpty() ? null : queue.pop();
    } finally {
      rl.unlock();
    }
  }
}

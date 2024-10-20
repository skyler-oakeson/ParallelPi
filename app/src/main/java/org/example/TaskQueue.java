package org.example;
import java.util.LinkedList;
import java.util.concurrent.Callable;

public class TaskQueue {
    public LinkedList<Callable<Integer>> queue;
}

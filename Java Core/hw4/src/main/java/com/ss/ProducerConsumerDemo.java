package com.ss;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * A simple producer consumer that uses a bounded buffer
 * The size never goes above the capacity which is 5
 * You can play with Thead.sleep to check and verify different scenarios
 */
public class ProducerConsumerDemo {
  public static void main(String[] args) {
    List<Integer> buffer = new ArrayList<>();
    int capacity = 5;

    Runnable producer = () -> {
      try {
        int value = 1;
        while (value < 19) {
          synchronized (buffer) {
            while (buffer.size() == capacity)
              buffer.wait();
            buffer.add(value++);
            System.out.println("Producer produced " + value + " | size is " + buffer.size());
            buffer.notify();
//            Thread.sleep(100);
          }
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    };
    Runnable consumer = () -> {
      try {
        while (true) {
          synchronized (buffer) {
            while (buffer.size() == 0)
              buffer.wait();
            int val = buffer.remove(0);
            System.out.println("Consumer consumed " + val + " | size is " + buffer.size());
            buffer.notify();
            Thread.sleep(1000);
          }
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    };
    Thread t1 = new Thread(producer);
    Thread t2 = new Thread(consumer);
    t1.start();
    t2.start();
    try {
      t1.join();
      t2.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}

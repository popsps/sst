package com.ss;

public class DeadlockDemo {
  public static void main(String[] args) {

    System.out.println("Start of the main thread");
    Integer a = 100;
    Integer b = 200;
    Runnable r1 = () -> {
      try {
        synchronized (a) {
          System.out.println(Thread.currentThread().getName()
              + " acquired lock for a");
          Thread.sleep(300);
          synchronized (b) {
            System.out.println("I can't get printed due to deadlock");
          }
        }
      } catch (Exception e) {
      }
    };
    Runnable r2 = new Runnable() {
      public void run() {
        try {
          synchronized (b) {
            System.out.println(Thread.currentThread().getName()
                + " acquired lock for b");
            Thread.sleep(300);
            synchronized (a) {
              System.out.println("I can't get printed due to deadlock");
            }
          }
        } catch (Exception e) {
        }
      }
    };
    Thread t1 = new Thread(r1);
    Thread t2 = new Thread(r2);
    t1.start();
    t2.start();
    System.out.println("You have reached the end of the main thread");
  }
}

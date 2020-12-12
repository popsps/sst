package com.ss;

/**
 * A simple singleton example with double checked locking
 */
public class SingletonExample {
  private static volatile SingletonExample instance = null;

  private SingletonExample() {
  }

  public static SingletonExample getInstance() {
    if (instance == null) {
      synchronized (SingletonExample.class) {
        if (instance == null)
          instance = new SingletonExample();
      }
    }
    return instance;
  }
}

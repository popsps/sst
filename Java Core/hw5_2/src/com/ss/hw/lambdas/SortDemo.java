package com.ss.hw.lambdas;

import java.util.Arrays;

public class SortDemo {
  public static void main(String[] args) {
    String[] arr = new String[]{"Nicolas ", "Kaydee", "Atif", "Katie",
        "Alvin", "Robin", "Allen", "Ammara", "Blaine"};
    // sort by length
    Arrays.sort(arr, (s1, s2) -> s1.length() - s2.length());
    Arrays.stream(arr).forEach(name -> System.out.print(name + " "));
    System.out.println();
    // sort by length reverse
    Arrays.sort(arr, (s1, s2) -> s2.length() - s1.length());
    Arrays.stream(arr).forEach(name -> System.out.print(name + " "));
    System.out.println();
    // sort by alphabetically
    Arrays.sort(arr, (s1, s2) -> s1.charAt(0) - s2.charAt(0));
    Arrays.stream(arr).forEach(name -> System.out.print(name + " "));
    System.out.println();
    // sort by string that contains e first everything else second
    Arrays.sort(arr, (s1, s2) -> {
      if (s1.contains("e"))
        return 1;
      else if (s2.contains("e"))
        return 1;
      return 0;
    });
    Arrays.stream(arr).forEach(name -> System.out.print(name + " "));
    System.out.println();
  }
}

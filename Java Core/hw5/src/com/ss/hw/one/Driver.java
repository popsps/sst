package com.ss.hw.one;

import java.util.Arrays;
import java.util.Scanner;


// check if an Integer is odd
@FunctionalInterface
interface IsOdd {
  public Boolean apply(Integer n);
}

// check if an Integer is prime
@FunctionalInterface
interface IsPrime {
  public Boolean apply(Integer n);
}

// check if an Integer is palindrome
@FunctionalInterface
interface IsPalindrome {
  public Boolean apply(Integer n);
}

/**
 * input:
 * number of test cases
 * test# value
 * test numbers: 1 = isOdd, 2 = isPrime, 3 = isPalindrome
 */
public class Driver {
  public static void main(String[] args) {
    // defining lambda functions
    IsOdd isOdd = n -> (n % 2 == 1) ? true : false;
    IsPrime isPrime = n -> {
      if (n <= 1)
        return false;
      for (int i = 2; i < n; i++) {
        if (n % i == 0)
          return false;
      }
      return true;
    };
    IsPalindrome isPalindrome = n -> {
      String sNum = n.toString();
      int l = sNum.length();
      for (int i = 0; i < Math.ceil(l / 2.0) && i < l - i - 1; i++) {
        if (sNum.charAt(i) != sNum.charAt(l - i - 1))
          return false;
      }
      return true;
    };
    // getting and parsing the input
    Scanner stdin = new Scanner(System.in);
    Integer numberOfTests = Integer.parseInt(stdin.nextLine().strip());
    Integer[][] tests = new Integer[numberOfTests][];
    for (int i = 0; i < numberOfTests; i++) {
      tests[i] = Arrays.stream(stdin.nextLine().strip().split(" "))
          .map(s -> Integer.parseInt(s)).toArray(size -> new Integer[size]);
    }
    // Generating output
    for (int i = 0; i < numberOfTests; i++) {
      switch (tests[i][0]) {
        case 1:
          if (isOdd.apply(tests[i][1]))
            System.out.println("ODD");
          else
            System.out.println("EVEN");
          break;
        case 2:
          if (isPrime.apply(tests[i][1]))
            System.out.println("PRIME");
          else
            System.out.println("COMPOSITE");
          break;
        case 3:
          if (isPalindrome.apply(tests[i][1]))
            System.out.println("PALINDROME");
          else
            System.out.println("NOT PALINDROME");
          break;
        default:
          System.out.println("Wrong input type");
          break;
      }
    }
  }
}

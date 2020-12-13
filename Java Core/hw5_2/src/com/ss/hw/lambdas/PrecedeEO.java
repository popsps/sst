package com.ss.hw.lambdas;

import java.util.Arrays;

public class PrecedeEO {
  public static void main(String[] args) {
    Integer[] numbers = new Integer[]{3, 44, 43, 56, 0, 12, 1, 2};
    System.out.println(addEO(numbers));
  }

  public static String addEO(Integer[] nums) {
    Integer lastNumber = nums[nums.length - 1];
    String lns = (lastNumber % 2 == 0) ? "e" + lastNumber.toString() : "o" + lastNumber.toString();
    return Arrays.stream(nums)
        .map(num -> (num % 2 == 0) ? "e" + num.toString() : "o" + num.toString())
        .limit(nums.length - 1)
        .reduce("", (res, element) -> res + element + ",")
        + lns;
  }
}

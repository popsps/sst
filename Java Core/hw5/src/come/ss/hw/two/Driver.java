package come.ss.hw.two;

import java.util.Arrays;

/**
 * Demo
 * get an array of non-negative Integers
 * return an array of only the right-most digits
 */
@FunctionalInterface
interface RightDigit {
  Integer[] apply(Integer[] numbers);
}

public class Driver {
  public static void main(String[] args) {
    // define lambada
    RightDigit rightDigit = numbers -> {
      return Arrays.stream(numbers)
          .map(number -> number % 10).toArray(size -> new Integer[size]);
    };
    // print the result
    // passing hard-coded example. Modify as you wish
    Arrays.stream(rightDigit.apply(new Integer[]{1, 22, 93, 4234, 0, 432}))
        .forEach(number -> System.out.print(number + " "));
    System.out.println();
  }
}

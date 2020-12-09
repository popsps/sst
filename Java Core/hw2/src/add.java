import java.util.Arrays;
import java.util.Scanner;

public class Add {
  public static void main(String[] args) {
    System.out.println("Enter space separated Integers to add them together:");
    Scanner stdin = new Scanner(System.in);
    try {
      Integer[] numbers = Arrays.stream(stdin.nextLine().strip().split(" "))
          .map(s -> Integer.parseInt(s)).toArray(size -> new Integer[size]);
      System.out.println("The sum is: " + add(numbers));
    } catch (Exception e) {
      System.out.println("Something went wrong...");
      e.printStackTrace();
    }
  }

  public static Integer add(Integer[] numbers) {
    Integer sum = 0;
    for (Integer num : numbers) {
      sum += num;
    }
    return sum;
  }
}

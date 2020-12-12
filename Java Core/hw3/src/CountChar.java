import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class CountChar {
  public static void main(String[] args) {
    Scanner stdin = new Scanner(System.in);

    try {
      System.out.print("Enter a character:");
      String input = stdin.nextLine();
      char c = input.strip().charAt(0);
      AtomicInteger count = countChar(c);
      System.out.println("The character " + c
          + " has appeared " + count + " times");
    } catch (Exception e) {

    }
  }

  private static AtomicInteger countChar(char c) {
    AtomicInteger count = new AtomicInteger();
    try (BufferedReader bufferedReader =
             new BufferedReader(new FileReader("files/in.txt"))) {
      bufferedReader.lines().forEach(line -> {
        System.out.println(line);
        for (int i = 0; i < line.length(); i++) {
          if (line.charAt(i) == c)
            count.getAndIncrement();
        }
      });
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      return count;
    }
  }
}

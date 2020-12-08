import java.util.Random;
import java.util.Scanner;

// A program that picks a random number in [1,100] and ask 5 questions to guess it.
public class GuessMyNumber {
  public static void main(String[] args) {
    Scanner stdin = new Scanner(System.in);
    Random rand = new Random();
    int num = rand.nextInt(100) + 1;
    System.out.println("The num is: " + num + " (this is for debugging purposes)"); // debugging purposes
    for (int i = 0; i < 5; i++) {
      try {
        System.out.print("Enter an Integer in [1-100]:");
        int guessNum = Integer.parseInt(stdin.nextLine().strip());
        if (guessNum >= num - 10 && guessNum <= num + 10) {
          System.out.println("You successfully guessed the number. The answer was: " + num);
          return;
        }
      } catch (Exception e) {
        System.out.println("Please Enter a valid Integer between 1-100");
      }
    }
    System.out.println("Sorry, you couldn't guess the number " + num + " correctly");
  }
}

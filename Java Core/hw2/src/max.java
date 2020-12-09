import java.util.Arrays;
import java.util.Random;

public class Max {
  public static void main(String[] args) {
    Random random = new Random();
    int[][] arr = new int[5][10];
    System.out.println("Here is the 2D Array:");
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        arr[i][j] = random.nextInt(999);
        System.out.print(arr[i][j] + "\t");
      }
      System.out.println();
    }
    int max = arr[0][0];
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++)
        max = (arr[i][j] > max) ? arr[i][j] : max;
    }
    System.out.println("The max is: " + max);
  }
}

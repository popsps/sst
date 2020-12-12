import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class AppendText {
  public static void main(String[] args) {
    Random rand = new Random();
    try (FileWriter fw = new FileWriter("files/t1.txt", true)) {
      fw.write("Append this random number "
          + rand.nextInt(2343) + "\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

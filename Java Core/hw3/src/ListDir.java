import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ListDir {
  public static void main(String[] args) {
    try {
      var files = Files.list(Paths.get("files"));
      files.forEach(file->System.out.println(file));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

// A program that prints star patterns
public class printPattern {
  public static void main(String[] args) {
    // 1)
    System.out.println("1)");
    String stars = "";
    for (int i = 0; i < 4; i++) {
      stars += "*";
      System.out.println(stars);
    }
    System.out.println("---------");
    // 2)
    System.out.println("2)");
    System.out.println("----------");
    for (int i = 4; i > 0; i--) {
      System.out.println(stars.substring(0, i));
    }

    // 3)
    System.out.println("3)");
    stars = "*";
    String spaces = "     "; // start at 5
    for (int i = 0; i < 4; i++) {
      System.out.println(spaces + stars);
      spaces = spaces.substring(0, spaces.length() - 1);
      stars += "**";
    }
    System.out.println("-----------");
    // 4)
    System.out.println("4)");
    System.out.println("------------");
    for (int i = 0; i < 4; i++) {
      spaces += " ";
      stars = stars.substring(0, stars.length() - 2);
      System.out.println(spaces + stars);
    }
  }
}

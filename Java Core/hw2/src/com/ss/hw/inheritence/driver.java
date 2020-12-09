package com.ss.hw.inheritence;

public class driver {
  public static void main(String[] args) {
    Rectangle rec = new Rectangle(10, 5);
    rec.display();
    Circle circle = new Circle(10);
    circle.display();
    Triangle triangle = new Triangle(5, 5);
    triangle.display();
  }
}

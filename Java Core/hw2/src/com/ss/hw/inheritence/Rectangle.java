package com.ss.hw.inheritence;

public class Rectangle implements Shape {
  private double l, w = 0;

  public Rectangle(double l, double w) {
    this.l = l;
    this.w = w;
  }

  @Override
  public Double calculateArea() {
    return this.l * this.w;
  }

  @Override
  public void display() {
    System.out.println("The Area of this rectangle is: "
        + calculateArea());
  }
}

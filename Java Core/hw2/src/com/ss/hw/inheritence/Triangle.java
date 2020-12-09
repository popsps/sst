package com.ss.hw.inheritence;

public class Triangle implements Shape {
  private double b, h = 0;
  public Triangle(double b, double h){
    this.b = b;
    this.h = h;
  }
  @Override
  public Double calculateArea() {
    return (this.b * this.h) / 2;
  }

  @Override
  public void display() {
    System.out.println("The Area of this triangle is: "
        + calculateArea());
  }
}

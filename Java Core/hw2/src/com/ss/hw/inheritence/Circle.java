package com.ss.hw.inheritence;

public class Circle implements Shape {
  private double r = 0;
  public Circle(double r){
    this.r = r;
  }
  @Override
  public Double calculateArea() {
    return this.r * this.r * Math.PI;
  }

  @Override
  public void display() {
    System.out.println("The Area of this circle is: "
        + calculateArea());
  }
}

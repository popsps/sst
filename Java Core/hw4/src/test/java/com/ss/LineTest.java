package com.ss;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.ss.Line;
import org.junit.jupiter.api.Test;

class LineTest {

  @Test
  void getSlope() {
    Line line = null;
    line = new Line(5, 45, 68, 45);
    assertEquals(0, line.getSlope());

    line = new Line(8, 6, 0, 0);
    assertEquals(0.75, line.getSlope());

    line = new Line(5, 45, 0, 0);
    assertEquals(9.0, line.getSlope(), 0.0001);

    line = new Line(43, 235, 57, 76);
    assertEquals(-11.357142, line.getSlope(), 0.0001);

  }

  @Test
  void getDistance() {
    Line line = new Line(0, 0, 0, 0);
    assertEquals(0, line.getDistance(), "A point length is 0");
    line = new Line(5, 45, 5, 45);
    assertEquals(0, line.getDistance(), "A point length is 0");

    line = new Line(8, 6, 0, 0);
    assertEquals(10, line.getDistance(), "Length does not match");

    line = new Line(5, 45, 0, 0);
    assertEquals(45.2769256, line.getDistance(), 0.0001, "Length does not match");

    line = new Line(43, 235, 57, 76);
    assertEquals(159.61516, line.getDistance(), 0.0001, "Length does not match");

  }

  @Test
  void parallelTo() {
    Line line1, line2 = null;
    line1 = new Line(5, 45, 68, 45);
    line2 = new Line(235, 35, 58, 75);
    assertEquals(false, line1.parallelTo(line2));
    line1 = new Line(5, 45, 68, 45);
    line2 = new Line(5, 45, 68, 45);
    assertEquals(true, line1.parallelTo(line2));
  }
}
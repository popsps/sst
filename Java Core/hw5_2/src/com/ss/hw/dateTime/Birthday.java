package com.ss.hw.dateTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Birthday {
  public static void main(String[] args) {
    LocalDateTime myBrithday =
        LocalDateTime.of(1991, 12, 8, 22, 32, 43, 34);
    System.out.println(myBrithday);
  }
}

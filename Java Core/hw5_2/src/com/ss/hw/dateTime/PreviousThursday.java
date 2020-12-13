package com.ss.hw.dateTime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class PreviousThursday {
  public static void main(String[] args) {
    LocalDate randomDate = LocalDate.of(2020, 12, 2);
    System.out.println(randomDate.with(TemporalAdjusters.previous(DayOfWeek.THURSDAY)));
  }
}

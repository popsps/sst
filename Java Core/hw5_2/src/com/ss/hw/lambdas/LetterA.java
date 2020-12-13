package com.ss.hw.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * filter a list of string and return only words that start with
 * letter "a" and have exactly 3 letters
 */
public class LetterA {
  public static void main(String[] args) {
    List<String> words = Arrays.asList("nicolas ", "Kaydee", "Ati", "Katie",
        "alv", "robin", "all", "ammara", "Blaine");
    words.forEach(word -> System.out.print(word + " "));
    System.out.println();
    filterWordsWithA3(words).forEach(word -> System.out.print(word + " "));

  }

  public static List<String> filterWordsWithA3(List<String> words) {
    return words.stream()
        .filter(word -> word.startsWith("a") && word.length() == 3)
        .collect(Collectors.toList());
  }
}

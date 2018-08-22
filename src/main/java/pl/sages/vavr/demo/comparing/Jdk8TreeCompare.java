package pl.sages.vavr.demo.comparing;

import java.util.TreeSet;

import static java.util.Arrays.asList;

public class Jdk8TreeCompare {

  private static void demo() {
    TreeSet<String> first = new TreeSet<>(asList("Han", "Luke", "Chewie"));

    TreeSet<String> second = first;
    first.addAll(asList("Han", "Luke", "Chewie"));
    second.add("Ezra");

    System.out.println(first.equals(second));
  }

  public static void main(String[] args) {
    Jdk8TreeCompare.demo();
  }
}

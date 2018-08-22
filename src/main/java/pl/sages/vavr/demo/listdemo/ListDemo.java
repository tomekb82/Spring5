package pl.sages.vavr.demo.listdemo;

import io.vavr.collection.List;

public class ListDemo {

  private static void demo() {
    List<String> fighter = List.of("Han", "Luke");

    System.out.println(fighter);

    List<String> more = fighter.prepend("Ben");
    System.out.println(more);
  }

  public static void main(String[] args) {
    ListDemo.demo();
  }
}

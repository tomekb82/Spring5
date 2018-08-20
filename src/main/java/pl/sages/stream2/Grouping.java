package pl.sages.stream2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Group people by nationality
 */
public class Grouping {

  private Grouping() {
  }

  public static Map<String, List<Person>> groupByNationality7(List<Person> people) {
    return new HashMap<>();
  }

  public static Map<String, List<Person>> groupByNationality(List<Person> people) {

    return people.stream()
            .collect(Collectors.groupingBy(Person::getNationality));
  }

}

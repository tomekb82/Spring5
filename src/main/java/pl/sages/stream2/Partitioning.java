package pl.sages.stream2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Partition adults and kids. True = adult
 */
public class Partitioning {

  private Partitioning() {
  }

  public static Map<Boolean, List<Person>> partitionAdults7(List<Person> people) {
    return new HashMap<>();
  }

  public static Map<Boolean, List<Person>> partitionAdults(List<Person> people) {

    //TODO
    return people.stream()
            .collect(Collectors.partitioningBy(p -> p.getAge() >= 18));
  }

}

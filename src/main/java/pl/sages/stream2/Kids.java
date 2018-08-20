package pl.sages.stream2;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Get names of all kids (under age of 18)
 */
public class Kids {

  public static Set<String> getKidNames7(List<Person> people) {
    return new HashSet<>();
  }

  public static Set<String> getKidNames(List<Person> people) {

    return people.stream()
            .filter(e-> e.getAge() < 18)
            .map(Person::getName)
            .collect(Collectors.toSet());
  }

}

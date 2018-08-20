package pl.sages.stream2;

import java.util.Comparator;
import java.util.List;

/**
 * Get oldest person from the collection
 */
public class OldestPerson {

  public static Person getOldestPerson7(List<Person> people) {
    return new Person("", 0);
  }

  public static Person getOldestPerson(List<Person> people) {

   return people.stream()
           .max(Comparator.comparingInt(Person::getAge))
           .orElseThrow(RuntimeException::new);
  }

  public static Person getYoungestPerson(List<Person> people) {

    return people.stream()
            .max(Comparator.comparingInt(Person::getAge).reversed())
            .orElseThrow(RuntimeException::new);
  }

}

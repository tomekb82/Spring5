package pl.sages.stream2;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Join Person names in a way: "Names: Mark, Michael, Arek"
 */
public class Joining {

  private Joining() {
  }

  public static String namesToString7(List<Person> people) {
    return "";
  }

  public static String namesToString(List<Person> people) {

    return people.stream()
            .map(e->e.getName())
            .collect(Collectors.joining(", ","Names: ", "."));

  }

}

package pl.sages.stream2;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Get people statistics: average age, count, maximum age, minimum age and sum og all ages.
 */
public class PeopleStats {

  private PeopleStats() {
  }

  public static Stats getStats7(List<Person> people) {
    return null;
  }

  public static IntSummaryStatistics getStats(List<Person> people) {

    return people.stream().collect(Collectors.summarizingInt(Person::getAge));
  }

}

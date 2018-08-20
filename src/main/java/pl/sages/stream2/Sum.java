package pl.sages.stream2;

import java.util.List;

/**
 * Sum all elements of a collection
 */
public class Sum {

  private Sum() {
  }

  public static int calculate7(List<Integer> numbers) {
    return 0;
  }

  public static int calculate(List<Integer> people) {

    return people.stream()
            .reduce(Integer::sum)
            .orElse(0);
  }

}

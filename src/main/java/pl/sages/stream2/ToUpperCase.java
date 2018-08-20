package pl.sages.stream2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Convert elements of a collection to upper case.
 */
public class ToUpperCase {

  private ToUpperCase() {
  }

  public static List<String> transform7(List<String> collection) {
    return new ArrayList<>();
  }

  public static List<String> transform(List<String> collection) {

    return collection.stream()
            .map(String::toUpperCase)
            .collect(Collectors.toList());
  }

}

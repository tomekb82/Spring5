package pl.sages.stream2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Flatten multidimensional collection
 */
public class FlatCollection {

  private FlatCollection() {
  }

  public static List<String> transform7(List<List<String>> collection) {
    return new ArrayList<>();
  }

  public static List<String> transform(List<List<String>> collection) {

    return collection.stream()
            .flatMap(Collection::stream)
            .collect(Collectors.toList());
  }

}

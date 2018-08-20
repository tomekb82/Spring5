package pl.sages.stream2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Filter collection so that only elements with less then 4 characters are returned.
 */
public class FilterCollection {

  private FilterCollection() {
  }

  public static List<String> transform7(List<String> collection) {

    List<String> result = new ArrayList<>();
    for(String element: collection) {
      if (element.length() < 4) {
        result.add(element);
      }
    }
    return result;
  }

  public static List<String> transform(List<String> collection) {

    return collection.stream()
            .filter(el -> el.length() < 4)
            .collect(Collectors.toList());

  }

}

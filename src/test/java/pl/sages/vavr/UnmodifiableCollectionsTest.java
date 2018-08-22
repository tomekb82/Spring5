package pl.sages.vavr;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class UnmodifiableCollectionsTest {

  @Test(expected = UnsupportedOperationException.class)
  public void unmod_collection() {
    List<String> list = new LinkedList<>(Arrays.asList("foo", "bar", "baz"));
    list.add("quux");
    assertThat(list).hasSize(4);

    List<String> unmodifiableList = Collections.unmodifiableList(list);
    unmodifiableList.add("BUMM");
  }
}

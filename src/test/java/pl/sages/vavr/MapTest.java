package pl.sages.vavr;

import io.vavr.collection.HashMap;
import io.vavr.control.Option;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MapTest {
  @Test
  public void mapsAreImmutable() {
    HashMap<String, String> map = HashMap.of("Foo", "Bar", "Qux", "Baz");
    assertThat(map.get("Foo").get()).isEqualTo("Bar");
  }

  @Test
  public void bimap() {
    Option<String> quxValue = HashMap.of("Foo", "Bar", "Qux", "Baz")
        .bimap(String::toLowerCase, String::toUpperCase)
        .get("qux");

    assertThat(quxValue.isEmpty()).isFalse();
  }

}

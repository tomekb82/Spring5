package pl.sages.vavr;

import io.vavr.collection.List;
import io.vavr.control.Option;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class FlatVsMapTest {

  @Test
  public void null_is_filtered_by_flatmap() {
    List<String> result =
        List.of("Foo", null, "Baz")
            .flatMap(Option::of)
            .take(3);

    assertThat(result).hasSize(2);
    assertThat(result).containsExactly("Foo", "Baz");
  }

}

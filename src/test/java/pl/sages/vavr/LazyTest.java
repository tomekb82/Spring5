package pl.sages.vavr;

import io.vavr.Lazy;
import org.junit.Test;

import static java.util.UUID.randomUUID;
import static org.assertj.core.api.Assertions.assertThat;

public class LazyTest {

  @Test
  public void basic_stuff() {
    Lazy<String> lazyCalc = Lazy.of(() -> randomUUID().toString());

    assertThat(lazyCalc.get()).isEqualTo(lazyCalc.get());
  }

}

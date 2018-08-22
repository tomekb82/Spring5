package pl.sages.vavr;

import io.vavr.control.Try;
import org.junit.Test;

import static io.vavr.Function1.lift;
import static org.assertj.core.api.Assertions.assertThat;

public class LiftTest {

  static String parseIban(String request) throws IllegalArgumentException {
    if (request.length() > 5) {
      return request.toUpperCase();
    }

    throw new IllegalArgumentException(request + " is too short");
  }

  @Test
  public void classic_usage() {
    String iban;
    try {
      iban = parseIban("AL47");
    } catch (IllegalArgumentException ex) {
      iban = "";
    }
    assertThat(iban).isEqualTo("");
  }

  @Test
  public void use_with_try() {
    String iban = Try.of(() -> parseIban("AL47")).getOrElse("");

    assertThat(iban).isEqualTo("");
  }

  @Test
  public void safe_op() {
    String iban =
        lift(LiftTest::parseIban)
            .apply("AL47")
            .getOrElse("");
    assertThat(iban).isEqualTo("");
  }
}

package pl.sages.vavr;

import java.util.Arrays;
import java.util.Optional;

import io.vavr.collection.List;
import io.vavr.control.Option;
import org.junit.Test;

import static io.vavr.API.$;
import static io.vavr.API.Case;
import static io.vavr.API.Match;
import static io.vavr.Patterns.$None;
import static io.vavr.Patterns.$Some;
import static io.vavr.collection.List.empty;
import static io.vavr.collection.List.of;
import static java.util.Collections.emptyList;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toSet;
import static org.assertj.core.api.Assertions.assertThat;

public class OptionTest {
  @Test
  public void sample_usage() {
    Option<String> option = Option.of("foo");

    assertThat(option.getOrElse("other")).isEqualTo("foo");
  }

  @Test
  public void option_pattern_matched() {
    Option<String> option = Option.none();
    // @formatter:off
    String result = Match(option).of(
        Case($Some($()), identity()),
        Case($None(), "nix")
    );
    // @formatter:on
    assertThat(result).isEqualTo("nix");
  }

  @Test
  public void cascading_if_nulls() {
    pl.sages.vavr.plain.UserRepository repo = new pl.sages.vavr.plain.UserRepository();

    pl.sages.vavr.plain.User user = repo.findOne("id");
    String street = "";
    if (user != null) {
      Address address = user.getAddress();
      if (null != address) {
        street = address.getStreet();
      }
    }
    assertThat(street).as("Street should have been initialized").isNotNull();
  }

  @Test
  public void use_optional_is_present() {
    pl.sages.vavr.plain.UserRepository repo = new pl.sages.vavr.plain.UserRepository();

    pl.sages.vavr.plain.User user = repo.findOne("id");
    Optional<pl.sages.vavr.plain.User> optional = Optional.ofNullable(user);
    if (optional.isPresent()) {

    }

    String street = "";
    if (user != null) {
      Address address = user.getAddress();
      if (null != address) {
        street = address.getStreet();
      }
    }
    assertThat(street).as("Street should have been initialized").isNotNull();
  }

  @Test
  public void fixing_things_with_option() {
    UserRepository repo = new UserRepository();
    String street = repo.findOne("id").flatMap(User::getAddress).map(Address::getStreet).getOrElse("");
    assertThat(street).as("Street should have been initialized").isNotNull();
  }

  @Test
  public void old_school_list() {
    java.util.List<String> roles = Arrays.asList("Foo", "Bar", "Baz");

    //noinspection ConstantConditions
    if (roles == null) {
      roles = emptyList();
    }

    java.util.Set<String> result = roles.stream().map(String::toUpperCase).collect(toSet());
    assertThat(result).contains("FOO", "BAR", "BAZ");
  }

  @Test
  public void fix_old_school_list() {
    List<String> roles = of("Foo", "Bar", "Baz");

    List<String> result =
        Option
            .of(roles)                  // Option<List<String>>
            .getOrElse(empty())         // List<String>
            .map(String::toUpperCase);  // List<String>

    assertThat(result).contains("FOO", "BAR", "BAZ");
  }
}





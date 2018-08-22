package pl.sages.vavr;

import io.vavr.control.Option;

public class UserRepository {

  public Option<User> findOne(String id) {
    // irrelevant
    return Option.none();
  }
}

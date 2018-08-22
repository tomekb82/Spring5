package pl.sages.vavr.demo.demo1.vavr;

import io.vavr.collection.List;
import io.vavr.control.Try;
import pl.sages.vavr.User;

public class Demo1Refactored {

  public List<User> filterValidUsers(List<User> users) {
    return
        users
            .filter(user -> Try.of(user::validate)
                .getOrElse(false)
            ).toList();
  }
}

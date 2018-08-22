package pl.sages.vavr.demo.demo1.java8;

import java.util.List;
import java.util.stream.Collectors;

import pl.sages.vavr.User;

public class Demo1 {

  public List<User> filterValidUsers(List<User> users) {
    return
        users.stream()
            .filter(user -> {
              try {
                return user.validate();
              } catch (Exception ex) {
                return false;
              }
            })
            .collect(Collectors.toList());
  }
}

package pl.sages.vavr.demo.collection;

import io.vavr.collection.List;
import pl.sages.vavr.User;
import pl.sages.vavr.demo.collection.jdk8.UserRepo;

/**
 * Going from Vavr to Java and back again
 */
public class Interop {

  public List<User> findUserByName() {
    return List.ofAll(
        new UserRepo().findAllUsers() // java8 list
    );
  }

}

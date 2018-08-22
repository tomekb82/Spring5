package pl.sages.vavr.demo.demo2.vavr;

import io.vavr.control.Option;
import pl.sages.vavr.Address;
import pl.sages.vavr.User;
import pl.sages.vavr.UserRepository;

public class CodeOfShameRefactored {

  private static Option<String> fetchStreetForUser(String id) {
    UserRepository repo = new UserRepository();
    return repo.findOne(id)
        .flatMap(User::getAddress)
        .map(Address::getStreet);
  }
}

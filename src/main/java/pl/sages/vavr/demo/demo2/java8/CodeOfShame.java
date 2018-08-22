package pl.sages.vavr.demo.demo2.java8;

import pl.sages.vavr.Address;
import pl.sages.vavr.plain.User;
import pl.sages.vavr.plain.UserRepository;

public class CodeOfShame {

  private static String fetchStreetForUser(String id) {
    UserRepository repo = new UserRepository();
    User user = repo.findOne(id);
    if (user != null) {
      Address address = user.getAddress();
      if (null != address) {
        return address.getStreet();
      }
    }
    return null;
  }
}

package pl.sages.persistance;

import pl.sages.persistance.model.User;

public interface UserDao extends AbstractDao<User> {

  User findByEmail(String email);

}

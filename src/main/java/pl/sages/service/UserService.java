package pl.sages.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sages.persistance.UserDao;
import pl.sages.persistance.model.User;

/**
 * Created by acacko on 22.08.18
 */
@Service
public class UserService {

  private UserDao userDao;

  @Autowired
  public UserService(UserDao userDao) {
    this.userDao = userDao;
  }

  public User findUser(String email) {
    return userDao.findByEmail(email);
  }

  public List<User> findAll() {
    return userDao.findAll();
  }


}

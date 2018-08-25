package pl.sages.service;

import java.beans.Transient;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sages.persistance.UserDao;
import pl.sages.persistance.model.User;

/**
 * Created by acacko on 22.08.18
 */
@Service
@Transactional
public class UserService {

  private UserDao userDao;

  @Autowired
  public UserService(UserDao userDao) {
    this.userDao = userDao;
  }

  public User findUser(String email) {
    return userDao.findByEmail(email);
  }

  public User findById(Long id) {
    return userDao.findById(id);
  }

  public void createUser(User user) {
    userDao.save(user);
  }

  public List<User> findAll() {
    return userDao.findAll();
  }


}

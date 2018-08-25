package pl.sages.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sages.springboot.dao.User;
import pl.sages.springboot.dao.UserDao;

@RestController
@RequestMapping(value = "/")
public class ExampleRestController {

  @Autowired
  UserConfig userConfig;

  @Autowired
  UserDao userDao;

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public UserConfig get() {
    UserConfig userConfig = new UserConfig();
    userConfig.setName("Aaa");
    userConfig.setSurname("AASD");

    return userConfig;
  }

  @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<User> getAllUsers() {
    return userDao.findAll();
  }
}

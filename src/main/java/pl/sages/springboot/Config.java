package pl.sages.springboot;

import java.time.LocalDateTime;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.sages.springboot.dao.User;
import pl.sages.springboot.dao.UserDao;

@Component
public class Config {

  @Value("${config.name}")
  String name;

  @Autowired
  UserConfig userConfig;

  @Autowired
  UserDao userDao;

  @PostConstruct
  public void init() {
    System.out.println(name);
  }

  @Scheduled(fixedDelay = 10000)
  public void sayHallo() {
    System.out.println("aaaaaa" + LocalDateTime.now());
    userDao.save(new User("Arek", LocalDateTime.now().toString()));
  }



}

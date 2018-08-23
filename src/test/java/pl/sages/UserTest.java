package pl.sages;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import pl.sages.persistance.impl.springdata.UserDao;
import pl.sages.persistance.model.User;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = App.class)
@ActiveProfiles("data")
@Transactional
public class UserTest {

  @Autowired
  UserDao userDao;

  @Test
  public void findByIdTest(){
    assertThat(userDao.findById(1L)).isNotNull();
    assertThat(userDao.findById(1L).get().getEmail()).isEqualTo("any");
  }

  @Test
  public void findByPasswordTest2(){
    assertThat(userDao.findByPassword("aaa").count()).isEqualTo(2);
//    assertThat(userDao.findById(1L).get().getEmail()).isEqualTo("any");
  }

  @Test
  public void saveTest(){
    User user = new User();
    user.setEmail("aaaa2");

    assertThat(user.getId()).isNull();
    userDao.save(user);

    User userFromDB = userDao.findByEmail("aaaa2");
    assertThat(userFromDB).isNotNull();
    assertThat(userFromDB.getId()).isNotNull();
    assertThat(user.getId()).isNotNull();
  }

  @Test
  public void removeTest(){
    User user = new User();
    user.setEmail("aaaa");
    userDao.save(user);
    assertThat(userDao.findByEmail("aaaa")).isNotNull();
    userDao.delete(user);
    assertThat(userDao.findByEmail("aaaa")).isNull();
  }
}

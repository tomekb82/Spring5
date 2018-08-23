package pl.sages;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.sages.persistance.UserDao;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = App.class)
public class UserTest {

  @Autowired
  UserDao userDao;

  @Test
  public void findByIdTest(){
    assertThat(userDao.findById(1L)).isNotNull();
    assertThat(userDao.findById(1L).getEmail()).isEqualTo("any");
  }
}

package pl.sages;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.sages.persistance.UserDao;
import pl.sages.persistance.model.User;
import pl.sages.service.UserService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = App.class)
@ActiveProfiles("hibernate")
public class UserServiceTest {

  @Autowired
  @InjectMocks
  private UserService userService;

  @Mock
  private UserDao userDao;

  @Before
  public void before(){
    MockitoAnnotations.initMocks(this);

    User user = new User();
    user.setEmail("cos");
    when(userDao.findByEmail("cos")).thenReturn(user);
  }

  @Test
  public void serviceTest() {
    assertThat(userService.findUser("cos")).isNotNull();
  }

}

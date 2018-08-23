package pl.sages;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.sages.persistance.CinemaDao;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = App.class)
@ActiveProfiles("hibernate")
public class CinemaTest {

  @Autowired
  CinemaDao cinemaDao;

  @Test
  public void findByIdTest(){
    assertThat(cinemaDao.findById(1L)).isNotNull();
  }

  @Test
  public void findByNameTest(){
    assertThat(cinemaDao.findByName("cinema 1")).isNotNull();
  }

  @Test
  public void findAllTest(){
    assertThat(cinemaDao.findAll()).isNotNull();
  }
}

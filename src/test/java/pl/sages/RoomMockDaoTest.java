package pl.sages;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.sages.persistance.RoomDao;
import pl.sages.persistance.impl.jdbc.CinemaDaoImpl;
import pl.sages.persistance.model.Cinema;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.runners.Parameterized.Parameters;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = App.class)
@ActiveProfiles("hibernate")
public class RoomMockDaoTest {

//  @Parameters
//  public static Collection<Object[]> data() {
//           /*create and return a Collection
//             of Objects arrays here.
//             Each element in each array is
//             a parameter to your constructor.
//            */
//
//  }

  @Autowired
  @InjectMocks
  private RoomDao roomDao;

  @Mock
  private CinemaDaoImpl cinemaDao;

  @Before
  public void before(){
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void findByIdTest(){
    Cinema cinema = new Cinema();
    cinema.setId(1L);
    cinema.setName("aaa");
//    when(cinemaDao.findById(anyLong())).thenReturn(cinema);
    when(cinemaDao.findById(any(Long.class))).thenReturn(cinema);

    assertThat(roomDao.findById(1L)).isNotNull();
    //verify(cinemaDao, times(1)).findById(1L); // JDBC only
  }

  @Test
  public void findByNumberTest(){
    assertThat(roomDao.findByNumber(1)).isNotNull();
    verify(cinemaDao, times(0)).findById(1L);
  }

  @Test
  public void findByNumberTest2(){
    assertThat(roomDao.findByNumber(1)).isNotNull();
    verify(cinemaDao, times(0)).findById(1L);
  }
}

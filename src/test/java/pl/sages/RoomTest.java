package pl.sages;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import pl.sages.persistance.CinemaDao;
import pl.sages.persistance.RoomDao;
import pl.sages.persistance.model.Cinema;
import pl.sages.persistance.model.Room;
import pl.sages.service.RoomService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.from;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = App.class)
@ActiveProfiles("jpa")
@Transactional
public class RoomTest {

  @Autowired
  RoomDao roomDao;

  @Autowired
  CinemaDao cinemaDao;

  @Mock
  RoomDao mockRoomDao;

  @Autowired
  @InjectMocks
  private RoomService roomService;

  @Before
  public void before(){
    MockitoAnnotations.initMocks(this);

    Room room = new Room();
    room.setNumber(2);
    room.setCapacity(3);
    when(mockRoomDao.findByNumber(2)).thenReturn(room);
  }

  @DisplayName("Should calculate the correct sum")
  @ParameterizedTest(name = "{index} => a={0}, b={1}, sum={2}")
  @CsvSource({
          "1, 1, 2",
          "2, 3, 5"
  })
  void sum(int a, int b, int sum) {
    assertEquals(sum, a + b);
  }

  @Test
  public void testMock(){
    assertThat(roomService.findNumber(2)).isNotNull();
    assertThat(roomService.findNumber(2).getCapacity()).isEqualTo(3);
  }

  @Test
  public void findByIdTest(){
    assertThat(roomDao.findById(1L)).isNotNull();
    assertThat(roomDao.findById(1L).getNumber()).isEqualTo(1);
  }

  @Test
  public void findByNumberTest(){
    assertThat(roomDao.findByNumber(2)).isNotNull();
    assertThat(roomDao.findByNumber(2).getCapacity()).isEqualTo(4);
    assertThat(roomDao.findByNumber(2).getCinema().getName()).isEqualTo("cinema 1");
  }

  @Test
  public void findByNumberAndCapacityTest(){
      assertThat(roomDao.findByNumberAndCapacity(2, 4)).isNotNull();
      assertThat(roomDao.findByNumberAndCapacity(2, 4).getCapacity()).isEqualTo(4);
      assertThat(roomDao.findByNumberAndCapacity(2,4).getCinema().getName()).isEqualTo("cinema 1");
  }

    @Test
    public void findByNumberProjectionTest(){
        assertThat(roomDao.findByNumberProjection(2)).isNotNull();
        assertThat(roomDao.findByNumberProjection(2).getCapacity()).isEqualTo(4);
        assertThat(roomDao.findByNumberProjection(2).getNumber()).isEqualTo(2);
        assertThat(roomDao.findByNumberProjection(2).getCinameName()).isEqualTo("cinema 1");
    }

  @Test
  public void findByNumberTestOptional(){
      assertThat(roomDao.findByNumberOptional(2)).isNotNull();
      assertThat(roomDao.findByNumberOptional(2).get().getCapacity()).isEqualTo(4);
      assertThat(roomDao.findByNumberOptional(2).get().getCinema().getName()).isEqualTo("cinema 1");
  }

  @Test
  public void findByNumberTestNamedQuery(){
      assertThat(roomDao.findByIdNamedQuery(1L)).isNotNull();
      assertThat(roomDao.findByIdNamedQuery(1L).get().getCapacity()).isEqualTo(2);
      assertThat(roomDao.findByIdNamedQuery(1L).get().getCinema().getName()).isEqualTo("cinema 1");
  }

  @Test
  public void findAllTest(){
    assertThat(roomDao.findAll()).isNotNull();
    assertThat(roomDao.findAll().size()==2);
  }

    @Test
    public void saveTest(){
        Room room = new Room();
        room.setNumber(3);
        room.setCapacity(3);

        assertThat(room.getId()).isNull();
        roomDao.save(room);

        Room roomFromDB = roomDao.findByNumber(3);
        assertThat(roomFromDB).isNotNull();
        assertThat(roomFromDB.getId()).isNotNull();
        assertThat(room.getId()).isNotNull();
    }

    @Test
    public void removeTest(){
        Room room = new Room();
        room.setNumber(3);
        room.setCapacity(3);
        Cinema cinema = new Cinema();
        cinema.setName("test");
        room.setCinema(cinema);
        roomDao.save(room);
        assertThat(roomDao.findByNumber(3)).isNotNull();

        roomDao.remove(room);
        assertThat(roomDao.findByNumber(3)).isNull();

        Cinema cinameRead = cinemaDao.findByName("test");
        assertThat(cinameRead).isNull();


    }
}

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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.sages.persistance.RoomDao;
import pl.sages.persistance.model.Room;
import pl.sages.service.RoomService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = App.class)
public class RoomTest {

  @Autowired
  RoomDao roomDao;

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
  }
  
  @Test
  public void findAllTest(){
    assertThat(roomDao.findAll()).isNotNull();
    assertThat(roomDao.findAll().size()==2);
  }
}

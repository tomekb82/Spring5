package pl.sages.rest;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;
import pl.sages.persistance.model.Room;

import java.net.URI;
import java.net.URISyntaxException;

// zakładamy, że w trakcie testu będzie uruchomiony serwer
// @Ignore
public class RoomRestTest {

  private static final String SERVER_URL = "http://localhost:8085";
  private static final String ROOM_URL = "/api/room";
  private static final String ROOMS_URL = "/api/rooms";

  private RestTemplate restTemplate = new RestTemplate();

  @Test
  public void gerRoomTest() {
    Room room = restTemplate.getForObject(SERVER_URL + ROOM_URL + "/1", Room.class);
    System.out.println(room);
  }

  @Test
  public void getRoomsTest() {
    Room[] rooms = restTemplate.getForObject(SERVER_URL + ROOMS_URL, Room[].class);
    Assertions.assertThat(rooms).isNotEmpty();
  }

  @Test
  public void addRoomTest() throws URISyntaxException {
    Room[] rooms = restTemplate.getForObject(SERVER_URL + ROOMS_URL, Room[].class);
    long before = rooms.length;

    Room room = new Room();
    room.setNumber(5);
    room.setCapacity(6);
    restTemplate.postForObject(new URI(SERVER_URL + ROOM_URL), room, Room.class);

    rooms = restTemplate.getForObject(SERVER_URL + ROOMS_URL, Room[].class);
    long after = rooms.length;

    Assertions.assertThat(before).isLessThan(after);
  }

}

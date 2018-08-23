package pl.sages.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sages.persistance.RoomDao;
import pl.sages.persistance.model.Room;

import java.util.List;

/**
 * Created by acacko on 22.08.18
 */
@Service
public class RoomService {

  private RoomDao roomDao;

  @Autowired
  public RoomService(RoomDao roomDao) {
    this.roomDao = roomDao;
  }

  public Room findNumber(Integer number) {
    return roomDao.findByNumber(number);
  }

  public Room findById(Long id) {
    return roomDao.findById(id);
  }

  public List<Room> findAll() {
    return roomDao.findAll();
  }


}

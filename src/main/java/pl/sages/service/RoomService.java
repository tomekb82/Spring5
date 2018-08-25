package pl.sages.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sages.persistance.RoomDao;
import pl.sages.persistance.model.Room;

/**
 * Created by acacko on 22.08.18
 */
@Service
public class RoomService extends AbstractService<RoomDao, Room>{

  public Room findNumber(Integer number) {
    return getDao().findByNumber(number);
  }

  public void addRoom(Room room) {
    getDao().save(room);
  }

  @Transactional
  public void removeRoom(Long id) {
    Room room = this.findById(id);
    if (room!=null) {
      this.remove(room);
    }
  }

}

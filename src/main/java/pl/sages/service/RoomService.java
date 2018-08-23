package pl.sages.service;

import org.springframework.stereotype.Service;
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

}

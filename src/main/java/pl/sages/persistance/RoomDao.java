package pl.sages.persistance;

import pl.sages.persistance.model.Room;

public interface RoomDao extends AbstractDao<Room>{

    public Room findByNumber(Integer number);
}

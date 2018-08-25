package pl.sages.persistance;

import pl.sages.persistance.model.Room;
import pl.sages.persistance.model.RoomDto;

import java.util.Optional;

public interface RoomDao extends AbstractDao<Room>{

    public Room findByNumber(Integer number);

    public Optional<Room> findByNumberOptional(Integer number);

    public Optional<Room> findByIdNamedQuery(Long number);

    public Room findByNumberAndCapacity(Integer number, Integer capacity);

    public RoomDto findByNumberProjection(Integer number);

}

package pl.sages.persistance.impl.springdata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sages.persistance.model.Room;

import java.util.stream.Stream;

// Spring Data Dao
@Repository
public interface RoomDao extends JpaRepository<Room, Long> {

    Room findByNumber(Integer number);

    Stream<Room> findAllByCinema_Name(String name);

}

// Traditional Dao
/*public interface RoomDao extends AbstractDao<Room> {

    public Room findByNumber(Integer number);

    public Optional<Room> findByNumberOptional(Integer number);

    public Optional<Room> findByIdNamedQuery(Long number);

    public Room findByNumberAndCapacity(Integer number, Integer capacity);

    public RoomDto findByNumberProjection(Integer number);

}*/
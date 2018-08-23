package pl.sages.persistance.impl.hibernate;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.sages.persistance.RoomDao;
import pl.sages.persistance.model.Room;
import pl.sages.persistance.model.RoomDto;

import java.util.Optional;

@Repository
@Transactional
public class RoomDaoImpl extends AbstractHibernateDaoImpl<Room> implements RoomDao {

  /*private CinemaDao cinemaDao;

  @Autowired
  public RoomDaoImpl(CinemaDao cinemaDao) {
      super(Room.class);
      this.cinemaDao = cinemaDao;
  }*/

  public RoomDaoImpl() {
      super(Room.class);
  }

  @Override
  public Room findByNumber(Integer number) {
      return getCurrentSession().createQuery("from " + Room.class.getSimpleName() + " where number = :number", Room.class)
              .setParameter("number", number)
              .uniqueResult();
  }

    @Override
    public Optional<Room> findByNumberOptional(Integer number) {
        return Optional.empty();
    }

    @Override
    public Optional<Room> findByIdNamedQuery(Long number) {
        return Optional.empty();
    }

    @Override
    public Room findByNumberAndCapacity(Integer number, Integer capacity) {
        return null;
    }

    @Override
    public RoomDto findByNumberProjection(Integer number) {
        return null;
    }

}




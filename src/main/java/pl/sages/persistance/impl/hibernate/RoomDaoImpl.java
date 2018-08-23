package pl.sages.persistance.impl.hibernate;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.sages.persistance.RoomDao;
import pl.sages.persistance.model.Room;

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

}




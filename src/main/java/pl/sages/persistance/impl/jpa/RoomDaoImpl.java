package pl.sages.persistance.impl.jpa;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.sql.JPASQLQuery;
import com.querydsl.sql.HSQLDBTemplates;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.sages.persistance.RoomDao;
import pl.sages.persistance.model.*;

import java.util.Optional;

import static pl.sages.persistance.model.QMovie.movie;
import static pl.sages.persistance.model.QRoom.room;

@Repository
@Transactional
public class RoomDaoImpl extends AbstractJpaDaoImpl<Room> implements RoomDao {

  public RoomDaoImpl() {
      super(Room.class);
  }

  @Override
  public Room findByNumber(Integer number) {
      return entityManager.createQuery("from " + Room.class.getSimpleName() + " where number = :number", Room.class)
          .setParameter("number", number)
          .getResultList().stream()
          .findFirst().orElse(null);
  }

  @Override
  public Room findByNumberAndCapacity(Integer number, Integer capacity) {
      return new JPAQueryFactory(entityManager)
              .selectFrom(room)
              .where(room.number.eq(number)
                      .and(room.capacity.eq(capacity)))
              .fetchOne();
  }

  @Override
  public RoomDto findByNumberProjection(Integer number) {
      return new JPASQLQuery<MovieDto>(entityManager, new HSQLDBTemplates())
              .select(new QRoomDto(room.number, room.capacity))
              .from(room)
              .where(room.number.eq(number))
              .fetchOne();
  }

  @Override
  public Optional<Room> findByNumberOptional(Integer number) {
      return entityManager.createQuery("from " + Room.class.getSimpleName() + " where number = :number", Room.class)
              .setParameter("number", number)
              .getResultList().stream()
              .findFirst();
  }

  @Override
  public Optional<Room> findByIdNamedQuery(Long id) {
      return entityManager.createNamedQuery("room.byId", Room.class)
              .setParameter("id", id)
              .getResultList().stream()
              .findFirst();
    }

}




package pl.sages.persistance.impl.jpa;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.sages.persistance.ReservationDao;
import pl.sages.persistance.model.Reservation;

/**
 * Created by jzamojski on 2018-08-22.
 */
@Repository
@Transactional
public class ReservationDaoImpl extends AbstractJpaDaoImpl<Reservation> implements ReservationDao{

  public ReservationDaoImpl() {
    super(Reservation.class);
  }

  @Override
  public List<Reservation> findAll() {
    return entityManager.createQuery("from " + Reservation.class.getSimpleName(), Reservation.class)
            .getResultList();
  }

  @Override
  public Reservation findById(Long id) {
    return entityManager.createQuery("from " + Reservation.class.getSimpleName() + " where id = :id", Reservation.class)
            .setParameter("id", id)
            .getSingleResult();
  }

}

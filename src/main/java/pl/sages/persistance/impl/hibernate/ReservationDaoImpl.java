package pl.sages.persistance.impl.hibernate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.sages.persistance.ReservationDao;
import pl.sages.persistance.model.Reservation;
import pl.sages.persistance.model.User;

/**
 * Created by jzamojski on 2018-08-22.
 */
@Repository
@Transactional
public class ReservationDaoImpl extends AbstractHibernateDaoImpl<Reservation> implements ReservationDao{

  public ReservationDaoImpl() {
    super(Reservation.class);
  }

  @Override
  public List<Reservation> findAll() {
    return getCurrentSession().createQuery("from " + Reservation.class.getSimpleName(), Reservation.class)
            .getResultList();
  }

  @Override
  public Reservation findById(Long id) {
    return getCurrentSession().createQuery("from " + Reservation.class.getSimpleName() + " where id = :id", Reservation.class)
            .setParameter("id", id)
            .getSingleResult();
  }

}

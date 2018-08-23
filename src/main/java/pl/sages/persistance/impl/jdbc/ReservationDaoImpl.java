package pl.sages.persistance.impl.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;
import pl.sages.persistance.ReservationDao;
import pl.sages.persistance.model.Cinema;
import pl.sages.persistance.model.Reservation;
import pl.sages.persistance.model.User;

/**
 * Created by jzamojski on 2018-08-22.
 */
@Component
public class ReservationDaoImpl extends AbstractJdbcDaoImpl<Reservation> implements ReservationDao{

  private final String findAll = "select * from RESERVATION";
  private final String findById = "select * from RESERVATION where id= :id";

  private final RowMapper<Reservation> reservationRowMapper = (rs, i) -> convertToReservation(rs);

  private Reservation convertToReservation(ResultSet rs) throws SQLException {
    Reservation reservation = new Reservation();
    reservation.setId(rs.getLong("id"));
    return reservation;
  }

  @Override
  public Reservation findById(Long id) {
    return jdbcTemplate.queryForObject(findById,
            new MapSqlParameterSource("id", id),
            reservationRowMapper
    );
  }


  @Override
  public List<Reservation> findAll() {
    return jdbcTemplate.query(findAll, reservationRowMapper);
  }
}

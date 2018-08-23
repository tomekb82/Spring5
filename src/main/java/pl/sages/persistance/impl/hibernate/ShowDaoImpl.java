package pl.sages.persistance.impl.hibernate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.sages.persistance.MovieDao;
import pl.sages.persistance.RoomDao;
import pl.sages.persistance.ShowDao;
import pl.sages.persistance.model.Show;
//
@Repository
@Transactional
public class ShowDaoImpl extends AbstractHibernateDaoImpl<Show> implements ShowDao {
  //private final String findByDate = "select * from SHOW where date = :date";
  //private final String findById = "select * from SHOW where id = :id";

  public ShowDaoImpl() {
    super(Show.class);
  }

  @Override
  public Show findByDate(LocalDate date) {
    Show show =  getCurrentSession().createQuery("from " + Show.class.getSimpleName() + " where date = :date", Show.class)
            .setParameter("date", date)
            .getSingleResult();

    return show;
  }

}

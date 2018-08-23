package pl.sages.persistance.impl.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;
import pl.sages.persistance.MovieDao;
import pl.sages.persistance.RoomDao;
import pl.sages.persistance.ShowDao;
import pl.sages.persistance.model.Show;

@Component
@Profile("jdbc")
public class ShowDaoImpl extends AbstractJdbcDaoImpl<Show> implements ShowDao {
  private final String findByDate = "select * from SHOW where date = :date";
  private final String findById = "select * from SHOW where id = :id";

  private final RowMapper<Show> showRowMapper = (rs, i) -> convertToShow(rs);

    private MovieDao movieDao;
    private RoomDao roomDao;

    @Autowired
    public ShowDaoImpl(MovieDao movieDao, RoomDao roomDao) {
        this.movieDao = movieDao;
        this.roomDao = roomDao;
    }

    @Override
  public List<Show> findAll() {
    return null;
  }

  @Override
  public Show findByDate(LocalDate date) {
    return jdbcTemplate.queryForObject(findByDate,
            new MapSqlParameterSource("date", date),
            showRowMapper);
  }
    @Override
    public Show findById(Long id) {
        return jdbcTemplate.queryForObject(findById,
                new MapSqlParameterSource("id", id),
                showRowMapper);
    }
  private Show convertToShow(ResultSet rs) throws SQLException {
    Show show = new Show();
    show.setId(rs.getLong("id"));
    show.setDate(rs.getDate("date").toLocalDate());
    show.setDate(rs.getDate("date").toLocalDate());
    show.setMovie(movieDao.findById(rs.getLong("movie_id")));  //<-- pomysł na rozwiazanie zależności obiektowych z innych tabel
    show.setRoom(roomDao.findById( rs.getLong("room_id")));  //<-- pomysł na rozwiazanie zależności obiektowych z innych tabel

    return show;
  }

}

package pl.sages.persistance.impl.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;
import pl.sages.persistance.CinemaDao;
import pl.sages.persistance.model.Cinema;

@Component
@Profile("jdbc")
public class CinemaDaoImpl extends AbstractJdbcDaoImpl<Cinema> implements CinemaDao {

  private final String findById = "select * from cinema where id = :id";
  private final String findByName = "select * from cinema where name = :name";
  private final String findAll = "select * from cinema";

  private final RowMapper<Cinema> cinemaRowMapper = (rs, i) -> convertToCinema(rs);

  @Override
  public Cinema findByName(String name) {
    return jdbcTemplate.queryForObject(findByName,
            new MapSqlParameterSource("name", name),
            cinemaRowMapper
    );
  }

  private Cinema convertToCinema(ResultSet rs) throws SQLException {
    Cinema cinema = new Cinema();
    cinema.setId(rs.getLong("id"));
    cinema.setName(rs.getString("name"));
    return cinema;
  }

  @Override
  public Cinema findById(Long id) {
    return jdbcTemplate.queryForObject(
            findById,
            new MapSqlParameterSource("id", id),
            cinemaRowMapper
    );
  }

  @Override
  public List<Cinema> findAll() {
    return jdbcTemplate.query(findAll, cinemaRowMapper);
  }
}

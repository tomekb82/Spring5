package pl.sages.persistance.impl.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;
import pl.sages.persistance.CinemaDao;
import pl.sages.persistance.RoomDao;
import pl.sages.persistance.model.Cinema;
import pl.sages.persistance.model.Room;

@Component
@Profile("jdbc")
public class RoomDaoImpl extends AbstractJdbcDaoImpl<Room> implements RoomDao {

  private final String findByNumber = "select ROOM.*, CINEMA.ID as cinemaId, CINEMA.NAME as cinemaName from ROOM INNER JOIN CINEMA ON ROOM.cinema_id=CINEMA.id where number = :number";
  private final String findById = "select * from ROOM where id = :id";
  private final String findAll = "select * from ROOM";

  private final RowMapper<Room> roomRowMapperWithJoin = (rs, i) -> convert(rs, true);
  private final RowMapper<Room> roomRowMapper = (rs, i) -> convert(rs, false);

  private CinemaDao cinemaDao;

  @Autowired
  public RoomDaoImpl(CinemaDao cinemaDao) {
    this.cinemaDao = cinemaDao;
  }

  @Override
  public Room findByNumber(Integer number) {
    return jdbcTemplate.queryForObject(findByNumber,
            new MapSqlParameterSource("number", number),
            roomRowMapperWithJoin);
  }

  @Override
  public Room findById(Long id) {
    return jdbcTemplate.queryForObject(findById,
            new MapSqlParameterSource("id", id),
            roomRowMapper);
  }

  private Room convert(ResultSet rs, boolean withJoin) throws SQLException {
    Room room = new Room();
    room.setId(rs.getLong("id"));
    room.setNumber(rs.getInt("number"));
    room.setCapacity(rs.getInt("capacity"));

    if(withJoin) {
      Cinema cinema = new Cinema();
      cinema.setId(rs.getLong("cinemaId"));
      cinema.setName(rs.getString("cinemaName"));
      //room.setCinema(cinema);
    } else {
      //room.setCinema(cinemaDao.findById(rs.getLong("cinema_id")));
    }

    return room;
  }

  @Override
  public List<Room> findAll() {
    return jdbcTemplate.query(findAll, roomRowMapper);
  }
}

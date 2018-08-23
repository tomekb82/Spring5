package pl.sages.persistance.impl.jdbc;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;
import pl.sages.persistance.UserDao;
import pl.sages.persistance.model.User;

/**
 * Created by acacko on 22.08.18
 */
@Component
public class UserDaoImpl extends AbstractJdbcDaoImpl<User> implements UserDao {

  private final String findByEmail = "select * from USER where email = :email";
  private final String findById = "select * from USER where id = :id";
  private final String findAll = "select * from USER";

  private final RowMapper<User> userRowMapper = (rs, i) -> convertToUser(rs);


  @Override
  public User findByEmail(String email) {
    return jdbcTemplate.queryForObject(findByEmail,
        new MapSqlParameterSource("email", email),
        userRowMapper);
  }


  private User convertToUser(ResultSet rs) throws SQLException {
    User user = new User();
    user.setId(rs.getLong("id"));
    user.setEmail(rs.getString("email"));
    user.setPassword(rs.getString("password"));
    return user;
  }

  @Override
  public User findById(Long id) {
    return jdbcTemplate.queryForObject(findById,
        new MapSqlParameterSource("id", id),
        userRowMapper);
  }

  @Override
  public List<User> findAll() {
    return jdbcTemplate.query(findAll, userRowMapper);
  }
}

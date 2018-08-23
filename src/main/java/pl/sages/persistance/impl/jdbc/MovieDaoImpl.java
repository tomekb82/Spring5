package pl.sages.persistance.impl.jdbc;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;
import pl.sages.persistance.MovieDao;
import pl.sages.persistance.model.Movie;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class MovieDaoImpl extends AbstractJdbcDaoImpl<Movie> implements MovieDao {

    private final String findById = "select * from MOVIE where id = :id";
    private final String findByTitle = "select * from MOVIE where title = :title";
    private final String findAll = "select * from MOVIE";

    private final RowMapper<Movie> movieRowMapper = (rs, i) -> convertToMovie(rs);


    @Override
    public Movie findByTitle(String title) {
        return jdbcTemplate.queryForObject(findByTitle,
                new MapSqlParameterSource("title", title),
                movieRowMapper);
    }

    @Override
    public Movie findById(Long id) {
        return jdbcTemplate.queryForObject(findById,
                new MapSqlParameterSource("id", id),
                movieRowMapper);
    }

    private Movie convertToMovie(ResultSet rs) throws SQLException {
        Movie movie = new Movie();
        movie.setId(rs.getLong("id"));
        movie.setTitle(rs.getString("title"));
        movie.setPrice(rs.getBigDecimal("price"));
        return movie;
    }

    @Override
    public List<Movie> findAll() {
        return jdbcTemplate.query(findAll, movieRowMapper);
    }
}

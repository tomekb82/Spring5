package pl.spring.batch;

import org.springframework.jdbc.core.RowMapper;
import pl.spring.model.Album;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AlbumRowMapper implements RowMapper<Album> {

  @Override
  public Album mapRow(ResultSet rs, int rowNum) throws SQLException {
    Album album = new Album();
    album.setId(rs.getLong("id"));
    album.setName(rs.getString("name"));
    //album.setCreated(Calendar.getInstance().getTime());
    return album;
  }
}

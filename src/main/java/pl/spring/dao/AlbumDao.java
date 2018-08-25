package pl.spring.dao;

import pl.spring.model.Album;

public interface AlbumDao extends AbstractDao<Album> {

  Album findByName(String name);

}

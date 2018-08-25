package pl.spring.dao.springdata;

import pl.spring.model.Album;

public interface CustomAlbumDao {

  Album findByName(String name);

  //AlbumDto findByName(String name);
  //List<AlbumDto> findAll();


}

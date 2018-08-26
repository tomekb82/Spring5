package pl.spring.service.springdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.spring.dao.springdata.AlbumDao;
import pl.spring.model.Album;

import java.util.List;
import java.util.Optional;

@Service(value="albumServiceData")
public class AlbumService  {

  private AlbumDao albumDao;

  @Autowired
  public AlbumService(AlbumDao albumDao) {
    this.albumDao = albumDao;
  }

  public Album findByName(String name) {
    return albumDao.findByName(name);
  }

  public Optional<Album> findById(Long id) {
    return albumDao.findById(id);
  }

  public List<Album> findAll() {
    return albumDao.findAll();
  }

  public Album save(Album album) {
    return albumDao.save(album);
  }

  public void deleteById(Long id) {
    albumDao.deleteById(id);
  }

  public void delete(Album album) {
    albumDao.delete(album);
  }

}

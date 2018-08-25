package pl.spring.service;

import org.springframework.stereotype.Service;
import pl.spring.dao.AlbumDao;
import pl.spring.model.Album;

/**
 * Created by acacko on 22.08.18
 */
@Service
public class AlbumService extends AbstractService<AlbumDao, Album> {

  public Album findByName(String name) {
    return getDao().findByName(name);
  }

}

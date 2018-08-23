package pl.sages.service;

import org.springframework.beans.factory.annotation.Autowired;
import pl.sages.persistance.AbstractDao;
import pl.sages.persistance.model.AbstractEntity;

import java.util.List;

/**
 * Created by acacko on 22.08.18
 */
public abstract class AbstractService<T extends AbstractDao<R>, R extends AbstractEntity> {

  private T dao;

  public T getDao() {
    return dao;
  }

  @Autowired
  public void setDao(T dao) {
    this.dao = dao;
  }

  public R findById(Long id) {
    return dao.findById(id);
  }

  public List<R> findAll() {
    return dao.findAll();
  }

  public void remove(R object) {
    dao.remove(object);
  }
  
}

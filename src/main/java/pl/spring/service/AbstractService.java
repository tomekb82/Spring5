package pl.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import pl.spring.dao.AbstractDao;
import pl.spring.model.AbstractEntity;

import java.util.List;

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

  public void persist(R object) {
    dao.persist(object);
  }
  
}

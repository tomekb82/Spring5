package pl.spring.dao.impl;

import org.springframework.transaction.annotation.Transactional;
import pl.spring.dao.AbstractDao;
import pl.spring.model.AbstractEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
public abstract class AbstractJpaDaoImpl<T extends AbstractEntity> implements AbstractDao<T> {

  @PersistenceContext
  protected EntityManager entityManager;

  private final Class<T> clazz;

  protected AbstractJpaDaoImpl(Class<T> clazz) {
    this.clazz = clazz;
  }

  @Override
  public T findById(Long id) {
    return entityManager.find(clazz, id);
  }

  @Override
  public List<T> findAll() {
    return entityManager.createQuery("from " + clazz.getSimpleName(), clazz).getResultList();
  }

  @Override
  public void remove(T entity) {
    entityManager.remove(entity);
  }

  @Override
  public void persist(T entity) {
    entityManager.persist(entity);
  }


}

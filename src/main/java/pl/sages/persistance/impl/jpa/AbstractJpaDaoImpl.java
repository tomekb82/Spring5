package pl.sages.persistance.impl.jpa;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import pl.sages.persistance.AbstractDao;
import pl.sages.persistance.model.AbstractEntity;

/**
 * Created by acacko on 22.08.18
 */
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
  public void save(T entity) {
    entityManager.persist(entity);
  }


}

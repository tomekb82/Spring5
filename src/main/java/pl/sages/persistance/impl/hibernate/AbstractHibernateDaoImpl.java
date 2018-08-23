package pl.sages.persistance.impl.hibernate;

import java.util.List;

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
public abstract class AbstractHibernateDaoImpl<T extends AbstractEntity> implements AbstractDao<T> {

  @Autowired
  private SessionFactory sessionFactory;

  private final Class<T> clazz;

  protected AbstractHibernateDaoImpl(Class<T> clazz) {
    this.clazz = clazz;
  }

  public Session getCurrentSession() {
    return sessionFactory.getCurrentSession();
  }

  @Override
  public T findById(Long id) {
    return getCurrentSession().find(clazz, id);
  }

  @Override
  public List<T> findAll() {
    return getCurrentSession().createQuery("from " + clazz.getSimpleName(), clazz).getResultList();
  }

  @Override
  public void remove(T entity) {
    getCurrentSession().remove(entity);
  }

  @Override
  public void save(T entity) {
    getCurrentSession().persist(entity);
  }


}

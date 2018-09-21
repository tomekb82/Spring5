package pl.spring.dao.impl;

import org.springframework.transaction.annotation.Transactional;
import pl.spring.dao.AbstractDao;
import pl.spring.model.AbstractEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

@Transactional
public abstract class AbstractJpaDaoImpl<T extends AbstractEntity> implements AbstractDao<T> {

  @PersistenceContext
  protected EntityManager entityManager;

  private Class<T> clazz;

  private Class<T> getClazz()  {
    try {
      if(clazz == null) {
        Type superClass = getClass().getGenericSuperclass();
        Type classType = ((ParameterizedType)superClass).getActualTypeArguments()[0];
        String className = classType.toString().split(" ")[1];
        clazz = (Class<T>) Class.forName(className);
      }
      return clazz;
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public T findById(Long id) {
    return entityManager.find(getClazz(), id);
  }

  @Override
  public List<T> findAll() {
    return entityManager.createQuery("from " + getClazz().getSimpleName(), getClazz()).getResultList();
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

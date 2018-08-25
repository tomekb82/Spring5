package pl.spring.dao;

import pl.spring.model.AbstractEntity;

import java.util.List;

public interface AbstractDao<T extends AbstractEntity> {

  T findById(Long id);

  List<T> findAll();

  void remove(T entity);

  void persist(T entity);

}

package pl.sages.persistance;

import java.util.List;

import pl.sages.persistance.model.AbstractEntity;

/**
 * Created by acacko on 22.08.18
 */
public interface AbstractDao<T extends AbstractEntity> {

  T findById(Long id);

  List<T> findAll();

}

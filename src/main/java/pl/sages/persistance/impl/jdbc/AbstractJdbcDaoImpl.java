package pl.sages.persistance.impl.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import pl.sages.persistance.AbstractDao;
import pl.sages.persistance.model.AbstractEntity;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by acacko on 22.08.18
 */
@Profile("jdbc")
public abstract class AbstractJdbcDaoImpl<T extends AbstractEntity> implements AbstractDao<T> {

  @Autowired
  protected NamedParameterJdbcTemplate jdbcTemplate; // parametry poprzedzajac ':'

  @Override
  public void remove(T entity) {
    throw new NotImplementedException();
  }

  @Override
  public void save(T entity) {
    throw new NotImplementedException();

  }
}

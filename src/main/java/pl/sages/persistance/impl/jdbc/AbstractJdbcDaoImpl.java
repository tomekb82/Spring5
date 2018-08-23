package pl.sages.persistance.impl.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import pl.sages.persistance.AbstractDao;
import pl.sages.persistance.model.AbstractEntity;

/**
 * Created by acacko on 22.08.18
 */
public abstract class AbstractJdbcDaoImpl<T extends AbstractEntity> implements AbstractDao<T> {

  @Autowired
  protected NamedParameterJdbcTemplate jdbcTemplate; // parametry poprzedzajac ':'

}

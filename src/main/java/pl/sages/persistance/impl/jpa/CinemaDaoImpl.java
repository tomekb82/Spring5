package pl.sages.persistance.impl.jpa;

import org.springframework.stereotype.Repository;
import pl.sages.persistance.CinemaDao;
import pl.sages.persistance.model.Cinema;

@Repository
public class CinemaDaoImpl extends AbstractJpaDaoImpl<Cinema> implements CinemaDao {

  public CinemaDaoImpl() {
    super(Cinema.class);
  }

  @Override
  public Cinema findByName(String name) {
    return entityManager.createQuery("from " + Cinema.class.getSimpleName() + " where name = :name", Cinema.class)
        .setParameter("name", name)
        .getResultStream()
        .findFirst().orElse(null);
  }
}

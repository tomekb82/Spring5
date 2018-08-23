package pl.sages.persistance.impl.jpa;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.sages.persistance.ShowDao;
import pl.sages.persistance.model.Show;

//
@Repository
@Transactional
public class ShowDaoImpl extends AbstractJpaDaoImpl<Show> implements ShowDao {
  //private final String findByDate = "select * from SHOW where date = :date";
  //private final String findById = "select * from SHOW where id = :id";

  public ShowDaoImpl() {
    super(Show.class);
  }

  @Override
  public Show findByDate(LocalDate date) {
    return entityManager.createQuery("from " + Show.class.getSimpleName() + " where date = :date", Show.class)
        .setParameter("date", date)
        .getResultStream()
        .findFirst().orElse(null);
  }

}

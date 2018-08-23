package pl.sages.persistance.impl.springdata;

import java.time.LocalDate;

import pl.sages.persistance.AbstractDao;
import pl.sages.persistance.model.Show;

public interface ShowDao extends AbstractDao<Show> {
    Show findByDate(LocalDate date);
}

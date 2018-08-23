package pl.sages.persistance;

import pl.sages.persistance.model.Show;

import java.time.LocalDate;

public interface ShowDao extends AbstractDao<Show> {
    public Show findByDate(LocalDate date);
}

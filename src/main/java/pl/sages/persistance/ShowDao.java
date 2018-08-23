package pl.sages.persistance;

import pl.sages.persistance.model.Show;

import java.time.LocalDate;
import java.util.Optional;

public interface ShowDao extends AbstractDao<Show> {
    Show findByDate(LocalDate date);
}

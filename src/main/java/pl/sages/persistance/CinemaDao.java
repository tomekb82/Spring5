package pl.sages.persistance;

import pl.sages.persistance.model.Cinema;

public interface CinemaDao extends AbstractDao<Cinema> {
    Cinema findByName(String name);
}

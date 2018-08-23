package pl.sages.persistance.impl.springdata;

import pl.sages.persistance.AbstractDao;
import pl.sages.persistance.model.Cinema;

public interface CinemaDao extends AbstractDao<Cinema> {
    Cinema findByName(String name);
}

package pl.sages.persistance;

import pl.sages.persistance.model.Movie;

public interface MovieDao extends AbstractDao<Movie> {

    Movie findByTitle(String title);
}

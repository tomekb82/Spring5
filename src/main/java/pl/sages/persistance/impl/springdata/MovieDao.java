package pl.sages.persistance.impl.springdata;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sages.persistance.AbstractDao;
import pl.sages.persistance.model.Movie;

public interface MovieDao extends JpaRepository<Movie, Long> {

    Movie findByTitle(String title);
}

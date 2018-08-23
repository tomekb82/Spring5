package pl.sages.persistance.impl.hibernate;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.sages.persistance.MovieDao;
import pl.sages.persistance.model.Movie;

@Repository
@Transactional
public class MovieDaoImpl extends AbstractHibernateDaoImpl<Movie> implements MovieDao {

    public MovieDaoImpl() {
        super(Movie.class);
    }

    @Override
    public Movie findByTitle(String title) {
        return getCurrentSession().createQuery("from " + Movie.class.getSimpleName() + " where title = :title", Movie.class)
                .setParameter("title", title)
                .getSingleResult();
    }

}


package pl.sages.persistance.impl.jpa;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.sql.JPASQLQuery;
import com.querydsl.sql.HSQLDBTemplates;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.sages.persistance.MovieDao;
import pl.sages.persistance.model.Movie;
import pl.sages.persistance.model.MovieDto;
import pl.sages.persistance.model.QMovieDto;

import static pl.sages.persistance.model.QMovie.movie;

@Repository
@Transactional
public class MovieDaoImpl extends AbstractJpaDaoImpl<Movie> implements MovieDao {

    public MovieDaoImpl() {
        super(Movie.class);
    }

    @Override
    public Movie findByTitle(String title) {
        return new JPAQueryFactory(entityManager)
                .selectFrom(movie)
                .where(movie.title.eq(title))
                .fetchOne();
    }

    public MovieDto findTitle(String title) {
        return new JPASQLQuery<MovieDto>(entityManager, new HSQLDBTemplates())
                .select(new QMovieDto(movie.title))
                .from(movie)
                .where(movie.title.eq(title))
                .fetchOne();
    }
}

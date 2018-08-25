package pl.sages.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sages.persistance.MovieDao;
import pl.sages.persistance.model.Movie;

import java.util.List;

@Service
public class MovieService {

    private MovieDao movieDao;

    @Autowired
    public MovieService(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    public Movie findById(Long id) {
        return movieDao.findById(id);
    }
    public Movie findMovie(String title) {
        return movieDao.findByTitle(title);
    }

    public List<Movie> findAll() {
        return movieDao.findAll();
    }


}

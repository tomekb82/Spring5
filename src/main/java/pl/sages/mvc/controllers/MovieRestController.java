package pl.sages.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.sages.persistance.model.Movie;
import pl.sages.service.MovieService;

import java.util.List;

@RestController
@RequestMapping("/api/movie")
public class MovieRestController {

    MovieService movieService;

    @Autowired
    public MovieRestController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> getMovieByTitle() {
        return movieService.findAll();

    }

    @GetMapping(value = "/{id}")
    public Movie getMovie(@PathVariable("id") Long id) {
        return movieService.findById(id);
    }

    @GetMapping(value = "/title")
    public Movie getMovieByTitle(@RequestParam("title") String title) {
        return movieService.findMovie(title);
    }
}

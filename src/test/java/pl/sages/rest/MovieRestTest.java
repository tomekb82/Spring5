package pl.sages.rest;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;
import pl.sages.persistance.model.Movie;

public class MovieRestTest {

    private RestTemplate restTemplate = new RestTemplate();

    @Test
    public void movieTest() {
        Movie movie = restTemplate.getForObject("http://localhost:9090/api/movie/1", Movie.class);
        System.out.println(movie);
    }

    @Test
    public void movieTestArray() {
        Movie[] movies = restTemplate.getForObject("http://localhost:9090/api/movie", Movie[].class);
        Assertions.assertThat(movies).isNotEmpty();
    }

}
package pl.sages.rest;

// zakładamy, że w trakcie testu będzie uruchomiony serwer

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;
import pl.sages.persistance.model.Show;
import pl.sages.persistance.model.User;

// @Ignore
public class ShowRestTest {

  private RestTemplate restTemplate = new RestTemplate();

  @Test
  public void showTest() {
    Show show = restTemplate.getForObject("http://localhost:9090/kino/api/show/show-api/1", Show.class);
    System.out.println(show);
  }

  @Test
  public void showTestArray() {
    Show[] shows = restTemplate.getForObject("http://localhost:9090/kino/api/show/shows", Show[].class);
    Assertions.assertThat(shows).isNotEmpty();
  }



}

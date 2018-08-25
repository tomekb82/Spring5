package pl.sages.rest;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;
import pl.sages.persistance.model.User;

// zakładamy, że w trakcie testu będzie uruchomiony serwer
// @Ignore
public class UserRestTest {

  private RestTemplate restTemplate = new RestTemplate();

  @Test
  public void userTest() {
    User user = restTemplate.getForObject("http://localhost:9090/kino/api/user-api/1", User.class);
    System.out.println(user);
  }

  @Test
  public void userTestArray() {
    User[] users = restTemplate.getForObject("http://localhost:9090/kino/api/users", User[].class);
    Assertions.assertThat(users).isNotEmpty();
  }

  @Test
  public void putUserTest() {
    User[] users = restTemplate.getForObject("http://localhost:9090/kino/api/users", User[].class);
    long before = users.length;

    restTemplate.getForObject("http://localhost:9090/kino/api/user/put?email=aaa&password=555", User.class);

    users = restTemplate.getForObject("http://localhost:9090/kino/api/users", User[].class);
    long after = users.length;

    Assertions.assertThat(before).isLessThan(after);
  }

}

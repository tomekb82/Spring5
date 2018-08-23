package pl.sages;

import java.time.LocalDate;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import pl.sages.service.MovieService;
import pl.sages.service.ReservationService;
import pl.sages.service.ShowService;
import pl.sages.service.UserService;

@Configuration
@Import(SpringDataConfiguration.class)
public class App {

  public static void main(String[] args) {

    System.setProperty("spring.profiles.active", "data");
    try(AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(App.class)){

      UserService userService = ctx.getBean(UserService.class);
      System.out.println(userService.findUser("any"));
      System.out.println(userService.findAll());

      MovieService movieService = ctx.getBean(MovieService.class);
      System.out.println(movieService.findMovie("movie title"));
      System.out.println(movieService.findAll());

      ShowService showService = ctx.getBean(ShowService.class);
      System.out.println(showService.findByDate(LocalDate.parse("2017-09-09")));
      //System.out.println(showService.findAll());

      ReservationService reservationService = ctx.getBean(ReservationService.class);
      System.out.println(reservationService.findReservation(1L));
      System.out.println(reservationService.findAll());

      System.out.println();
//      new MapSqlParameterSource().
    }
  }
}

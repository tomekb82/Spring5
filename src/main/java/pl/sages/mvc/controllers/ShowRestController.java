package pl.sages.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.sages.persistance.model.Show;
import pl.sages.persistance.model.User;
import pl.sages.service.ShowService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/api/show")
public class ShowRestController {

  private final ShowService showService;

  @Autowired
  public ShowRestController(ShowService showService) {
    this.showService = showService;
  }

  //api/show/all
@GetMapping(value = "all")
  private List<Show> getShows() {
    return showService.findAll();
  }

  // /api/show?date=X
  @GetMapping
  public Show getShow(@RequestParam("date") String date) {
    //LocalDate.parse("2017-09-09")
    return showService.findByDate(LocalDate.parse(date));
  }

  // /api/show/show-api/2
  @GetMapping(value = "/show-api/{id}")
  public Show getShowApi(@PathVariable("id") Long id) {
    return showService.findById(id);
  }

  // /show-example/{id}?date=X
  @GetMapping(value = "/show-example/{id}")
  public Show getShowExample2(@PathVariable("id") Long id,
                              @RequestParam("date") String date) {
    System.out.println(id + date);
    return showService.findById(id);
  }

  // przesyłanie jako object:
  // http://localhost:9090/kino/api/show/show-object?id=1
  @GetMapping(value = "/show-object")
  public Show getShow(Show show) {
    System.out.println(show);
    return showService.findById(show.getId());
  }


}

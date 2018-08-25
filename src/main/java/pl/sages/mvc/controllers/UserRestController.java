package pl.sages.mvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.sages.persistance.model.User;
import pl.sages.service.UserService;

@RestController // to samo co @Controller (nad klasą) + @ResponseBody (nad metodą)
@RequestMapping(value = "/api")
public class UserRestController {

  private final UserService userService;

  @Autowired
  public UserRestController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping(value = "/users")
  public List<User> getUser() {
    return userService.findAll();
  }

  // /api/user?id=X
  @GetMapping(value = "/user")
  public User getUser(@RequestParam("id") Long id) {
    return userService.findById(id);
  }

  // inny przykład:
  // /api/user?id=X&email=sss

  // /api/user-api/2
  @GetMapping(value = "/user-api/{id}")
  public User getUserApi(@PathVariable("id") Long id) {
    return userService.findById(id);
  }

  // /user-example/{id}?email=X
  @GetMapping(value = "/user-example/{id}")
  public User getUserExample2(@PathVariable("id") Long id,
                              @RequestParam("email") String email) {
    System.out.println(id + email);
    return userService.findById(id);
  }

  // przesyłanie jako object:
  // http://localhost:9090/kino/api/user-object?id=1&email=aaa
  @GetMapping(value = "/user-object")
  public User getUser(User user) {
    System.out.println(user);
    return userService.findById(user.getId());
  }

  @GetMapping(value = "/user/put")
  public User putUser(User user) {
    userService.createUser(user);
    return user;
  }

  // przykład dla zwracania XML:
  @GetMapping(value = "/2", produces = MediaType.APPLICATION_XML_VALUE)
  public Person getUserXml() {
    Person person = new Person();
    person.setName("Arek");
    return person;
  }
}

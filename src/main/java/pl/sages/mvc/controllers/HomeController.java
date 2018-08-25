package pl.sages.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.NoHandlerFoundException;

@Controller
@RequestMapping(value = "/")
public class HomeController {

  @GetMapping
//   dawna adnotacja:
//  @RequestMapping(method = RequestMethod.GET)
  public String get() {
    return "home";
  }

  @RequestMapping(value = "/about", method = RequestMethod.GET)
  public String getAbout() {
    return "home";
  }



}

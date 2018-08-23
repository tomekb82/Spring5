package pl.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;
import org.apache.log4j.Logger;

@ComponentScan(basePackages = {"pl.spring"})
public class App {

  static final  Logger logger = Logger.getLogger(App.class);

  public static void main(String[] args) {

    try(AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(App.class)) {
      logger.info(Arrays.asList(ctx.getBeanDefinitionNames()));

      Album album = ctx.getBean("album", Album.class);
      System.out.println(album);
    }
  }
}

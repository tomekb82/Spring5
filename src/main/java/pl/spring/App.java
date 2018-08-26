package pl.spring;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.*;

import java.util.Arrays;

@ImportResource("classpath:context.xml")
@ComponentScan(basePackages = {"pl.spring"})
@PropertySource("classpath:config.properties")
@Import(JpaConfiguration.class)
public class App {

  static final  Logger logger = Logger.getLogger(App.class);

  public static void main(String[] args) {

    // ustawienie aktywnego profilu
    System.setProperty("spring.profiles.active", "jpa");

    try(AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(App.class)) {
      logger.info(Arrays.asList(ctx.getBeanDefinitionNames()));

      Album album = ctx.getBean("album", Album.class);
      album.setName("test");
      System.out.println(album);

      Album albumXml = ctx.getBean("albumXml", Album.class);
      System.out.println(albumXml);



    }
  }
}

package pl.sages;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@ImportResource("classpath:context.xml")
@ComponentScan(basePackages = {"pl.sages", "pl.sages"})
@PropertySource("classpath:config.properties")
public class AppAnnotations {

  // ustawianie profilu podczas uruchamiania aplikacji jako parametr VM: -Dspring.profiles.active=test
  public static void main(String[] args) {

    // aby przykład działał ustawiam na sztywno profil "test"
    System.setProperty("spring.profiles.active", "test");

    try(AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppAnnotations.class)) {
      System.out.println("AAAAAAAAAa");
      System.out.println(ctx.getBean("person", Person.class));
    }
  }
}

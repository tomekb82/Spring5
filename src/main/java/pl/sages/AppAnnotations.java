package pl.sages;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@ImportResource("classpath:context.xml")
@ComponentScan(basePackages = {"pl.sages", "pl.sages"})
@PropertySource("classpath:config.properties")
public class AppAnnotations {

  public static void main(String[] args) {

    try(AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppAnnotations.class)) {
      System.out.println("AAAAAAAAAa");
      System.out.println(ctx.getBean("person", Person.class));
    }
  }
}

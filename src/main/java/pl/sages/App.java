package pl.sages;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"pl.sages", "pl.sages"})
public class App {

  public static void main(String[] args) {

    try(AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(App.class)) {
      System.out.println("AAAAAAAAAa");
      System.out.println(Arrays.asList(ctx.getBeanDefinitionNames()));
//      Animal person = ctx.getBean(Animal.class);
//      System.out.println(person);


//      Building building = ctx.getBean("building", Building.class);
//      System.out.println(building.toString());
//
//      Building building2 = ctx.getBean("building2", Building.class);
//      System.out.println(building2.toString());
//
//      Building building3 = ctx.getBean("building3", Building.class);
//      System.out.println(building3.toString());
    }
  }
}

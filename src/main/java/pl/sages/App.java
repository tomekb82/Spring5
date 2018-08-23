package pl.sages;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

  public static void main(String[] args) {

    try(AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfiguration.class)) {
      Person person = ctx.getBean("person", Person.class);
      person.sayHallo();

      person = ctx.getBean("person2", Person.class);
      person.sayHallo();

      Leg leg = ctx.getBean("leg", Leg.class);
      System.out.println(leg.toString());


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

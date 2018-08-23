package pl.sages;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

  public static void main(String[] args) {

    try(ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml")) {
      Person person = ctx.getBean("person", Person.class);
      person.sayHallo();

      person = ctx.getBean("person2", Person.class);
      person.sayHallo();

      person = ctx.getBean("person3", Person.class);
      person.sayHallo();

      person = ctx.getBean("person4", Person.class);
      person.sayHallo();

      person = ctx.getBean("person5", Person.class);
      person.sayHallo();

      Building building = ctx.getBean("building", Building.class);
      System.out.println(building.toString());

      Building building2 = ctx.getBean("building2", Building.class);
      System.out.println(building2.toString());

      Building building3 = ctx.getBean("building3", Building.class);
      System.out.println(building3.toString());
    }
  }
}

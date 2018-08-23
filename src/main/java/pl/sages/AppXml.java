package pl.sages;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppXml {

  public static void main(String[] args) {

    try(ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml")) {
      System.out.println("AAAAAAAAAa");
      System.out.println(ctx.getBean("person2", Person2.class));
      System.out.println(ctx.getBean("person", Person.class));
    }
  }
}

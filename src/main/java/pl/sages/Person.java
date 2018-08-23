package pl.sages;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component("person")   // nazwa beana: person
@Profile({"test", "dev"})
public class Person implements Animal {

  @Value("#{'${user:AREK}'.toUpperCase()}")
  private String name;

  @Value("#{'${user:AREK}'.equals('ddd')}")
  private boolean result;

  @Value("#{leg.toString()}")
  private String legRes;

  private Leg leg;

  public Person(String name) {
    this.name = name;
  }

  public Person(String name, Leg leg) {
    this.name = name;
    this.leg = leg;
  }

  private Person() {}

  @PostConstruct    // <-- odpowiednik init
  public void init() { // public void bezparametrowy  <-- do init
    System.out.println("I'm ready");
  }


  public void sayHallo() {
    System.out.println("Hello3! " + name + leg);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Leg getLeg() {
    return leg;
  }

  public void setLeg(Leg leg) {
    this.leg = leg;
  }

  @Override
  public String toString() {
    return "Person{" +
        "name='" + name + '\'' +
        ", leg=" + leg +
            ", result=" + result +
            ", legRes=" + legRes +
        '}';
  }
}

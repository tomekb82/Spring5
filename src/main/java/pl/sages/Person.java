package pl.sages;

import java.util.List;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component("person")   // nazwa beana: person
@Profile({"test", "dev"})
public class Person implements Animal {

  // tworzenie string poprzez ' a nie ".
  // wrzucanie do #{} wartości ${} poprzez zbudowanie z nich Stringa #{'${}'}
  @Value("#{'${user:AREK}'.toUpperCase()}")
  private String name;

  @Value("#{'${user:AREK}'.equals('ddd')}")
  private boolean result;

  @Value("#{leg.toString()}")
  private String legRes;

  @Value("#{leg.test.equals('test leg2')}")
  private Boolean isLegs;

  // filtrowanie listy do elemetów spełniający dany warunek:
  @Value("#{leg.list.?[equals('ee')]}")
  private List<String> legs;

  private Leg leg;

  @PostConstruct
  public void init() {
    System.out.println(legs);
  }

  public Person(String name) {
    this.name = name;
  }

  public Person(String name, Leg leg) {
    this.name = name;
    this.leg = leg;
  }

  private Person() {}

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
        '}';
  }
}

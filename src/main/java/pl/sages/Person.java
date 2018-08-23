package pl.sages;


public class Person {

  private String name; // <-- cuda wianki!

  private Leg leg;

  public Person(String name) {
    this.name = name;
  }

  public Person(String name, Leg leg) {
    this.name = name;
    this.leg = leg;
  }

  private Person() {}

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
        '}';
  }
}

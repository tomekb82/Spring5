package pl.sages.openclosed.bad;

import pl.sages.openclosed.good.IGreetingStrategy;

public class Greeter {

  private String formality;
  private IGreetingStrategy greeting;

  public String sayHello() {
    return this.greeting!=null ? this.greeting.sayHello() : "Hello.";
  }

  public void setFormality(String formality) {
    this.formality = formality;
  }

  public void setGreeting(IGreetingStrategy greeting) {
    this.greeting = greeting;
  }
}
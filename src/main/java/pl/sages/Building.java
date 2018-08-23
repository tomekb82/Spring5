package pl.sages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Building {

  private final Animal animal;

  @Autowired
  public Building(@Qualifier("person") Animal animal) {
    this.animal = animal;
  }

  @Override
  public String toString() {
    return "Building{" +
        "animal=" + animal +
        '}';
  }

}

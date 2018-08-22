package pl.sages.Interfacesegregation.bad;

import pl.sages.Interfacesegregation.good.FloatingBird;

public class Penguin implements FloatingBird {
  private String currentLocation;
  private int numberOfFeathers;

  public Penguin(int initialFeatherCount) {
    this.numberOfFeathers = initialFeatherCount;
  }

  public void molt() {
    this.numberOfFeathers -= 1;
  }
  
  public void swim() {
    this.currentLocation = "in the water";
  }
}
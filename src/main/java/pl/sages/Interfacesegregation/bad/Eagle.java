package pl.sages.Interfacesegregation.bad;

public class Eagle implements Bird {

  private String currentLocation;
  private int numberOfFeathers;

  public Eagle(int initialFeatherCount) {
    this.numberOfFeathers = initialFeatherCount;
  }

  public void fly() {
    this.currentLocation = "in the air";
  }

  public void molt() {
    this.numberOfFeathers -= 1;
  }
}

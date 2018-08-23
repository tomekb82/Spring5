package pl.sages;

/**
 * Created by acacko on 21.08.18
 */
public class Building {

  private Leg leg;

  public Building() {}

  @Override
  public String toString() {
    return "Building{" +
        "leg=" + leg +
        '}';
  }

  public Building(Leg leg) {
    this.leg = leg;
  }

  public Leg getLeg() {
    return leg;
  }

  public void setLeg(Leg leg) {
    this.leg = leg;
  }
}

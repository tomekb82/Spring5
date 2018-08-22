package pl.sages.liskovsubstitution.bad;

public class Car extends Vehicle {

  @Override
  public void changeGear(Gear gear) {
    if(Gear.R.equals(gear) && getGear().equals(Gear.D)){
      super.changeGear(Gear.N);
    }
  }
}
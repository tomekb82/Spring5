package pl.sages;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by acacko on 21.08.18
 */
@Component
public class Leg {

  @Value("#{'test leg'}")    // <-- String test = "test leg"
  private String test;

  List<String> list;

  public Leg() {
    this.list = new ArrayList<>();
    this.list.add("ee");
    this.list.add("ss");
    this.list.add("dd");
    this.list.add("ee");
  }


  public String getTest() {
    return test;
  }

  public void setTest(String test) {
    this.test = test;
  }

  public List<String> getList() {
    return list;
  }

  public void setList(List<String> list) {
    this.list = list;
  }

  @Override
  public String toString() {
    return "Leg{" +
        "test='" + test + '\'' +
        '}';
  }
}

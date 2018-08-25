package pl.sages.mvc.controllers;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by acacko on 24.08.18
 */
@XmlRootElement(name = "Person")
public class Person {

  private String name;

  @XmlElement(name = "name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}

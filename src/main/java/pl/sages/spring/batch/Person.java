package pl.sages.spring.batch;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Person")
public class Person {

  private int id;
  private String name;
  private String surname;
  private String pesel;
  private String sex; // M/W
  private String occupation;

  @XmlAttribute(name = "sex")
  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  @XmlAttribute(name = "id")
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @XmlAttribute(name = "name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @XmlAttribute(name = "surname")
  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  @XmlAttribute(name = "pesel")
  public String getPesel() {
    return pesel;
  }

  public void setPesel(String pesel) {
    this.pesel = pesel;
  }

  @XmlAttribute(name = "occupation")
  public String getOccupation() {
    return occupation;
  }

  public void setOccupation(String occupation) {
    this.occupation = occupation;
  }

  @Override
  public String toString() {
    return "Person{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", surname='" + surname + '\'' +
        ", pesel='" + pesel + '\'' +
        ", sex='" + sex + '\'' +
        ", occupation='" + occupation + '\'' +
        '}';
  }
}

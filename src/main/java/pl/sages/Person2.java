package pl.sages;

import org.springframework.beans.factory.annotation.Value;

public class Person2 implements Animal {

  @Value("${password}")
  private String password;

  public Person2() {}

  public Person2(String password) {
    this.password = password;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return "Person2{" +
        "password='" + password + '\'' +
        '}';
  }
}

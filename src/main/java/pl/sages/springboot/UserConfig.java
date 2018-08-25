package pl.sages.springboot;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


// obiekt zostanie załadowany danymi z application.yml (lub properties)
@Configuration
@ConfigurationProperties(value = "config")
public class UserConfig {

  private String name;
  private String surname;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }
}

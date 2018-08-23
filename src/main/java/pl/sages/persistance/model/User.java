package pl.sages.persistance.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User extends AbstractEntity {

  // @Column(name = "email")   <-- zbędne jeśli pokrywa się z nazwą kolumny w DB
  private String email;
  private String password;

  public User(){}

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}

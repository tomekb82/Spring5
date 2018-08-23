package pl.sages.persistance.model;

import java.io.Serializable;

/**
 * Created by acacko on 22.08.18
 */
public abstract class AbstractEntity implements Serializable {

  private Long id;

  public AbstractEntity() {}

  public AbstractEntity(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}

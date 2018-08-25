package pl.spring.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ALBUM")
@NoArgsConstructor
@Getter
@Setter
public class Album extends AbstractEntity {

  private String name;

}

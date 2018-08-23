package pl.spring;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component("album")
@Getter
@Setter
@ToString
public class Album  {

  private String name;

}

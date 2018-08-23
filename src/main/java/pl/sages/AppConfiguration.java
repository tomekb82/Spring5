package pl.sages;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfiguration {

  @Bean
  public Person person(){ // bean będzie nazywał się person
    return new Person("Maciek", leg());
  }

  @Bean(initMethod = "init") // <-- i pozostałe: destroy, autowiere
  public Person person2(){ // bean będzie nazywał się person
    return new Person("Maciek2", leg());
  }

  @Bean
  @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
  public Leg leg() {
    return new Leg();
  }

}

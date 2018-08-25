package pl.sages.spring.batch;

import org.springframework.batch.item.ItemProcessor;

public class PersonItemProcessor implements ItemProcessor<Person, Person> {

  @Override
  public Person process(Person person) throws Exception {
    person.setSex( (person.getPesel().charAt(9) - '0') % 2 != 0 ? "M": "W");
    System.out.println("Processing..." + person);
    return person;
  }
}

package pl.sages;

/**
 * Created by acacko on 21.08.18
 */
public class PersonFactory {


  public static Person buildPerson(){
    return new Person("AREK from static FACTORY");
  }

  public Person getPeople() {
    return new Person("AREK from non-static FACTORY");
  }
}

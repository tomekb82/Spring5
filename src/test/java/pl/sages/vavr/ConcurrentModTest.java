package pl.sages.vavr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class ConcurrentModTest {

  @Test(expected = ConcurrentModificationException.class)
  public void concurrent_mod_exception() {
    List<String> strings = new ArrayList<>(Arrays.asList("Foo", "Bar", "Quz"));

    Iterator<String> iterator = strings.iterator();
    strings.add("aa");
    String next = iterator.next();

  }

}

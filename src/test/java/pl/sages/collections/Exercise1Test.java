package pl.sages.collections;

import org.junit.Test;
import pl.sages.testentity.ClassicOnlineStore;
import pl.sages.testentity.Customer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Exercise1Test extends ClassicOnlineStore {

  @Test
  public void iterateByForEach() {
    Iterable<Customer> customerIterable = this.mall.getCustomerList();
    List<String> nameList = new ArrayList<>();

    /**
     * Create a {@link Consumer} which represents an operation to add customer's name to {@link nameList} list.
     * Iterate {@link customerIterable} with {@link Iterable#forEach} and use the {@link Consumer}
     * to finish creating the name list.
     */
    Consumer<Customer> consumer = (Customer el) -> nameList.add(el.getName());
    customerIterable.forEach(consumer);

    assertThat(nameList.toString(), is("[Joe, Steven, Patrick, Diana, Chris, Kathy, Alice, Andrew, Martin, Amy]"));
  }

  @Test
  public void whoHaveNoEInYourName() {
    Collection<String> nameCollection =
        new ArrayList<>(Arrays.asList("Joe", "Steven", "Patrick", "Chris"));

    /**
     * Create a {@link Predicate} which predicates if the input string contains "e".
     * Remove elements from {@link nameCollection} which contains "e" using {@link Collection#removeIf}.
     */
    Predicate<String> predicate = (String e) -> e.contains("e");
    nameCollection.removeIf(predicate);

    assertThat(nameCollection.toString(), is("[Patrick, Chris]"));
  }

  @Test
  public void replaceTheElements() {
    List<String> nameList =
        new ArrayList<>(Arrays.asList("Joe", "Steven", "Patrick", "Chris"));

    /**
     * Create a {@link UnaryOperator} which returns given string wrapped with "()".
     * Replace the elements in {@link nameList} with string wrapped with "()" using {@link List#replaceAll} .
     */
    UnaryOperator<String> unaryOperator = (String e) -> '(' + e + ')';
    nameList.replaceAll(unaryOperator);

    assertThat(nameList.toString(), is("[(Joe), (Steven), (Patrick), (Chris)]"));
  }

  @Test
  public void sortByName() {
    List<String> nameList =
        new ArrayList<>(Arrays.asList("Joe", "Steven", "Patrick", "Chris"));

    Comparator<String> comparator = Comparator.comparingInt(String::length);
    nameList.sort(comparator);

    assertThat(nameList.toString(), is("[Joe, Chris, Steven, Patrick]"));
  }

  @Test
  public void createStream() {
    Collection<String> nameList =
        new ArrayList<>(Arrays.asList("Joe", "Steven", "Patrick", "Chris"));

    /**
     * Create a serial {@link Stream} using {@link Collection#stream}
     * You can learn about {@link Stream} APIs at stream-api module.
     */
    Stream<String> nameStream = nameList.stream();

    assertThat(nameStream.count(), is(4L));
    assertThat(nameStream.isParallel(), is(false));
  }

  @Test
  public void createParallelStream() {
    Collection<String> nameList =
        new ArrayList<>(Arrays.asList("Joe", "Steven", "Patrick", "Chris"));

    /**
     * Create a parallel {@link Stream} using {@link Collection#parallelStream} or {@link Stream#parallel}
     */
    Stream<String> nameParallelStream = nameList.parallelStream();

    assertThat(nameParallelStream.count(), is(4L));
    assertThat(nameParallelStream.isParallel(), is(true));
  }
}

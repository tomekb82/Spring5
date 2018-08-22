package pl.sages.stream3;

import org.junit.Test;
import pl.sages.testentity.ClassicOnlineStore;
import pl.sages.testentity.Customer;
import pl.sages.testentity.Item;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Exercise3Test extends ClassicOnlineStore {

   @Test
  public void howManyItemsWanted() {
    List<Customer> customerList = this.mall.getCustomerList();

    /**
     * Count how many items there are in {@link Customer.wantToBuy} using {@link Stream#count}
     */
       Stream<Item> itemStream = customerList.stream()
               .map(Customer::getWantToBuy)
               .flatMap(Collection::stream);
       long sum = itemStream.count();

    assertThat(sum, is(32L));
  }

   @Test
  public void richestCustomer() {
    List<Customer> customerList = this.mall.getCustomerList();

    /**
     * Find the richest customer's budget by using {@link Stream#max} and {@link Comparator#naturalOrder}
     * Don't use {@link Stream#sorted}
     */
    Comparator<Integer> comparator = Comparator.naturalOrder();
    Optional<Integer> richestCustomer = customerList.stream()
            .map(Customer::getBudget)
            .max(comparator);

    assertThat(comparator.getClass().getSimpleName(), is("NaturalOrderComparator"));
    assertThat(richestCustomer.get(), is(12000));
  }

   @Test
  public void youngestCustomer() {
    List<Customer> customerList = this.mall.getCustomerList();

    /**
     * Find the youngest customer by using {@link Stream#min}
     * Don't use {@link Stream#sorted}
     */
    Comparator<Customer> comparator = Comparator.comparingInt(Customer::getAge);
    Optional<Customer> youngestCustomer = customerList.stream()
            .min(comparator);

    assertThat(youngestCustomer.get(), is(customerList.get(8)));
  }
}

package pl.sages.stream3;

import org.junit.Test;
import pl.sages.testentity.ClassicOnlineStore;
import pl.sages.testentity.Customer;
import pl.sages.testentity.Item;
import pl.sages.testentity.Shop;

import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;

public class Exercise8Test extends ClassicOnlineStore {

  @Test //Difficult
  public void itemsNotOnSale() {
    Stream<Customer> customerStream = this.mall.getCustomerList().stream();
    Stream<Shop> shopStream = this.mall.getShopList().stream();

    /**
     * Create a set of item names that are in {@link Customer.wantToBuy} but not on sale in any shop.
     */
    List<String> itemListOnSale = null;
    Set<String> itemSetNotOnSale = null;

    assertThat(itemSetNotOnSale, hasSize(3));
    assertThat(itemSetNotOnSale, hasItems("bag", "pants", "coat"));
  }

  @Test //Difficult
  public void havingEnoughMoney() {
    Stream<Customer> customerStream = this.mall.getCustomerList().stream();
    Stream<Shop> shopStream = this.mall.getShopList().stream();

    /**
     * Create a customer's name list including who are having enough money to buy all items they want which is on sale.
     * Items that are not on sale can be counted as 0 money cost.
     * If there is several same items with different prices, customer can choose the cheapest one.
     */
    List<Item> onSale = null;
    Predicate<Customer> havingEnoughMoney = null;
    List<String> customerNameList = null;

    assertThat(customerNameList, hasSize(7));
    assertThat(customerNameList, hasItems("Joe", "Patrick", "Chris", "Kathy", "Alice", "Andrew", "Amy"));
  }
}
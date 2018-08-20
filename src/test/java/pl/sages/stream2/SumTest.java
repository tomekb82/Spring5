package pl.sages.stream2;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

/*
Sum all elements of a collection
 */
public class SumTest {

    @Test
    public void calculateShouldReturnSumOfAllIntegersInCollection() {
        List<Integer> numbers = asList(1, 2, 3, 4, 5);
        Assertions.assertThat(Sum.calculate(numbers)).isEqualTo(1 + 2 + 3 + 4 + 5);
    }

}

package pl.sages.vavr;

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;

import io.vavr.Function1;
import io.vavr.Function2;
import io.vavr.control.Option;
import org.junit.Test;

import static io.vavr.Function1.lift;
import static java.lang.Integer.MAX_VALUE;
import static java.time.LocalDate.now;
import static java.util.Optional.ofNullable;
import static org.assertj.core.api.Assertions.assertThat;

public class FunctionTest {

  @Test
  public void old_way_currying() {
    BiFunction<Integer, Integer, Integer> f = (i, j) -> i * j;
    Function<Integer, Integer> curried = (i) -> f.apply(2, i);
    assertThat(curried.apply(5)).isEqualTo(10);
  }

  /**
   * Currying as was intended.
   */
  @Test
  public void curry_simple_function() {
    Function2<Integer, Integer, Integer> func = (i, j) -> i * j;
    assertThat(func.apply(3, 4)).isEqualTo(12);
    Function<Integer, Integer> doubleIt = func.curried().apply(2);
    assertThat(doubleIt.apply(12)).isEqualTo(24);
  }

  @Test(expected = IllegalStateException.class)
  public void normal_function_with_exception() {
    Function1<Subject, Boolean> subjectToString = Subject::isValid;
    subjectToString.apply(new Subject(null, null));
  }

  /**
   * Lift can be used to encapsulate exceptions.
   */
  @Test
  public void using_lift_to_handle_partials() {
    Function1<Subject, Option<Boolean>> lifted = lift(Subject::isValid);

    assertThat(lifted.apply(new Subject(null, null)).isEmpty()).isTrue();
    assertThat(lifted.apply(new Subject("foo", now())).get()).isTrue();
    assertThat(lifted.apply(new Subject("a name that is too long", now())).get()).isFalse();
  }

  @Test
  public void callMeTwiceAndIfWillFail_returns_the_maxint_value() {
    assertThat(MAX_VALUE).isEqualTo(new Subject("foo", now()).callMeTwiceAndIfWillFail());
  }

  @Test(expected = RuntimeException.class)
  public void callMeTwiceAndIfWillFail_fails_if_called_twice() {
    Subject subject = new Subject("foo", now());
    assertThat(subject.callMeTwiceAndIfWillFail()).isEqualTo(MAX_VALUE);

    subject.callMeTwiceAndIfWillFail();
  }

  @Test
  public void memoization() {
    Subject subject = new Subject(" foo", now());

    // old way
    // 1. lifting w.o. exception handling etc.
    Function<Subject, Optional<Integer>> lifted = (Subject s) -> ofNullable(s.callMeTwiceAndIfWillFail());

    // vavr
    Function1<Subject, Option<Integer>> memoized = lift(Subject::callMeTwiceAndIfWillFail).memoized();

    assertThat(memoized.apply(subject).get()).isEqualTo(MAX_VALUE);

    assertThat(memoized.apply(subject).get()).isEqualTo(MAX_VALUE);
  }

}

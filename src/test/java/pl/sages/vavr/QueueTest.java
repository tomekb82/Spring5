package pl.sages.vavr;

import java.util.NoSuchElementException;

import io.vavr.Tuple;
import io.vavr.Tuple2;
import io.vavr.collection.Queue;
import io.vavr.control.Option;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QueueTest {
  @Test
  public void dequeue() {
    Queue<Team> t = Queue.of(Team.withName("F95"), Team.withName("FCK"));

    Tuple2<Team, Queue<Team>> t2 = t.dequeue();
    Assertions.assertThat(Team.withName("F95")).isEqualTo(t2._1);
    assertThat(t.tail().head()).isSameAs(t2._2.head());
  }

  @Test(expected = NoSuchElementException.class)
  public void dequeue_empty_queue() {
    Queue<Team> t = Queue.empty();
    t.dequeue();
  }

  @Test
  public void dequeue_empty_queue_functional_way() {
    Queue<Team> t = Queue.empty();
    Option<Tuple2<Team, Queue<Team>>> t2 = t.dequeueOption();
    assertThat(t2.isDefined()).isFalse();
  }

  @Test
  public void dequeue_option_style() {
    Queue<String> t = Queue.empty();
    String result =
        t.dequeueOption()
            .getOrElse(Tuple.of("nothing", Queue.empty()))
            ._1;
    assertThat(result).isEqualTo("nothing");
  }
}

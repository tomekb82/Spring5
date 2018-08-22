package pl.sages.vavr;

import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

public class Lists {
  public static <S, T> List<T> map(List<S> first, Function<S, T> f) {
    return first.stream().map(f).collect(toList());
  }
}

package pl.sages.vavr;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import io.vavr.collection.List;
import io.vavr.control.Try;

import static java.nio.charset.StandardCharsets.UTF_8;

public class FeedFetcher {

  public static String titanicFeed() {
    return "http://www.titanic-magazin.de/dsda.rss";
  }

  public static void main(String[] args) throws IOException {
    new FeedFetcher().readFromUrl(new URL(titanicFeed())).forEach(System.out::println);
  }

  public List<String> fetch(String feedUrl) {
    return
        Try.of(() -> new URL(feedUrl))
            .flatMap(this::readFromUrl)
            .getOrElse(List.empty());
  }

  private Try<List<String>> readFromUrl(URL url) {
    return Try.of(url::openStream)
        .map(is -> {
          final java.util.List<String> result = new ArrayList<>();
          new Scanner(is, UTF_8.name())
              .useDelimiter("<item>")
              .forEachRemaining(result::add);
          return result;
        })
        .map(List::ofAll);
  }
}

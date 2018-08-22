package pl.sages.vavr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import io.vavr.control.Try;
import org.junit.Test;

import static io.vavr.API.$;
import static io.vavr.API.Case;
import static io.vavr.API.Match;
import static io.vavr.Patterns.$Failure;
import static io.vavr.Patterns.$Success;
import static io.vavr.Predicates.instanceOf;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class PatternMatchCommandlineTest {

  @Test
  public void foo() {
    System.out.println("FFFF");
  }

  @Test
  public void classic_exception_handling() {
    try {
      fetchFromUrlClassic("http://senacor.com");
    } catch (MalformedURLException e) {
      // ...
    } catch (IOException e) {
      // ...
    }
  }

  private List<String> fetchFromUrlClassic(String url) throws IOException {
    URLConnection urlConnection = new URL(url).openConnection();

    try (BufferedReader r = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))) {
      return r.lines().collect(toList());
    }
  }

  @Test
  public void js_fetch() {
    System.out.println(fetchFromUrl("http://senacor.com"));
  }

  @Test(expected = RuntimeException.class)
  public void js_fetch_doesnotexist() {
    System.out.println(fetchFromUrl("http://doesnotexist.uk")
        .getOrElseThrow(t -> new RuntimeException("Cannot fetch from host", t)));
  }

  @Test
  public void match_error_with_wildcard() {
    List<String> result =
        Match(fetchFromUrl("http://doesnotexist.uk")).of(
            Case($Success($()), identity()),
            Case($Failure($()), Collections.<String>emptyList())
        );
    assertThat(result).isEmpty();
  }

  @Test
  public void js_fetch_doesnotexist_with_mapping() {
    List<String> result = Match(fetchFromUrl("http://doesnotexist.uk")).of(
        Case($Success($(new ArrayList<>())), identity()),
        Case($Failure($(instanceOf(UnknownHostException.class))), Collections.<String>emptyList()),
        Case($Failure($(instanceOf(MalformedURLException.class))), Collections.<String>emptyList())
    );
    assertThat(result).isEmpty();
  }

  @Test(expected = UnsupportedOperationException.class)
  public void boom() {
    Collections
        .unmodifiableList(Collections.emptyList())
        .add("BUMM");
  }

  @Test
  public void js_fetch_not_an_url() {
    List<String> result =
        Match(fetchFromUrl("NOT A URL")).of(
            Case($Success($(new ArrayList<>())), identity()),
            Case($(), v -> Collections.<String>emptyList()));
    System.out.println(result);
  }

  private Try<List<String>> fetchFromUrl(String urldata) {
    return Try.of(() -> new URL(urldata))
        .flatMap(url -> Try.of(url::openConnection))
        .flatMap(conn -> Try.of(() -> new BufferedReader(new InputStreamReader(conn.getInputStream()))))
        .flatMap(reader -> Try.of(() -> reader.lines().collect(toList())));
  }

}

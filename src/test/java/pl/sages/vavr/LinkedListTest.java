package pl.sages.vavr;

import io.vavr.collection.List;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.Assert.assertNotSame;

public class LinkedListTest {

  @Test
  public void a_linked_list_is_persistent() {
    List<Team> teams = List.of(Team.withName("F95"));
    List<Team> moreTeams = teams.append(Team.withName("FCK"));

    assertNotSame(teams, moreTeams);
    assertThat(teams.size()).isEqualTo(1);
    assertThat(teams.get(0)).isSameAs(moreTeams.get(0));
  }

}

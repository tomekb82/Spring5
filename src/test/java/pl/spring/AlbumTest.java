package pl.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;
import pl.spring.dao.AlbumDao;

import java.util.List;
import pl.spring.model.Album;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = App.class)
@ActiveProfiles("jpa")
public class AlbumTest {

  @Autowired
  private pl.spring.Album album;

  @Autowired
  private AlbumDao albumDao;

  @Test
  public void albumTest(){
    System.out.println(album);
    Assert.notNull(album, "null person. DI not working");
  }

  @Test
  public void albumFindAll(){
      List<Album> albums = albumDao.findAll();
      assertThat(albums).isNotNull();
      assertThat(albums.size()==2);
  }

  @Test
   public void findByIdTest(){
      Album album = albumDao.findByName("album 1");
      assertThat(album).isNotNull();
      assertThat(album.getId()).isEqualTo(1);
  }


}

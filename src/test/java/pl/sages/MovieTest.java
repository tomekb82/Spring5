package pl.sages;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.sages.persistance.MovieDao;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = App.class)
public class MovieTest {

    @Autowired
    MovieDao movieDao;

    @Test
    public void findByIdTest(){
        assertThat(movieDao.findById(1L)).isNotNull();
    }

    @Test
    public void findByTitleTest(){
        assertThat(movieDao.findByTitle("movie title")).isNotNull();
    }

    @Test
    public void findAllTest(){
        assertThat(movieDao.findAll()).isNotNull();
    }
}

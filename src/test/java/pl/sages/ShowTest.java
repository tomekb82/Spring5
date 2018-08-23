package pl.sages;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import pl.sages.persistance.MovieDao;
import pl.sages.persistance.RoomDao;
import pl.sages.persistance.ShowDao;
import pl.sages.persistance.model.Cinema;
import pl.sages.persistance.model.Movie;
import pl.sages.persistance.model.Room;
import pl.sages.persistance.model.Show;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = App.class)
@ActiveProfiles("jpa")
@Transactional
public class ShowTest {
    @Autowired
    ShowDao showDao;


    @Test
    public void findByIdTest(){
        //Assert.notNull(showDao.findById(1L), "no proper ShowDao result");
        Assertions.assertThat(showDao.findById(1L)).isNotNull();
    }

    @Test
    public void findByDateTest(){
        //Assert.notNull(showDao.findByDate(LocalDate.parse("2017-09-09")), "no proper ShowDao result");
        Assertions.assertThat(showDao.findByDate(LocalDate.parse("2017-09-09"))).isNotNull();
    }

    @Test
    public void findAllTest(){
        Assert.notNull(showDao.findAll(), "no proper ShowDao result");
    }


    @Test
    public void saveTest(){
        Room room = new Room();
        room.setNumber(3);
        room.setCapacity(3);

        Movie movie = new Movie();
        movie.setTitle("Maciek Test");
        movie.setPrice(new BigDecimal(1.01));

        assertThat(room.getId()).isNull();
        //roomDao.save(room); // niepotrzebne bo jest Cascade dodane w opisie relacji ManyToOne w Show
        assertThat(movie.getId()).isNull();
        //movieDao.save(movie); // niepotrzebne bo jest Cascade dodane w opisie relacji ManyToOne w Show

        Show show = new Show(movie, room, LocalDate.now());
        assertThat(show.getId()).isNull();
        showDao.save(show);
        assertThat(show.getId()).isNotNull();
        assertThat(show.getMovie().getId()).isNotNull();
        assertThat(show.getRoom().getId()).isNotNull();
    }

    @Test
    public void removeTest(){
        Room room = new Room();
        room.setNumber(3);
        room.setCapacity(3);

        Movie movie = new Movie();
        movie.setTitle("Maciek Test");
        movie.setPrice(new BigDecimal(1.01));

        assertThat(room.getId()).isNull();
        //roomDao.save(room); // niepotrzebne bo jest Cascade dodane w opisie relacji ManyToOne w Show
        assertThat(movie.getId()).isNull();
        //movieDao.save(movie); // niepotrzebne bo jest Cascade dodane w opisie relacji ManyToOne w Show

        Show show = new Show(movie, room, LocalDate.now());
        assertThat(movie.getId()).isNull();
        showDao.save(show);
        assertThat(movie.getId()).isNotNull();
        showDao.remove(show);
        assertThat(show.getMovie().getId()).isNotNull();
        Assertions.assertThat(showDao.findById(show.getId())).isNull();
    }
}

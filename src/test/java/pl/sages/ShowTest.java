package pl.sages;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;
import pl.sages.persistance.ShowDao;

import java.time.LocalDate;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = App.class)
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

    //@Test
    //public void findAllTest(){
    //    Assert.notNull(roomDao.findAll(), "no proper RoomDao result");
    //}
}

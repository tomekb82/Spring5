package pl.sages;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;
import pl.sages.persistance.ReservationDao;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by jzamojski on 2018-08-22.
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = App.class)
public class ReservationTest {

    @Autowired
    ReservationDao reservationDao;

    @Test
    public void findByIdTest(){
        assertThat(reservationDao.findById(1L)).isNotNull();
    }

    @Test
    public void findAllTest() {
        assertThat(reservationDao.findAll()).isNotNull();
    }


}

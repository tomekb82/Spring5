package pl.sages;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.sages.persistance.MovieDao;
import pl.sages.persistance.model.Movie;
import pl.sages.service.MovieService;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = App.class)
public class MovieServiceTest {

    @InjectMocks
    @Autowired
    MovieService movieService;

    @Mock
    MovieDao movieDao;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        when(movieDao.findByTitle(any())).thenReturn(new Movie());
        when(movieDao.findAll()).thenReturn(Arrays.asList());
    }

    @Test
    public void findByIdTitle(){
        assertThat(movieService.findMovie("some movie")).isNotNull();
        verify(movieDao, times(1)).findByTitle(any());
    }

    @Test
    public void findAll(){
        assertThat(movieService.findAll()).isNotNull();
        verify(movieDao, times(1)).findAll();
    }
}

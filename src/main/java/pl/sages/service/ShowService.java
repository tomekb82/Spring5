package pl.sages.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sages.persistance.ShowDao;
import pl.sages.persistance.model.Show;

import java.time.LocalDate;
import java.util.List;

@Service
public class ShowService {

    private ShowDao showDao;

    @Autowired
    public ShowService(ShowDao showDao) {
        this.showDao = showDao;
    }

    public Show findByDate(LocalDate date) {
        return showDao.findByDate(date);
    }

    public List<Show> findAll() {
        return showDao.findAll();
    }


}

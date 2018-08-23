package pl.sages.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sages.persistance.ReservationDao;
import pl.sages.persistance.model.Reservation;

import java.util.List;

/**
 * Created by jzamojski on 2018-08-22.
 */

//@Service
public class ReservationService {

    private ReservationDao reservationDao;

    @Autowired
    public ReservationService(ReservationDao reservationDao) {
        this.reservationDao = reservationDao;
    }

    public Reservation findReservation(Long id) {
        return reservationDao.findById(id);
    }

    public List<Reservation> findAll() {
        return reservationDao.findAll();
    }


}

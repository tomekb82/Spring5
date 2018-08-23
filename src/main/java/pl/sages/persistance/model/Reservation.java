package pl.sages.persistance.model;

import javax.persistence.*;

/**
 * Created by jzamojski on 2018-08-22.
 */
@Entity
@Table(name = "RESERVATION")
public class Reservation extends AbstractEntity{

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "show_id")
    private Show show;

    public Reservation() {
    }

    public Reservation(Long id, Show show) {
        super(id);
        this.show = show;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + this.getId() + " " +
                "show=" + show +
                '}';
    }
}

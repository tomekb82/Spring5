package pl.sages.persistance.model;

/**
 * Created by jzamojski on 2018-08-22.
 */
public class Reservation extends AbstractEntity{

    private User user;

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

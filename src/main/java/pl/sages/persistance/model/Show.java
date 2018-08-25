package pl.sages.persistance.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "SHOW")
public class Show extends AbstractEntity{

    @ManyToOne(cascade = CascadeType.PERSIST )
    @JoinColumn(name="movie_id", nullable = false)
    private Movie movie;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="room_id", nullable = false)
    private Room room;

    private LocalDate date;

    public Show(){}

    public Show(Movie movie, Room room, LocalDate date) {
        this.movie = movie;
        this.room = room;
        this.date = date;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Show{" +
                "movie=" + movie +
                ", room=" + room +
                ", date=" + date +
                '}';
    }
}

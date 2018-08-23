package pl.sages.persistance.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CINEMA")
public class Cinema extends AbstractEntity {

    private String name;

    // przykład zapytania bi-directional
    @OneToMany(mappedBy = "cinema", fetch = FetchType.LAZY)
    private List<Room> room;

    public Cinema() {
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "name='" + name + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Room> getRoom() {
        return room;
    }

    public void setRoom(List<Room> room) {
        this.room = room;
    }
}

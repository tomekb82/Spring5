package pl.sages.persistance.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "CINEMA")
@JsonIgnoreProperties(ignoreUnknown=true, value = {"hibernateLazyInitializer", "handler", "created"})
public class Cinema extends AbstractEntity {

    private String name;

    // przykład zapytania bi-directional
    @JsonIgnore
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

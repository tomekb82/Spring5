package pl.sages.persistance.model;

public class Room extends AbstractEntity{

    private Integer number;

    private Integer capacity;

    private Cinema cinema;

    public Room() {
    }

    public Room(Long id) {
        super(id);
    }


    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }


    @Override
    public String toString() {
        return "Room{" +
                "number=" + number +
                ", capacity=" + capacity +
                ", cinema=" + cinema +
                '}';
    }
}

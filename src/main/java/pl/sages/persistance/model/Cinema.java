package pl.sages.persistance.model;

public class Cinema extends AbstractEntity {
    private String name;

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
}

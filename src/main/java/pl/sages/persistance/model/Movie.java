package pl.sages.persistance.model;

import java.math.BigDecimal;

public class Movie extends AbstractEntity {

    private String title;
    private BigDecimal price;

    public Movie() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}

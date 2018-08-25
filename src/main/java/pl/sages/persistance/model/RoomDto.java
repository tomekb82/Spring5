package pl.sages.persistance.model;

import com.querydsl.core.annotations.QueryProjection;

public class RoomDto {

    private Integer number;
    private Integer capacity;
    private String cinameName;

    @QueryProjection
    public RoomDto(Integer number, Integer capacity, String cinameName) {
        this.number = number;
        this.capacity = capacity;
        this.cinameName = cinameName;
    }

    public Integer getNumber() {
        return number;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public String getCinameName() {
        return cinameName;
    }
}

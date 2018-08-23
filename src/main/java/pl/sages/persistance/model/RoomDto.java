package pl.sages.persistance.model;

import com.querydsl.core.annotations.QueryProjection;

public class RoomDto {

    private Integer number;
    private Integer capacity;

    @QueryProjection
    public RoomDto(Integer number, Integer capacity) {
        this.number = number;
        this.capacity = capacity;
    }

    public Integer getNumber() {
        return number;
    }

    public Integer getCapacity() {
        return capacity;
    }
}

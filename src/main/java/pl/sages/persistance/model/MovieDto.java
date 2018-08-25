package pl.sages.persistance.model;

import com.querydsl.core.annotations.QueryProjection;

public class MovieDto {

    private String title;

    @QueryProjection
    public MovieDto(String title) {
        this.title = title;
    }
}

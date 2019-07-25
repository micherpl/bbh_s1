package com.pivovarit.movies.api;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;
import java.util.Objects;

public class MovieDto {

    @NotNull
    @PositiveOrZero
    private final Long id;

    @NotNull
    private final String title;

    @NotNull
    private final MovieTypeDto type;

    public MovieDto(Long id, String title, MovieTypeDto type) {
        this.id = id;
        this.title = title;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public MovieTypeDto getType() {
        return type;
    }

    @Override
    public String toString() {
        return "MovieDto{" +
          "id=" + id +
          ", title='" + title + '\'' +
          ", type=" + type +
          '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieDto movieDto = (MovieDto) o;
        return Objects.equals(id, movieDto.id) &&
          Objects.equals(title, movieDto.title) &&
          Objects.equals(type, movieDto.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, type);
    }
}

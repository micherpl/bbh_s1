package com.pivovarit.movies.domain;

import com.pivovarit.movies.api.MovieDto;
import com.pivovarit.movies.api.MovieTypeDto;
import com.pivovarit.movies.api.MovieWithDetailsDto;

class MovieCreator {

    static Movie from(MovieDto filmDto) {
        if (filmDto == null) return null; // FIXME

        return new Movie(new MovieId(filmDto.getId()), filmDto.getTitle(), MovieType
          .valueOf(filmDto.getType().getMovieType()));
    }

    static MovieWithDetailsDto from(Movie movie, String description) {
        if (movie == null) return null;  // FIXME

        return new MovieWithDetailsDto(movie.getId().getId(), movie.getTitle(), description, new MovieTypeDto(movie
          .getType().toString()));
    }

    static MovieDto from(Movie movie) {
        if (movie == null) return null;  // FIXME

        return new MovieDto(movie.getId().getId(), movie.getTitle(), new MovieTypeDto(movie
          .getType().toString()));
    }
}

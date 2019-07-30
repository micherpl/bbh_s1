package com.pivovarit.movies.domain;

import com.pivovarit.movies.api.MovieDto;
import com.pivovarit.movies.api.MovieTypeDto;

class MovieCreator {

    static Movie from(MovieDto filmDto) {
        if (filmDto == null) return null; // FIXME

        return new Movie(new MovieId(filmDto.getId()), filmDto.getTitle(), MovieType
          .valueOf(filmDto.getType().getMovieType()));
    }

    static MovieDto from(Movie movie) {
        if (movie == null) return null;  // FIXME

        return new MovieDto(movie.getId().getId(), movie.getTitle(), new MovieTypeDto(movie.getType().toString()));
    }
}

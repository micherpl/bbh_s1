package com.pivovarit.movies.domain;

import com.pivovarit.movies.api.MovieDto;

class MovieCreator {

    static Movie from(MovieDto filmDto) {
        return new Movie(new MovieId(filmDto.getId()), filmDto.getTitle(), MovieType.valueOf(filmDto.getType().getMovieType()));
    }
}

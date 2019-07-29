package com.pivovarit.movies.domain;

import com.pivovarit.movies.api.MovieDto;
import com.pivovarit.movies.api.MovieTypeDto;

class MovieService {

    private final MovieCreator movieCreator;
    private final MovieRepository movieRepository;

    public MovieService(MovieCreator movieCreator, MovieRepository movieRepository) {
        this.movieCreator = movieCreator;
        this.movieRepository = movieRepository;
    }

    public MovieDto getMovie(Long id) {
        return new MovieDto(id, "Spiderman", new MovieTypeDto("NEW"));
    }
}

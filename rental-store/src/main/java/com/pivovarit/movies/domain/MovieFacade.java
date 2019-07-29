package com.pivovarit.movies.domain;

import com.pivovarit.movies.api.MovieDto;
import com.pivovarit.movies.api.MovieTypeDto;

public class MovieFacade {

    public MovieFacade(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    private final MovieRepository movieRepository;

    public MovieDto getMovie(Long id) {
        return null;
    }

    public MovieDto getMovie(String title) {
        return null;
    }

    public void addMovie(MovieDto movie) {
    }
}

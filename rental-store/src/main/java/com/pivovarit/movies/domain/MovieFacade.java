package com.pivovarit.movies.domain;

import com.pivovarit.movies.api.MovieDto;
import com.pivovarit.movies.api.MovieTypeDto;

public class MovieFacade {

    public MovieFacade(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    private final MovieRepository movieRepository;

    public MovieDto getMovie(Long id) {
        return MovieCreator.from(movieRepository.findById(new MovieId(id)));
    }

    public MovieDto getMovie(String title) {
        return MovieCreator.from(movieRepository.findByTitle(title).get()); // get() is temporary
    }

    public void addMovie(MovieDto movie) {
        movieRepository.save(MovieCreator.from(movie));
    }
}

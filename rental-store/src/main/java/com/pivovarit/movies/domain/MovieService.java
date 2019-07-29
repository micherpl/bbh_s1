package com.pivovarit.movies.domain;

class MovieService {

    private final MovieCreator movieCreator;
    private final MovieRepository movieRepository;

    public MovieService(MovieCreator movieCreator, MovieRepository movieRepository) {
        this.movieCreator = movieCreator;
        this.movieRepository = movieRepository;
    }
}

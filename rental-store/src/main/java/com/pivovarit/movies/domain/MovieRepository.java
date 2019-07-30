package com.pivovarit.movies.domain;

import java.util.Collection;
import java.util.Optional;

interface MovieRepository {
    MovieId save(Movie movie);

    Movie findById(MovieId id);
    Collection<Movie> findAll();

    Optional<Movie> findByTitle(String title);
}

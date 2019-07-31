package com.pivovarit.movies.domain;

import java.util.Collection;
import java.util.Optional;

interface MovieRepository {
    void save(Movie movie);

    Optional<Movie> findById(MovieId id);
    Collection<Movie> findAll();

    Optional<Movie> findByTitle(String title);
}

package com.pivovarit.movies.domain;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
interface MovieRepository {
    MovieId save(Movie movie);

    Collection<Movie> findAll();
    Optional<Movie> findByTitle(String title);
}

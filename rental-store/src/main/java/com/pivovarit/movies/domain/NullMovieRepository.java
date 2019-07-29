package com.pivovarit.movies.domain;

import java.util.Collection;
import java.util.Optional;

class NullMovieRepository implements MovieRepository {
    @Override
    public MovieId save(Movie movie) {
        return null;
    }

    @Override
    public Collection<Movie> findAll() {
        return null;
    }

    @Override
    public Optional<Movie> findByTitle(String title) {
        return Optional.empty();
    }
}

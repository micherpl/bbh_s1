package com.pivovarit.movies.domain;

import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

class InMemoryMovieRepository implements MovieRepository {

    private final ConcurrentMap<Long, Movie> movies = new ConcurrentHashMap<>();

    @Override
    public MovieId save(Movie movie) {
        movies.put(movie.getId().getId(), movie);
        return movie.getId();
    }

    @Override
    public Collection<Movie> findAll() {
        return movies.values();
    }

    @Override
    public Optional<Movie> findByTitle(String title) {
        return movies.values()
          .stream()
          .filter(movie -> movie.getTitle().equals(title))
          .findAny();
    }
}

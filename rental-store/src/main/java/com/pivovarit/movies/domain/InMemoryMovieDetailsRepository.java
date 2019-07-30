package com.pivovarit.movies.domain;

class InMemoryMovieDetailsRepository implements MovieDetailsRepository {
    @Override
    public MovieDetails findById(Long id) {
        return new MovieDetails("Details for in mem repo " + id);
    }
}

package com.pivovarit.movies.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
class JpaMovieRepository implements MovieRepository {

    private final SpringDataMovieRepository springDataMovieRepository;

    @Override
    public void save(Movie movie) {
        springDataMovieRepository.save(from(movie));
    }

    @Override
    public Optional<Movie> findById(MovieId id) {
        return springDataMovieRepository.findById(id.getId())
          .map(JpaMovieRepository::from);
    }

    @Override
    public Collection<Movie> findAll() {
        return springDataMovieRepository.findAll().stream()
          .map(JpaMovieRepository::from)
          .collect(Collectors.toList());
    }

    @Override
    public Optional<Movie> findByTitle(String title) {
        return springDataMovieRepository.findByTitle(title)
          .map(JpaMovieRepository::from);
    }

    private static PersistedMovie from(Movie movie) {
        return new PersistedMovie(movie.getId().getId(), movie.getTitle(), movie.getType().toString());
    }

    private static Movie from(PersistedMovie movie) {
        return new Movie(
          new MovieId(movie.getId()),
          movie.getTitle(),
          MovieType.valueOf(movie.getType()));
    }
}

package com.pivovarit.movies.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Optional;

@RequiredArgsConstructor
class JdbcTemplateMovieRepository implements MovieRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public void save(Movie movie) {
        jdbcTemplate.update("INSERT INTO movie VALUES (?,?,?)", movie.getId().getId(), movie.getTitle(), movie.getType().toString());
    }

    @Override
    public Optional<Movie> findById(MovieId id) {
        return jdbcTemplate.query("SELECT * FROM movie WHERE id = ?", movieMapper(), id.getId())
          .stream()
          .findAny();
    }


    private static RowMapper<Movie> movieMapper() {
        return (rs, __) -> new Movie(
          new MovieId(rs.getLong("id")),
            rs.getString("title"),
            MovieType.valueOf(rs.getString("type")));
    }

    @Override
    public Collection<Movie> findAll() {
        return jdbcTemplate.query("SELECT * FROM movie", movieMapper());
    }

    @Override
    public Optional<Movie> findByTitle(String title) {
        return jdbcTemplate.query("SELECT * FROM movie WHERE title = ?", movieMapper(), title)
          .stream()
          .findAny();
    }
}

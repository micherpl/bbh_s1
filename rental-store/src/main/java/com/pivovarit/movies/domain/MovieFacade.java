package com.pivovarit.movies.domain;

import com.pivovarit.movies.api.MovieDto;
import com.pivovarit.movies.api.MovieTypeDto;
import com.pivovarit.movies.api.MovieWithDetailsDto;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@RequiredArgsConstructor
public class MovieFacade {

    private final MovieDetailsRepository movieDetailsRepository;
    private final MovieRepository movieRepository;

    public Optional<MovieWithDetailsDto> getMovie(Long id) {
        MovieDetails details = movieDetailsRepository.findById(id);
        return movieRepository.findById(new MovieId(id))
          .map(m -> MovieCreator.from(m, details.getDetails()));
    }

    public Optional<MovieDto> getMovie(String title) {
        return movieRepository.findByTitle(title)
          .map(MovieCreator::from);
    }

    public void addMovie(MovieDto movie) {
        movieRepository.save(MovieCreator.from(movie));
    }
}

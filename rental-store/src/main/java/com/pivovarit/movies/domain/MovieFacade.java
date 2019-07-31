package com.pivovarit.movies.domain;

import com.pivovarit.movies.api.MovieDto;
import com.pivovarit.movies.api.MovieIdDto;
import com.pivovarit.movies.api.MovieNotFoundException;
import com.pivovarit.movies.api.MovieTypeDto;
import com.pivovarit.movies.api.MovieWithDetailsDto;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class MovieFacade {

    private final MovieDetailsRepository movieDetailsRepository;
    private final MoviePriceCalculator moviePriceCalculator;
    private final MovieRepository movieRepository;

    public Collection<MovieDto> findAll() {
        return movieRepository.findAll()
          .stream()
          .map(m -> MovieCreator.from(m))
          .collect(Collectors.toList());
    }

    public Optional<MovieWithDetailsDto> getMovie(Long id) {
        MovieDetails details = movieDetailsRepository.findById(id);
        return movieRepository.findById(new MovieId(id))
          .map(m -> MovieCreator.from(m, details.getDetails()));
    }

    public Optional<MovieDto> getMovie(String title) {
        return movieRepository.findByTitle(title)
          .map(MovieCreator::from);
    }

    public int getPrice(MovieIdDto id) {
        return movieRepository.findById(new MovieId(id.getMovieId()))
          .map(moviePriceCalculator::calculatePrice)
          .orElseThrow(MovieNotFoundException::new);
    }

    public void addMovie(MovieDto movie) {
        movieRepository.save(MovieCreator.from(movie));
    }
}

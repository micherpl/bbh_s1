package com.pivovarit.movies.domain;

import com.pivovarit.movies.api.MovieDto;
import com.pivovarit.movies.api.MovieTypeDto;
import com.pivovarit.movies.api.MovieWithDetailsDto;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
public class MovieFacade {

    private final MovieDetailsRepository movieDetailsRepository;
    private final MovieRepository movieRepository;

    public MovieWithDetailsDto getMovie(Long id) {
        MovieDetails details = movieDetailsRepository.findById(id);
        return MovieCreator.from(movieRepository.findById(new MovieId(id)), details.getDetails());
    }

    public MovieDto getMovie(String title) {
        return MovieCreator.from(movieRepository.findByTitle(title).get()); // get() is temporary
    }

    public void addMovie(MovieDto movie) {
        movieRepository.save(MovieCreator.from(movie));
    }
}

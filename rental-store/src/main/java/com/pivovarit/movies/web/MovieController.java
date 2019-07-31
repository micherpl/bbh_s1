package com.pivovarit.movies.web;

import com.pivovarit.movies.api.MovieIdDto;
import com.pivovarit.movies.api.MovieWithDetailsDto;
import com.pivovarit.movies.domain.MovieFacade;
import lombok.Data;
import org.springframework.http.CacheControl;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/movies")
class MovieController {

    private final MovieFacade movieFacade;

    public MovieController(MovieFacade movieFacade) {
        this.movieFacade = movieFacade;
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieWithDetailsDto> getMovie(@PathVariable Long id) {
        Optional<MovieWithDetailsDto> movie = movieFacade.getMovie(id);

        if (movie.isPresent()) {
            return ResponseEntity
              .status(200)
              .contentType(MediaType.APPLICATION_JSON_UTF8)
              .cacheControl(CacheControl.noCache())
              .lastModified(29323L)
              .body(movie.get());
        } else {
            return ResponseEntity.notFound()
              .build();
        }
    }

    @GetMapping("/{id}/price")
    public MoviePrice getPrice(@PathVariable Long id) {
        return new MoviePrice(movieFacade.getPrice(new MovieIdDto(id)));
    }

    @Data
    public static class MoviePrice {
        private final int price;
    }
}

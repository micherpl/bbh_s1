package com.pivovarit.movies.web;

import com.pivovarit.movies.api.MovieDto;
import com.pivovarit.movies.api.MovieIdDto;
import com.pivovarit.movies.api.MovieWithDetailsDto;
import com.pivovarit.movies.domain.MovieFacade;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.Data;
import org.springframework.http.CacheControl;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api/movies")
class MovieController {

    private final MovieFacade movieFacade;

    public MovieController(MovieFacade movieFacade) {
        this.movieFacade = movieFacade;
    }

    @ApiOperation(value = "Fetch all movies", nickname = "Fetch movies")
    @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Success", response = MovieDto.class, responseContainer = "List"),
      @ApiResponse(code = 401, message = "Unauthorized"),
      @ApiResponse(code = 403, message = "Forbidden"),
      @ApiResponse(code = 404, message = "Not Found"),
      @ApiResponse(code = 500, message = "Failure")})
    @GetMapping
    Collection<MovieDto> getFilms() {
        return movieFacade.findAll();
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

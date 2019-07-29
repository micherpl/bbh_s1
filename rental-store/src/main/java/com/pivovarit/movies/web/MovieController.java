package com.pivovarit.movies.web;

import com.pivovarit.movies.api.MovieDto;
import com.pivovarit.movies.domain.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movies")
class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/{id}")
    public MovieDto ping(@PathVariable Long id) {
        return movieService.getMovie(id);
    }
}

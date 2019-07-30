package com.pivovarit.movies.web;

import com.pivovarit.movies.api.MovieDto;
import com.pivovarit.movies.api.MovieWithDetailsDto;
import com.pivovarit.movies.domain.MovieFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movies")
class MovieController {

    private final MovieFacade movieFacade;

    public MovieController(MovieFacade movieFacade) {
        this.movieFacade = movieFacade;
    }

    @GetMapping("/{id}")
    public MovieWithDetailsDto ping(@PathVariable Long id) {
        return movieFacade.getMovie(id);
    }
}

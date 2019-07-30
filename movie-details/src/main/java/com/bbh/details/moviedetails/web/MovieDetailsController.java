package com.bbh.details.moviedetails.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
class MovieDetailsController {

    @GetMapping("/api/details/{id}")
    MovieDetails details(@PathVariable Long id) {
        return new MovieDetails("Details of id: " + id);
    }

    @GetMapping("/ping")
    String ping() {
        return "pong";
    }
}


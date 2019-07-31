package com.pivovarit.movies;

import com.pivovarit.movies.api.MovieDto;
import com.pivovarit.movies.api.MovieTypeDto;
import com.pivovarit.movies.domain.MovieFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
class ApplicationRunner implements CommandLineRunner {

    @Value("${bbh.message}")
    private String message;

    @Autowired
    private MovieFacade movieFacade;

    @Override
    public void run(String... args) throws Exception {
        movieFacade.addMovie(new MovieDto(42L, "familiada", new MovieTypeDto("NEW")));
    }
}

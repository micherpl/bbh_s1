package com.pivovarit.movies.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class MovieConfiguration {

    @Bean
    MovieRepository movieRepository() {
        return new InMemoryMovieRepository();
    }

    @Bean
    MovieService movieService(MovieRepository movieRepository){
        return new MovieService(new MovieCreator(), movieRepository);
    }

    @Bean
    MovieFacade movieFacade() {
        return new MovieFacade(new InMemoryMovieRepository());
    }
}

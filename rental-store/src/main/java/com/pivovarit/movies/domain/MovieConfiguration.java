package com.pivovarit.movies.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
class MovieConfiguration {

    @Autowired
    private DataSource dataSource;

    @Bean
    @Profile("in-mem")
    MovieRepository movieRepository() {
        return new InMemoryMovieRepository();
    }

    @Bean
    MovieService movieService(MovieRepository movieRepository){
        return new MovieService(new MovieCreator(), movieRepository);
    }

    @Bean
    MovieFacade movieFacade(MovieDetailsRepository movieDetailsRepository) {
        return new MovieFacade(movieDetailsRepository ,new InMemoryMovieRepository());
    }

    @Bean
    @Profile("prod")
    MovieDetailsRepository movieDetailsRepository(@Value("${service.movie-details.url}") String url) {
        return new RestTemplateMovieDetailsRepository(url);
    }

    @Bean
    @Profile("in-mem")
    MovieDetailsRepository inMemMovieDetailsRepository() {
        return new InMemoryMovieDetailsRepository();
    }
}

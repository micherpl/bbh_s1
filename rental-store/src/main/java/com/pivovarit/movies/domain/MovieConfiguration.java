package com.pivovarit.movies.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
class MovieConfiguration {

    @Bean
    @Profile("jdbc")
    JdbcTemplate jdbcTemplate(DataSource datasource) {
        return new JdbcTemplate(datasource);
    }

    @Bean
    @Profile("jdbc")
    MovieRepository movieRepository(JdbcTemplate jdbc) {
        return new JdbcTemplateMovieRepository(jdbc);
    }

    @Bean
    @Profile("jpa")
    MovieRepository jpaMovieRepository(SpringDataMovieRepository springDataMovieRepository) {
        return new JpaMovieRepository(springDataMovieRepository);
    }

    @Bean
    MovieService movieService(MovieRepository movieRepository) {
        return new MovieService(new MovieCreator(), movieRepository);
    }

    @Bean
    MovieFacade movieFacade(MovieDetailsRepository movieDetailsRepository, MovieRepository movieRepository) {
        return new MovieFacade(movieDetailsRepository, movieRepository);
    }

    @Bean
    @Profile("prod")
    MovieDetailsRepository movieDetailsRepository(@Value("${service.movie-details.url}") String url) {
        return new RestTemplateMovieDetailsRepository(url);
    }

    @Bean
    @Profile("in-mem")
    MovieRepository inMemMovieRepository() {
        return new InMemoryMovieRepository();
    }

    @Bean
    @Profile({"in-mem","jdbc", "jpa"})
    MovieDetailsRepository inMemMovieDetailsRepository() {
        return new InMemoryMovieDetailsRepository();
    }
}

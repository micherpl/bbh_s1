package com.pivovarit.movies.domain;

import com.pivovarit.movies.api.MovieDto;
import com.pivovarit.movies.api.MovieWithDetailsDto;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringBootIntegrationTest {

    @Autowired
    private MovieFacade movieFacade;

    @LocalServerPort
    private int port;

    @Test
    public void shouldNotReturnAMovie() {
        Optional<MovieWithDetailsDto> movie = movieFacade.getMovie(42L);
        assertThat(movie).isEmpty();
    }
}
